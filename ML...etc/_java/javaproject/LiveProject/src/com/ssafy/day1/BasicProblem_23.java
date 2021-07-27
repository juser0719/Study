// ##DELETE_FILE:
package com.ssafy.day1;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_23 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        System.out.println((a > b) & (b > 0));
        
        System.out.println((a += 10) > 15 | (b -= 10) > 15);
        System.out.println("a = " + a + ", b = " + b);

        a  =10;
        b = 20;
        System.out.println((a += 10) > 15 || (b -= 10) > 15);
        System.out.println("a = " + a + ", b = " + b);
    }
}
