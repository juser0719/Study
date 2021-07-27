package com.ssafy.w0727.interfaceex;

//인터페이스---------------------------------------------------------
interface Flyable{
	public void fly();
}
interface Cryable{
	public void cry();
}
class Eagle implements Flyable, Cryable{
	@Override
	public void fly() {
		System.out.println("독수리는 날아 다닙니다");
		cry();
	}

	@Override
	public void cry() {
		System.out.println("캬약~~캬약~~~");
	}
}
public class InterfaceEx2 {
	public static void main(String[] args) {
		new Eagle().fly();
	}
}
//추상클래스-----------------------------------------
/*
abstract class Flyable{
	abstract public void fly();
}
abstract class Cryable{
	abstract public void cry();
}
class Eagle extends Flyable{
	@Override
	public void fly() {
		System.out.println("독수리는 날아 다닙니다");
		new CryableEx().cry();
	}
	//중첩클래스(inner class): 클래스안에서 또 다른 클래스를 정의 하는것
	class CryableEx extends Cryable{
		@Override
		public void cry() {
			System.out.println("캬약~~캬약~~~");
		}
	}
}
public class InterfaceEx2 {
	public static void main(String[] args) {
		new Eagle().fly();
	}
}
*/