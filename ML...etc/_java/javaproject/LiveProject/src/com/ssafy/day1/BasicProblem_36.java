package com.ssafy.day1;

import java.util.Random;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_36 {
    public static void main(String[] args) {
        
        int N = 6;
        Random rand = new Random();
        
        int sum = 0;
        int count = 0;
        // TODO: 주사위를 계속 던지고 총 합이 100이면 중지, 그때의 총 합과 던진 회수는?
        /*
        while(true) {
            count++;
            sum += rand.nextInt(N) + 1;
            if( sum > 100 ) break;
        }*/
        
        for(; ; count++) {
            sum+=rand.nextInt(N)+1;
            if(sum>100) {
                break;
            }
        }
        // END:
        System.out.printf("회수: %d, 총합: %d%n",count, sum);
    }
}
