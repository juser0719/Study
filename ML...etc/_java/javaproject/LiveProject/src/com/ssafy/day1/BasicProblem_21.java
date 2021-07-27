package com.ssafy.day1;

/**
 * @since 2021. 7. 4.
 */
public class BasicProblem_21 {
    public static void main(String[] args) {
        
        // bit and
        System.out.println("3 & 6 = " + (3 & 6));
        //   0011
        // & 0110
        // ------
        //   0010
        
        // bit or
        System.out.println("3 | 6 = " + (3 | 6));
        //   0011
        // | 0110
        // ------
        //   0111
        
        // bit exclusive
        System.out.println("3 ^ 6 = " + (3 ^ 6));
        //   0011
        // ^ 0110
        // ------
        //   0101
        
        // bit not
        System.out.println(" ~ 6 = " + (~ 6));
        //   0110
        // ~
        // ------
        //   1001
    }
}
