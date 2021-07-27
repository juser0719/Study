package com.ssafy.day1;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_38 {

    
    public static void main(String[] args) {
        // TODO: 지정한 별찍기를 처리하시오.
        for(int i=5; i>0; i--) {
            for(int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // END:
    }

}
