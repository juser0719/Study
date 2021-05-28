#include <stdio.h>
#include <string.h>
	unsigned int data = 0;
	int M[0x100000] = {0, };
	int inst ;
	int nop ;
	int WB_inst ;
	int cycle ;
	int R_num , J_num , I_num , B_num  ;
	int M_acc ;

	int npc ;
	int pc ;
	int gClock ;

	int R[32] = {0, };
	int Read_Data ;
	//int Read_Data1 = 0;
	//int Read_Data2 = 0;
	int Write_Data ;

	int SignEx ;

	int mux1val , mux2val , mux3val , mux4val, mux5val;

	int ALUval2 ;
	int ALUval1 ;
	int bcond ;
	typedef struct  
	{
	 int opcode;
	 int rs;
	 int rt;
	 int rd;
	 int shampt;
	 int funct;
	 int imm;
	 int address;
	} format;

	typedef struct
	{
	 int Jump;
	 int RegDest;
	 int Branch;
	 int MemRead;
	 int MemToReg;
	 int ALUOp;
	 int MemWrite;
	 int ALUSrc;
	 int RegWrite;
	} control;
	
	format Inst;
	control ConSign;
//////////////////////////////////////////////////////////////
	typedef struct
	{
	 int npc;
	 unsigned int inst;
	} IfId_lat;
//---------------------------------------------------------------	
	typedef struct
	{
	 int opcode;
	 int funct;///alu1에 필요.
	 int rt;
	 int rd;// mux1에 필요.
	 int imm;// signEx에 넣기위해 필요.
	 int signex;// alu2에 필요.
	 int shampt;

	 //int alu2;

	 int jumpadd;
	 int v1;
	 int v2;
	 int npc;
	 int mux2val;

	 int RegWrite;// mux1 val.
	 control con1;//control val.
	 unsigned int inst;//inst.
	} IdEx_lat;
//-----------------------------------------------------------------
	typedef struct
	{
	 int jumpadd;
	 //int Mux2val;
	 //int alu2;
	 int alu1;
	 int v2;//Read data2
	 int imm;
	 int npc;
	
	 control con2;
	 int RegWrite;
	 int inst;	
	} ExMem_lat;
//-----------------------------------------------------------------

	typedef struct
	{

	 int Read_Data;
	 int alu1;
	 //int alu2;	
	 int mux3val;
	 int jumpadd;
	 control con3;
	 int inst;
	 int npc;
	 int RegWrite;
	} MemWb_lat;
//-----------------------------------------------------------------
	IfId_lat IfId[3];//lat1
	IdEx_lat IdEx[3];//lat2
	ExMem_lat ExMem[3];//lat3
	MemWb_lat MemWb[3];//lat4

/////////////////////
	void IF();
	void ID_RF(IfId_lat lat1);
	void EX_AG(IdEx_lat lat2);
	void Mem(ExMem_lat lat3);
	void WB(MemWb_lat lat4);
////////////////////

	void Store ();
	void Decode(IfId_lat lat1);
	void DataDependance();
	void Control();
	void SignExtend();

	void lat_up();
	void print();
	void print4();
	void ALU1(IdEx_lat lat2);
	int ALU2(int pc4 , int signex);

	int mux1(int rt, int rd);
	int mux2(int v2, int signex);
	int mux3(int memdata , int alu1);
	int mux4(int pc4, int alu2);
	int mux5(int jump , int mux4val);
