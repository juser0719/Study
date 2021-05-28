#include <stdio.h>
#include <string.h>
unsigned int data = 0;
int M[0x100000 / 4] = { 0, };
int inst = 0;
int nop = 0;

int R_num, J_num, I_num, B_num = 0;
int M_acc = 0;
int npc = 0;
int pc = 0;
int gClock = 1;

int R[32] = { 0, };

int Read_Data1 = 0;
int Read_Data2 = 0;
int Write_Data = 0;

int SignEx = 0;
int mux1val, mux2val, mux3val, mux4val, mux5val = 0;
int ALUval2 = 0;
int ALUval1 = 0;
///////////////////////////////////////////////////////////
	int hit;
	int miss;
	int ReadMem(int pc);
	void WriteMem(int addr, int val);

	typedef struct {
	int tag;
	int old;
	int index;
	int valid;
	int dirty;
	int data[16];
	} cache_line;
	
	cache_line cache[64];
	
	int oldest(int what)

	{ int oldest;
      int young;
		for(int i = 1; i<64;i++)
		{
			if(cache[i].old < cache[i-1].old)
			{young = cache[i-1].old;
			 oldest = cache[i].old;}
			else 
			{young = cache[i].old;
			 oldest = cache[i-1].old;}
		}
	  if(what == 1)
	  return oldest;
	  else 
	  return young;
	}

	void updata()
	
	{
		

	
	}
	
	int ReadMem (int pc)
	{	

		int tag = (pc & 0xfffff000)>>12;//20bits
		int index = (pc & 0x00000fc0)>>6;//6bits
		int offset = (pc & 0x0000003f);//6bits  
		int start = (pc & 0xffffffc0);
		int drain = (cache[index].tag<<12)|(index<<6);
		int old = 1;
		int oldest;
		int young;
		if (cache[index].valid == 1)
		{
		  if (cache[index].tag == tag)//hit
		  {
			hit++;
			//printf("hit\n");	
		 	return cache[index].data[offset/4];//hit return
		  }

		  else //miss
		  { oldest = oldest(1);//find oldest index
			young = oldest(0);//find youngest index
			for(int i =0; i <64 ; i++)
		   {  if (cache[i].old == oldest)
		     {
		      for (int a = 0; a<16; a++ )
		      {
		       //M[(drain/4)+i] = cache[index].data[i];
		       cache[index].data[a] = M[(start/4)+a];
		      }
			  cache[i].old = young +1;
             }
		   }
		   miss++;
		   cache[index].tag = tag;
		   cache[index].valid = 1;
		   cache[index].dirty = 0;
	       return cache[index].data[offset/4];//miss return
		  }

		}

		else// cold-miss
		{
		  for (int i = 0; i<16; i++ )
			 cache[index].data[i] = M[(start/4)+i];
		 miss++;
	     cache[index].old = old;	
		 cache[index].dirty = 0;
		 cache[index].valid = 1;
		 cache[index].tag = tag;//tag miss fix
		 old ++;
		 return cache[index].data[offset/4];//cold miss return
		}
	
	}

	void WriteMem(int addr, int val)
	{
		int tag = (addr& 0xfffff000)>>12;//20bits
		int index = (addr & 0x00000fc0)>>6;//6bits
		int offset = (addr & 0x0000003f);//6bits  
		int start = (addr & 0xffffffc0);
		int drain = (cache[index].tag<<12)|(index<<6);
		
		if (cache[index].valid == 1)
	   {
		 if (cache[index].tag == tag)//hit
		  {
			hit++;
			//printf("hit\n");	
		 	cache[index].data[offset/4] = val;
			cache[index].dirty = 1;
		  } 
		 else //miss
		  {

		   if (cache[index].dirty == 1) // dirty =1
		   {
		   for (int i = 0; i<16; i++ )
		   {M[(drain/4)+i] = cache[index].data[i];
		   cache[index].data[i] = M[(start/4)+i];}
           }	
		   else //dirty = 0
		   {
		   for (int i = 0; i<16; i++ )
		   cache[index].data[i] = M[(start/4)+i];
		   }
		   miss++;
		   cache[index].tag = tag;
		   cache[index].data[offset/4] = val;
		   cache[index].dirty = 1;
		   cache[index].valid = 1;
		  }

	   } 
	 
		else // cold-miss
	   {
		  for (int i = 0; i<16; i++ )
		  cache[index].data[i] = M[(start/4)+i];

		 miss++;
		 cache[index].valid = 1;
		 cache[index].tag = tag;
		 cache[index].dirty = 1;
		 cache[index].data[offset/4] = val;
		 
	   }
			
	}

