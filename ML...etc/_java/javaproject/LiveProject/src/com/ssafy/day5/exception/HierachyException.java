package com.ssafy.day5.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @since 2021. 7. 7.
 */
public class HierachyException {
    public static void main(String[] args) {
        String src = "./.project";
         
            FileInputStream input = new FileInputStream(src);
            int readData = -1;

            while ((readData = input.read()) != -1) {
                System.out.print((char) readData);
            }
            // TODO: 상속의 관계를  고려하여 예외처리 하시오.
        // END:


        System.out.println("파일 읽음 완료!");
    }

}