/////////////////////
	void ID_RF(IfId_lat lat1) // IfId[1] 받음.//ID
		{	cycle ++;
			Decode(lat1);// bit 분할 ,signex() 포함.

			Control();
			IdEx[0].con1 = ConSign;
			IdEx[0]. v1 = R[Inst.rs];
			IdEx[0]. v2 = R[Inst.rt];
			if (ConSign.Jump == 1)
			{pc =  ((lat1.npc)&0xf0000000)|(Inst.address <<2);J_num ++;  }//IdEx[1] -> IfId[1]

			mux1val = mux1(Inst.rt , Inst.rd); //Inst -> lat1
			IdEx[0].RegWrite = mux1val;
			
			DataDependance();

			mux2val = mux2(IdEx[0].v2 , IdEx[0].signex);
			IdEx[0].mux2val = mux2val;
		}

	void EX_AG(IdEx_lat lat2)// IdEx[1] 받음.//EX
		{	
			cycle ++;
			ALU1(lat2);
			ExMem[0].npc = lat2.npc;
			//ALUval2 = ALU2(lat2.npc, lat2.signex);
			//ExMem[0].alu2 = ALUval2;
			ExMem[0].alu1 = ALUval1;
			ExMem[0].v2 = lat2.v2;
			ExMem[0].jumpadd = lat2.jumpadd;
			ExMem[0].imm = lat2.imm;
			ExMem[0].con2 = lat2.con1;
			ExMem[0].RegWrite = lat2.RegWrite;
			ExMem[0].inst = lat2.inst;
		}

	void Mem(ExMem_lat lat3) // ExMem[1] 받아옴.//Mem
		{
		
			cycle++;
			if (lat3.con2.MemWrite == 1)//Sw
			{   M_acc ++;
				M[lat3.alu1/4] = lat3.v2; 
			}
			else if(lat3.con2.MemRead == 1) //LW
			{   M_acc ++;
				Read_Data = M[lat3.alu1/4]; // ALUval1 -> lat3.alu1
			}	
				mux3val = mux3 (Read_Data , lat3.alu1);
				MemWb[0].mux3val = mux3val;	
				MemWb[0].alu1 = lat3.alu1;
				MemWb[0].jumpadd = lat3.jumpadd;
				MemWb[0].npc = lat3.npc;
				MemWb[0].con3 = lat3.con2;
				MemWb[0].RegWrite = lat3.RegWrite;
				MemWb[0].inst = lat3.inst;


		}

	void WB(MemWb_lat lat4)//MemWb[1] 받음. // Wb
		{		if (lat4.con3.RegWrite ==1 )
			{
				R[lat4.RegWrite] = lat4.mux3val;
			}	
				cycle ++;
			    WB_inst = lat4.inst;
		}



	void StIn ()
		{
		memset (&IfId[0], 0, sizeof(IfId_lat));
		memset (&IdEx[0], 0, sizeof(IdEx_lat));
		memset (&ExMem[0], 0, sizeof(ExMem_lat));
		memset (&MemWb[0], 0, sizeof(MemWb_lat));

		}

	void IF ()/////IF//////
		{
		//printf("===================clock:%d===========================\n",gClock+1);
	//	printf("pc:%0x\n",pc);
		IfId[0].inst = M[pc/4];
		IfId[0].npc = pc + 4;
		pc = pc +4;
		
		}
////////////////////////////////////////////////////////////////////
	void Store () //stored inst to memory
	{
			FILE * fp = NULL;
			fp = fopen ("test_prog/simple3.bin", "rb"); 
			int i = 0;
			//StIn();
			if(fp == NULL)
			{
				printf("no  file : %s \n","simple.bin4");
				return;
 			}
		
		while(fread(&data,sizeof(int),1,fp))//제대로  instruction을  메모리에  저장.
		{	
			inst = (((data & 0xff)<< 24)|((data & 0x0000ff00)<<8)|
			   ((data & 0xff000000)>>24)| ((data & 0x00ff0000)>>8 ));

				M[i++] = inst;		
		}

	}
