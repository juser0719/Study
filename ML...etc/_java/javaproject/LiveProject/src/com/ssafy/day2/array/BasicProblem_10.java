package com.ssafy.day2.array;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_10 {
public static void main(String[] args) {
    int[] intArray = { 3, 27, 13, 8, 235, 7, 22, 9, 435, 31, 54 };

    int min = 999;
    int max = -999;

    // TODO: 위 배열의 요소 중 최대 값과 최소 값을 출력하시오.
    for(int num: intArray) {
        if(num>max) {
            max = num;
        }
        if(num<min) {
            min = num;
        }
    }
    // END:
    System.out.printf("min: %d, max: %d%n", min, max);
    
}
}
