package com.ssafy.day5.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @since 2021. 7. 7.
 */
public class CheckedExceptionHandling {
    public static void main(String[] args) {
         
    	try {
			Class.forName("abc.Def"); // ClassNotFoundException
            new FileInputStream("Hello.java"); // FileNotFoundException
            DriverManager.getConnection("Hello"); // SQLException
		} catch (ClassNotFoundException | FileNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}  catch (SQLException e) {
			System.out.println(e.getMassage());
		}
            
            // TODO: 다양한 예외를 처리하는 코드를 작성하시오.
        // END:
        System.out.println("프로그램 정상 종료");

    }
}