//////////////////////////////////////////////////////////////////////
	void Control ()
		{	
		  if(Inst.opcode==0)
		 {ConSign.RegDest = 1;
          ConSign.ALUOp = 1;}//R타입.
		else
		{ ConSign.RegDest = 0;
		  ConSign.ALUOp = 0; //I타입
		}

		 if((Inst.opcode !=0) && (Inst.opcode !=4) && (Inst.opcode !=5)) 
		 {ConSign.ALUSrc = 1;} 
        else 
		 {ConSign.ALUSrc = 0;}

		if(Inst.opcode==0x23)//LW
		{
		 ConSign.MemToReg = 1;
		 ConSign.MemRead = 1;
		 ConSign.ALUOp = 3;
		}						 
        else
		{
		 ConSign.MemToReg = 0;
		 ConSign.MemRead = 0;
		}

		 if((Inst.opcode!=0x2b)&& (Inst.opcode!=4) && (Inst.opcode!=5) && (Inst.opcode!=2) &&!((Inst.opcode==0) && (Inst.funct==8))&&(Inst.opcode != 0x3))//Ist.opcode! = 0x3 -> 삭제.
		 {ConSign.RegWrite = 1;}
        else
		 {ConSign.RegWrite = 0;}
		 
		 if(Inst.opcode==0x2b) 
		 {ConSign.MemWrite = 1; // SW
         ConSign.ALUOp = 4;}
		else
		 ConSign.MemWrite = 0;

		 if((Inst.opcode ==2) || (Inst.opcode ==3)) 
		 {ConSign.Jump = 1;}// J, JAL
        else
		 ConSign.Jump = 0;

		 if((Inst.opcode ==4) || (Inst.opcode ==5)) 
		 {ConSign.Branch = 1; 
		  ConSign.ALUOp = 5;}// Branch
		else 
		 ConSign.Branch = 0;						 	
		}
/////////////////////////////////////////////////////////////////////////////
	void Decode (IfId_lat lat1)// IfId[1]이 들어옴.
	 	 {
		Inst.opcode = (( lat1.inst& 0xfc000000)>>26) & 0x3f;
		Inst.rs = ((lat1.inst & 0x03e00000 )>>21);
		Inst.rt = ((lat1.inst & 0x001f0000 )>>16);//mux
		Inst.rd = ((lat1.inst & 0x0000f800 )>>11);//mux
		Inst.shampt = ((lat1.inst & 0x000007c0)>>6);
		Inst.funct = (lat1.inst & 0x0000003f);
		Inst.imm = (lat1.inst & 0x0000ffff);
		Inst.address = (lat1.inst & 0x03ffffff);

		IdEx[0].npc = lat1.npc;
		IdEx[0].jumpadd = (lat1.npc & 0xF0000000)|(Inst.address <<2);

		SignExtend();
		IdEx[0].opcode = Inst.opcode;
		IdEx[0].rt = Inst.rt;
		IdEx[0].rd = Inst.rd;
		IdEx[0].shampt = Inst.shampt;
		IdEx[0].funct = Inst.funct;
		IdEx[0].imm = Inst.imm;
	    IdEx[0].signex = SignEx;
	    IdEx[0].inst = lat1.inst; 
		
		if (lat1.inst == 0x0)
		nop++;

		 }
	
//////////////////////////////////////////////////////////////////////
    void DataDependance()
	{
 		if ((Inst.rs == IdEx[1].RegWrite)&&(Inst.rs !=0)&& (IdEx[1].con1.RegWrite))
		{
		 ALU1(IdEx[1]);
		 IdEx[0].v1 = ALUval1;
		 //printf("rs 거리 1 depen\n");
//		 ALUval1 = 0; //ALU reset.
		}
		else if ((Inst.rs == ExMem[1].RegWrite)&&(Inst.rs !=0)&&(ExMem[1].con2.RegWrite))
		{
		 	Read_Data	= M[ExMem[1].alu1/4];
			IdEx[0].v1 = mux3(Read_Data,ExMem[1].alu1);
			//printf("rs 거리 2 depen\n");
//			Read_Data = 0;
		}
		else {IdEx[0].v1 = R[Inst.rs];}	
		/////////////////////////////rs = v1
		if ((Inst.rt == IdEx[1].RegWrite)&& (Inst.rt!=0)&& (IdEx[1].con1.RegWrite))
		{
		 ALU1(IdEx[1]);
		 IdEx[0].v2 = ALUval1;
		 //printf("rt 거리 1 depen\n");
//		 ALUval1 = 0;
		}
		else if ((Inst.rt == ExMem[1].RegWrite)&&(Inst.rt !=0)&&(ExMem[1].con2.RegWrite))
		{
		 	Read_Data = M[ExMem[1].alu1/4];
			IdEx[0].v2 = mux3(Read_Data , ExMem[1].alu1);
			//printf("rt 거리 2 depen\n");
//			Read_Data = 0;
		}
		else {IdEx[0].v2 = R[Inst.rt];}
		/////////////////////////////rt = v2
	}
