package com.ssafy.day2.array;

import java.util.Random;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_01 {
    public static void main(String[] args) {

        int N = 6;
        Random rand = new Random();
        
        int result1 = rand.nextInt(N) + 1;
        int result2 = rand.nextInt(N) + 1;
        int result3 = rand.nextInt(N) + 1;
        int result4 = rand.nextInt(N) + 1;
        int result5 = rand.nextInt(N) + 1;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }
}
