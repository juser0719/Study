package com.ssafy.day2.array;

import java.util.Random;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_06 {
    public static void main(String[] args) {
        int N = 6;
        Random rand = new Random();
        // TODO: BasicProblem_04를 for-each 문장으로 변경해보세요.
        int [] resArray = new int[5];
        for(int num : resArray) {
        	num = rand.nextInt(N) + 1;
        } // read only라서,
        int i =0; 
        for(int num : resArray) {
        	System.out.printf("%d 번째 - %d%n", i ++, num);
        }
        // END:
    }
}