//////////////////////////////////////////////////////////////////////
	void SignExtend ()
		{
		if (Inst.imm>>15 == 1) //보수
			 
			{SignEx = (Inst.imm | 0xFFFF0000);}
			
		else SignEx = (Inst.imm | 0x0) ;
				
		return;
		}
///////////////////////////////////////////////////////////////////////
	void ALU1(IdEx_lat lat2)
		{	
			
		
			if (lat2.con1.ALUOp == 0)//I type
			{	I_num++;
				
				switch (lat2.opcode)
				{
					case 0x8 :	
					case 0x9 : ALUval1 = lat2.v1 + lat2.mux2val;
				 
					break;

					case 0xc : ALUval1 =  lat2.v1 & lat2.imm ;
					break;
	
			
					case 0xf : ALUval1 = lat2.imm <<16;

					break;
				
					case 0xd : ALUval1 = lat2.v1 | lat2.imm;

					break;
					
					case 0xb :
					case 0xa : ALUval1 = ( (lat2.v1< lat2.mux2val)? 1:0);
					
					break;
					
					case 0x3 : R[31] = lat2.npc +4 ;// pc = pc+8;
					
					break;
			  
					default : break;

					
				}
			}

		 else if (lat2.con1.ALUOp == 1)//R type
			{
				R_num++;
				
				switch (lat2.funct)
				{
					case 0x21 :
					case 0x20 : ALUval1 =( lat2.v1 + lat2.mux2val); return;

					break;

					case 0x24 : ALUval1 =( lat2.v1 & lat2.mux2val); return;

					break;
					
					case 0x8  : pc = lat2.v1;
								IfId[0]=IfId[2] ;	
					
					 return;

					break;

					case 0x27 : ALUval1 = ~(lat2.v1|lat2.mux2val); return;

					break;

					case 0x25 : ALUval1 =( lat2.v1| lat2.mux2val); return;

					break;

					case 0x2b :
					case 0x2a : ALUval1 = ((lat2.v1 < lat2.mux2val)? 1:0); return;

					break;

					case 0x0  : ALUval1 = lat2.mux2val << lat2.shampt; return;

					break;

					case 0x02 : ALUval1 = lat2.mux2val >> lat2.shampt; return;

					break;

					case 0x22 : ALUval1 = (lat2.v1 - lat2.mux2val);  return;
					break;

					case 0x23 : ALUval1 =( lat2.v1 - lat2.mux2val);  return;
					break;
					
				/*	case 0x9 : ALUval1 = pc + 4;
							   npc = R[Inst.rs];
					break;*/

					default : break;
				}	

			}

		 else if (lat2.con1.ALUOp == 3)//LW
			{	I_num++;
				ALUval1 = lat2.v1 + lat2.mux2val; 
			}

 		 else if (lat2.con1.ALUOp == 4)//Sw
			{  I_num++;
				ALUval1 = lat2.v1 + lat2.mux2val;
			}

 		 else if (lat2.con1.ALUOp == 5)//Bxx
			{  I_num++;
			   B_num++;
				switch (lat2.opcode)
					{
					case 0x4 : if (lat2.v1 == lat2.mux2val) //Inst.imm -> lat2.imm
						{	bcond = 1;
							if(0x00008000 & lat2.imm)
							{ pc = lat2.npc + ((0xfffc0000)|(lat2.imm <<2)); }	
							else
							{ pc = lat2.npc  + (lat2.imm<<2); }//beq
							IfId[0]=IfId[2];						
						}
						else
						{ bcond = 0;}
						
						break;

					case 0x5 :  if (lat2.v1 != lat2.mux2val) 
						{	bcond = 1;
							if(0x00008000 & lat2.imm) //Inst.imm -> lat2.imm
							{pc = lat2.npc + ((0xfffc0000)|(lat2.imm <<2));}//pc + Branch Address
							else {pc = lat2.npc + (lat2.imm <<2); }
							IfId[0]=IfId[2];	
						}
						else 
						 { bcond = 0;}
						break;
					
					 default : break;
					}
	
			}				
		}

	int ALU2 (int lat2npc , int lat2signex)
		{		
			return ( lat2npc + (lat2signex << 2));
			
		}
