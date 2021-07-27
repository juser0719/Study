package com.ssafy.day5.exception;

/**
 * @since 2021. 7. 8.
 */
public class ThrowsTest {
    public static void main(String[] args)   {
    	
        try {
			methodCall1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
        
        
        System.out.println("done");
    }

    private static void methodCall1() throws ClassNotFoundException   {
        methodCall2();
    }

    private static void methodCall2() throws ClassNotFoundException   {
        checkedExceptionMethod();
        uncheckedExceptionMethod();
    }

    private static void checkedExceptionMethod() throws ClassNotFoundException {
        Class.forName("Hello");
    }

    private static void uncheckedExceptionMethod() {
        int i = 1 / 0;
    }

}