////////////////////////////////////////////////////////////

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
/////////////////////
void IF();
void ID_RF();
void EX_AG();
void Mem();
void WB();
////////////////////

void Store();
void Decode();
void Control();
void SignExtend();
void RegFun();
void ALU1();
void ALU2();
void mux1();
void mux2();
void mux3();
void mux4();
void mux5();
void DataMemory();

/////////////////////

void ID_RF()

{
	Decode();// bit 분할
	Control();//
	SignExtend();
	mux1();
	mux2();
}

void EX_AG()

{
	ALU2();
	ALU1();
	mux4();
}

void Mem()
{
	if (ConSign.MemWrite == 1)//Sw
	{
		M_acc++;
		WriteMem(ALUval1,R[Inst.rt]);
		//M[ALUval1 / 4] = R[Inst.rt];
	}
	if (ConSign.MemRead == 1) //LW
	{
		M_acc++;
		Read_Data1 = ReadMem(ALUval1);
		//Read_Data1 = M[ALUval1 / 4];
	}
	mux3();
}

void WB()
{
	if (ConSign.RegWrite == 1) {
		R[mux1val] = mux3val;
	}
	mux5();
	pc = mux5val;
}

void print();

void StIn()

{
	memset(&Inst, 0, sizeof(format));
	memset(&ConSign, 0, sizeof(control));
}

void IF()

{
	inst = ReadMem(pc);
	npc = pc + 4;

}

////////////////////////////////////////////////////////////////////

void Store() //stored inst to memory

{
	FILE * fp = NULL;
	fp = fopen("test_prog/input4.bin", "r");
	int i = 0;
	StIn();

	if (fp == NULL)
	{
		printf("no  file : %s \n", "simple.bin4");
		return;
	}

	while (fread(&data, sizeof(int), 1, fp))//제대로  instruction을  메모리에  저장.
	{
	inst = (((data & 0xff) << 24) | ((data & 0x0000ff00) << 8) |
			((data & 0xff000000) >> 24) | ((data & 0x00ff0000) >> 8));

		M[i++] = inst;
	}
}

//////////////////////////////////////////////////////////////////////

void Control()

{
	if (Inst.opcode == 0)
	{
		ConSign.RegDest = 1;
		ConSign.ALUOp = 1;
	}	
	else
	{
		ConSign.RegDest = 0;
		ConSign.ALUOp = 0; //I타입
	}

	if ((Inst.opcode != 0) && (Inst.opcode != 4) && (Inst.opcode != 5))
	{
		ConSign.ALUSrc = 1;
	}
	else
	{
		ConSign.ALUSrc = 0;
	}
	if (Inst.opcode == 0x23)//LW

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

	if ((Inst.opcode != 0x2b) && (Inst.opcode != 0x3) && (Inst.opcode != 4) && (Inst.opcode != 5) && (Inst.opcode != 2) && !((Inst.opcode == 0) && (Inst.funct == 8)))
	{
		ConSign.RegWrite = 1;
	}
	else
	{
		ConSign.RegWrite = 0;
	}
	if (Inst.opcode == 0x2b)
	{
		ConSign.MemWrite = 1; // SW
		ConSign.ALUOp = 4;
	}
	else
		ConSign.MemWrite = 0;

	if ((Inst.opcode == 2) || (Inst.opcode == 3))
	{
		ConSign.Jump = 1;
		ConSign.ALUOp = 2;
	}// J, JAL
	else
		ConSign.Jump = 0;

	if ((Inst.opcode == 4) || (Inst.opcode == 5))
	{
		ConSign.Branch = 1;
		ConSign.ALUOp = 5;
	}// Branch
	else
		ConSign.Branch = 0;
}

