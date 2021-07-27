// ##DELETE_FILE:
package com.ssafy.day1;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_34 {
    public static void main(String[] args) {

        for( int i=1; i<10; i++ ) {
            
            for( int j=1; j<10; j++ ) {
                
                if( j==5 ) break;
                if( j==3 ) continue;
                
                System.out.print(i*j+"\t");
            }
            System.out.println();
        }
    }
}
