package com.ssafy.day2.array;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_04 {
    public static void main(String[] args) {
        String org = "SSAFY";
        // TODO: SSAFY를 char []에 저장하고 출력하시오.
        char[] chars = new char[org.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = org.charAt(i);
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
        // API의 활용
        chars = org.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        // END:
    }
}
