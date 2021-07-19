package com.ssafy.day1;

/**
 * @since 2021. 7. 4.
 */
public class BasicProblem_15 {

    public static void main(String[] args) {

            int i = 10;
            
            System.out.println( ( i-- ) % 2 );  // ( 1 )
            System.out.println( --i );          // ( 2 )
            System.out.println( i++ );          // ( 3 )
            System.out.println( ++( i - 2 ) );  // ( 4 )
    }
}
