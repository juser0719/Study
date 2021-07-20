package com.ssafy.day2.array;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_04 {
    public static void main(String[] args) {
        String org = "SSAFY";
        char [] chars = org.toCharArray();
//        char[] chars = new char[org.length()];
//        for (int i =0 ; i < org.length(); i ++) {
//        	chars[i] = org.charAt(i);
//        }
        for (int i =0; i< chars.length; i++) {
        	System.out.print(chars[i]);
        }
    }
}
