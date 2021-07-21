package com.ssafy.w0720.object;
/*
클래스명 : Student
-name:String
-kor:int
-mat:int
-eng:int

+Student()
+Student(name:String,kor:int,mat:int,eng:int)
+setter&getter  
+toString():String

+getTotal():int              <---- kor+eng+mat 를 리턴
+getAvg():double             <---- getTotal()를 3으로 나누어서 평균을 구한후 리턴
+getGrade():char             <---- getAvg()를 이용해서 A,B,C,D,F학점을 구해서 리턴
                                   90점이상 'A', 80점 이상 'B', 70점 이상 'C', 60점 이상 'D', 나머지 'F'
*/
public class Student {
	private String name;
	private int kor;
	private int mat;
	private int eng;
	
	public Student() {}
	public Student(String name, int kor,int mat,int eng) {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", mat=" + mat + ", eng=" + eng + "]";
	}
	public int getTotal () {
		return kor + mat + eng;
	}
	public double getAvg() {
		return (kor + mat+ eng)/3;
	}
	public char getGrade() {
		int avg = (int)this.getAvg();
		char grade = 'F';
	
		if(avg >= 90)
			grade = 'A';
		else if (avg >=80)
			grade = 'B';
		else if (avg >=70)
			grade = 'C';
		else if (avg >=60)
			grade = 'D';
		return grade;
		}
		
}
	

