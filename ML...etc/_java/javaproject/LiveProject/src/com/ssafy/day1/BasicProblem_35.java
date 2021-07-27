// ##DELETE_FILE:
package com.ssafy.day1;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_35 {
    public static void main(String[] args) {

        outer: for( int i=1; i<10; i++ ) {
            
            for( int j=1; j<10; j++ ) {
                
                if( j==5 ) break outer;
                if( j==3 ) continue outer;
                
                System.out.print(i*j+" ");
            }
            System.out.println();
        }
    }
}
