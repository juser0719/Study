package com.ssafy.day1;

import java.util.Random;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_30 {
    public static void main(String[] args) {
        int N = 6;
        Random rand = new Random();
        int num1 = rand.nextInt(N)+1;
        int num2 = rand.nextInt(N)+1;
        String result = null;
        // TODO: num1 과 num2가 모두 짝수이거나 모두 홀수이면 A, 아니면 B를 출력하시오.
        // END:
        System.out.printf("%d, %d --> %s%n", num1, num2, result);
    }
}