/////////////////////////////////////////////////////////////////////////////////
	int  mux1 (int rt , int rd)
		{
			if (ConSign.RegDest == 0)
		  	{ return rt;}
			else if (ConSign.RegDest == 1)
			{ return rd;}

		}

	int  mux2 (int v2, int signex) //IdEx[1] -> ConSigm
		{
			if(ConSign.ALUSrc == 0)
			{ return v2;}//////////Inst.rd -> Inst.rt로 바꿈
			else if(ConSign.ALUSrc == 1)
			{ return signex;}			
		}

	int mux3 (int memdata, int alu1)	
		{	
			if (ExMem[1].con2.MemToReg == 1){
			
			return memdata;
			}
			else if (ExMem[1].con2.MemToReg == 0){
			 return alu1;}
		}
	
/*	int mux4 (int pc4 , int alu2)
		{	
			if (IdEx[1].con1.Branch == 0)
			 return pc4;
			else if (IdEx[1].con1.Branch  == 1)
			 return ALUval2;
		}

	int mux5 (int jump , int mux4val)
		{	
			if (IdEx[1].con1.Jump == 1)
			{ return((npc & 0xF0000000)|((Inst.address)<<2)); }
			else if (IdEx[1].con1.Jump == 0)
			mux4val = mux4(MemWb[1].npc , mux4val );  
			return mux4val;
		}*/
////////////////////////////////////////////////////////////////////////////////
void main () 
{

	R[29] = 0x100000; // initial sp
	R[31] = 0xFFFFFFFF;// final return from main
	int Memory_index = 0;
	Store();
	int test = 0;//
	while (1)
		 {	
			if(pc == 0xffffffff) 
			{
				WB(MemWb[1]);
				Mem(ExMem[1]);
				lat_up();
				WB(MemWb[1]);
				break;		
						
			}

					
           	IF();
			WB(MemWb[1]);	
			ID_RF(IfId[1]);
			EX_AG(IdEx[1]);
			Mem(ExMem[1]);
			//WB(MemWb[1]);
			//lat_up();
			//print();
			lat_up();
			gClock ++;
			print4();
		 }
print4();
}


void print()

{
printf("If : 0x%08x\n", IfId[0].inst);
printf("Id : 0x%08x\n", IdEx[0].inst);
printf("Ex : 0x%08x\n", ExMem[0].inst);
printf("Mem: 0x%08x\n", MemWb[0].inst);
printf("Wb : 0x%08x\n\n",WB_inst );
printf("R[30] : 0x%08x\n",R[30]);
printf("R[29] : 0x%08x\n",R[29]);
printf("R[2] : %d\n",R[2]);
}

void print4() 
{
printf("Now pc : 0x%08x 	Now Inst : 0x%08x \n\n\n ",pc - 4, M[pc/8]);
printf("Final return value R[2] : %d\n ",R[2]);
printf("Number of executed instruction : %d\n ",(R_num + I_num + J_num));
printf("Number of R-type : %d\n ",R_num);
printf("Number of I-type : %d\n ",I_num);
printf("Number of J-type : %d\n ",J_num);
printf("Number of Mem access : %d\n ",M_acc);
printf("Number of branches : %d\n ",B_num);
printf("Number of Cycle : %d\n", gClock);
}

void lat_up()
{
IfId[1] = IfId[0];
IdEx[1] = IdEx[0];
ExMem[1] = ExMem[0];
MemWb[1] = MemWb[0];

}
