// ##DELETE_FILE:
package com.ssafy.day4.generic.box;

public class NumberBox <T extends Number>{
    public void addSomes(T...ts) {
        double sum = 0;
        for(T t: ts) {
            sum+=t.doubleValue();
        }
        System.out.printf("총 합은: %f%n", sum);
    }
}
