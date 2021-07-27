package com.ssafy.day4.generic.wild;

import java.math.BigInteger;
import com.ssafy.day4.generic.box.GenericBox;

public class UseWildCardTest2 {

    public void useWildCardTypeMethod() {
        GenericBox<Double> dBox = new GenericBox<>();
        GenericBox<Integer> intBox = new GenericBox<>();
        GenericBox<? extends Number> wild = dBox;

        dBox.setSome(3.14);
        // wild.setSome(3.14);
        // wild.setSome(123);
        // 최소한 Number 이하의 것들이므로 Number의 getXX 가능
        System.out.printf("정수? %d, 실수? %f%n", wild.getSome().intValue(),
                wild.getSome().doubleValue());
    }


    public static void main(String[] args) {
        UseWildCardTest2 test = new UseWildCardTest2();
        test.useWildCardTypeMethod();
    }
}
