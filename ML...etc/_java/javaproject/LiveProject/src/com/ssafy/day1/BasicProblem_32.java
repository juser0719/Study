package com.ssafy.day1;

import java.util.Random;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_32 {
    public static void main(String[] args) {
        int N = 6;
        int sum = 0;
        double avg = 0;
        Random rand = new Random();
        int i = 0;
        // TODO: 주사위를 100번 던진 결과의 합과 평균을 출력하시오. while 문 활용
        /*        while(i<100) {
            sum+=rand.nextInt(N)+1;
            i++;
        }  */
        
        do {
            sum+=rand.nextInt(N)+1;
            i++;
        }while(i<100);
        
        avg = sum/100.0;
        // END:
        System.out.printf("sum: %d, avg: %f%n", sum, avg);
    }
}