/////////////////////////////////////////////////////////////////////////////
void Decode()
{
	Inst.opcode = ((M[pc / 4] & 0xfc000000) >> 26) & 0x3f;
	Inst.rs = ((M[pc / 4] & 0x03e00000) >> 21);
	Inst.rt = ((M[pc / 4] & 0x001f0000) >> 16);//mux 
	Inst.rd = ((M[pc / 4] & 0x0000f800) >> 11);//mux
	Inst.shampt = ((M[pc / 4] & 0x000007c0) >> 6);
	Inst.funct = (M[pc / 4] & 0x0000003f);
	Inst.imm = (M[pc / 4] & 0x0000ffff);
	Inst.address = (M[pc / 4] & 0x03ffffff);

	if (inst == 0x0)
		nop++;
}

void RegFun()
{
	if (ConSign.RegWrite == 1)
	{
		R[mux1val] = mux3val;
	}
}
//////////////////////////////////////////////////////////////////////
void SignExtend()
{
	if (Inst.imm >> 15 == 1) //보수
	{
		SignEx = (Inst.imm | 0xFFFF0000);
	}
	else SignEx = (Inst.imm | 0x0);
	return;
}
///////////////////////////////////////////////////////////////////////
void ALU1()
{
	if (ConSign.ALUOp == 0)//I type
	{
		I_num++;
		switch (Inst.opcode)
		{
		case 0x8:
		case 0x9: ALUval1 = R[Inst.rs] + mux2val;
			break;

		case 0xc: ALUval1 = (R[Inst.rs] & Inst.imm);////////
			break;

		case 0xf: ALUval1 = Inst.imm << 16;
			break;

		case 0xd: ALUval1 = R[Inst.rs] | Inst.imm;
			break;

		case 0xb:
		case 0xa: ALUval1 = ((R[Inst.rs] < mux2val) ? 1 : 0);
			break;

		default: break;
		}
	}
	else if (ConSign.ALUOp == 1)//R type
	{
		R_num++;
		switch (Inst.funct)
		{
		case 0x21:
		case 0x20: ALUval1 = (R[Inst.rs] + mux2val); return;
			break;

		case 0x24: ALUval1 = (R[Inst.rs] & mux2val); return;
			break;

		case 0x8: npc = R[Inst.rs]; return;
			break;

		case 0x27: ALUval1 = ~(R[Inst.rs] | mux2val); return;
			break;

		case 0x25: ALUval1 = (R[Inst.rs] | mux2val); return;
			break;

		case 0x2b:
		case 0x2a: ALUval1 = ((R[Inst.rs] < mux2val) ? 1 : 0); return;
			break;

		case 0x0: ALUval1 = mux2val << Inst.shampt; return;
			break;

		case 0x02: ALUval1 = mux2val >> Inst.shampt; return;
			break;

		case 0x22: ALUval1 = (R[Inst.rs] - mux2val);  return;
			break;

		case 0x23: ALUval1 = (R[Inst.rs] - mux2val);  return;
			break;

		case 0x9: ALUval1 = pc + 4;
			npc = R[Inst.rs];
			break;

		default: break;
		}
	}
	else if (ConSign.ALUOp == 2)//J type
	{
		J_num++;
		switch (Inst.opcode)
		{
		case 0x02:npc = (pc & 0xF0000000) | ((inst & 0x03FFFFFF) << 2);
			break;

		case 0x03: R[31] = pc + 8;
			pc = (npc & 0xF0000000) | ((inst & 0x03FFFFFF) << 2);
			break;

		default: break;
		}
	}
	else if (ConSign.ALUOp == 3)//LW
	{
		I_num++;
		switch (Inst.opcode)
		{
		case 0x23:
		case 0x30:
			ALUval1 = R[Inst.rs] + mux2val;
			break; //LW

		default: break;
		}
	}
	else if (ConSign.ALUOp == 4)//Sw
	{
		I_num++;
		switch (Inst.opcode)
		{
		case 0x2b:
			ALUval1 = (R[Inst.rs] + mux2val);
			break;
		}
	}
	else if (ConSign.ALUOp == 5)//Bxx
	{
		I_num++;
		B_num++;
		switch (Inst.opcode)
		{
		case 0x4: if (R[Inst.rs] == R[Inst.rt])
		{
			if (0x00008000 & Inst.imm)
			{
				ALUval2 = pc + 4 + ((0xfffc0000) | (Inst.imm << 2));
			}
			else { ALUval2 = pc + 4 + (Inst.imm << 2); }//beq
		}
				  else
		{	//ConSign.Branch = 0;
			ALUval2 = pc + 4;//
		}
				  break;

		case 0x5:  if (R[Inst.rs] != R[Inst.rt])
		{
			if (0x00008000 & Inst.imm)
			{
				ALUval2 = pc + 4 + ((0xfffc0000) | (SignEx << 2));
			} //pc + Branch Address
			else { ALUval2 = pc + 4 + (SignEx << 2); }
		}
		    else
		{
			ALUval2 = pc + 4;
		}
				 break;
		}
	}
}

