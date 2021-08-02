package com.ssafy.day5.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @since 2021. 7. 7.
 */
public class HierachyException {
    public static void main(String[] args) {
        String src = "..project";
         
            FileInputStream input = null;
			try {
				input = new FileInputStream(src);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            int readData = -1;

            try {
				while ((readData = input.read()) != -1) {
				    System.out.print((char) readData);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // TODO: 상속의 관계를  고려하여 예외처리 하시오.
        // END:


        System.out.println("파일 읽음 완료!");
    }

}
