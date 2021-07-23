package com.ssafy.w0723.polymorphism;

//추상메서드가 없는 추상클래스---------------------------------
abstract class AA{
	public void view1() {}     //--1
	public void view2() {}     //--2
}
class BB extends AA{
	@Override
	public void view1() {}            //--3, 강제성이 없는 재정의
}
public class AbstractEx1 {
	public static void main(String[] args) {
//		AA ob=new AA();    // AA로 객체 생성 불가능
		
		AA ob2=new BB();   // 3, 2번 호출
		ob2.view1();
		ob2.view2();
	}
}
//추상메서드가 있는 추상클래스---------------------------------
/*
abstract class AA{
	abstract public void view1();     //--1
	public void view2() {}            //--2
}
class BB extends AA{
	@Override
	public void view1() {}            //--3, 강제성이 있는 재정의
}
public class AbstractEx1 {
	public static void main(String[] args) {
		//AA ob=new AA();    // AA로 객체 생성 불가능
		
		AA ob2=new BB();   // 3, 2번 호출
		ob2.view1();
		ob2.view2();
	}
}*/
//일반 클래스-------------------------------------------
/*
class AA{
	public void view1() {}     //--1
	public void view2() {}     //--2
}
class BB extends AA{
	@Override
	public void view1() {}      //--3, 강제성이 없는 재정의
}
public class AbstractEx1 {
	public static void main(String[] args) {
		AA ob=new AA();    // AA로 객체 생성 가능,  1번호출
		ob.view1();
		
		AA ob2=new BB();   // 3, 2번 호출
		ob2.view1();
		ob2.view2();
	}
}*/