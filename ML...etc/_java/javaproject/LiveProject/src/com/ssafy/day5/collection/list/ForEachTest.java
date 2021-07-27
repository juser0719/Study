package com.ssafy.day5.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @since 2021. 7. 7.
 */
public class ForEachTest {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<10; i++) {
            nums.add(i);
        }
        
        System.out.println("시작: "+nums);
        for(Integer num: nums) {
            if(num%2==0) {
                // nums.add(num*num);
                nums.remove(num);
            }
        }        
    }
}
