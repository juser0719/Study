package com.ssafy.day2.array;

import java.util.Arrays;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_09 {
    public static void main(String[] args) {
        int[] scores = {90, 80, 100};
        // TODO: 추가로 사회점수 95점을 관리해야 한다. 부적절한 코드는?
        // #1
        //scores[3] = 95;
        // #2
        scores = new int[] {90, 80, 100, 95};
        // #3
        //scores = {90, 80,100, 95 };
        // #4
        int[] scores2 = new int[4];
        System.arraycopy(scores, 0, scores2, 0, scores.length);
        scores2[3] = 95;
        // #5
        scores = Arrays.copyOf(scores, 5);
        System.out.println(Arrays.toString(scores));
        
        int [] nums = {1,2,3}; 
        
        nums[1]=100;
        
        nums = new int[] {1,2,3,4};
        
        // END:
    }
}