void ALU2()
{
	ALUval2 = (npc + (SignEx << 2));
}
/////////////////////////////////////////////////////////////////////////////////
void  mux1()
{
	if (ConSign.RegDest == 0)
	{
		mux1val = Inst.rt;
	}
	else if (Con		//print();Sign.RegDest == 1)
	{
		mux1val = Inst.rd;
	}
}

void  mux2()
{
	if (ConSign.ALUSrc == 0)
	{
		mux2val = R[Inst.rt];
	}//////////Inst.rd -> Inst.rt로 바꿈
	else if (ConSign.ALUSrc == 1)
	{
		mux2val = SignEx;
	}
}

void mux3()
{
	if (ConSign.MemToReg == 1) {
		mux3val = Read_Data1;
	}
	else if (ConSign.MemToReg == 0) {
		mux3val = ALUval1;
	}
}

void mux4()
{
	if (ConSign.Branch == 0)
		mux4val = npc;
	else if (ConSign.Branch == 1)
		mux4val = ALUval2;

}

void mux5()
{
	if (ConSign.Jump == 1)
	{
		mux5val = ((npc & 0xF0000000) | ((Inst.address) << 2));
	}
	//////////////////////////
	else if (ConSign.Jump == 0)
		mux5val = mux4val;
}
////////////////////////////////////////////////////////////////////////
void main()
{
	R[29] = 0x100000; // initial sp
	R[31] = 0xFFFFFFFF;// final return from main
	int Memory_index = 0;
	Store();
	int test = 0;//

	while (1)
	{
		if (pc == 0xffffffff) break;
		IF();
		ID_RF();
		EX_AG();
		Mem();
		WB();
		StIn();
		gClock++;
		//print();
	}
	print();
}

void input4print()

{
	printf("R[2] : %d\n", R[2]);
	printf("R[29] : 0x%08x\n\n\n", R[29]);
	printf("R[%d] : 0x%08x\nR[%d] : 0x%08x\nR[%d] : 0x%08x\n\n", Inst.rs, R[Inst.rs], Inst.rt, R[Inst.rt], Inst.rd, R[Inst.rd]);
	printf("R[30] : 0x%08x \nR[31] : 0x%08x\n\n", R[30], R[31]);
}

void print()

{
	//printf("Now pc : 0x%08x 	Now Inst : 0x%08x \n\n\n ", pc - 4, M[pc / 8]);
	printf("Final return value R[2] : %d\n ", R[2]);
	printf("Number of executed instruction : %d\n ", (R_num + I_num + J_num));
	printf("Number of R-type : %d\n ", R_num);
	printf("Number of I-type : %d\n ", I_num);
	printf("Number of J-type : %d\n ", J_num);
	printf("Number of Mem access : %d\n ", M_acc);
	printf("Number of branches : %d\n ", B_num);
	printf("Number of Hit  : %d\n",hit);
	printf("Number of Miss : %d\n",miss);
	printf("Number of Hit ration : %d\n",hit/(hit + miss));
}
