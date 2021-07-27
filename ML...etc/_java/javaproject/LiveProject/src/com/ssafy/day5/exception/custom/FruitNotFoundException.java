package com.ssafy.day5.exception.custom;

/**
 * @since 2021. 7. 8.
 */
public class FruitNotFoundException extends Exception {
    public FruitNotFoundException(String name) {
        super(name + "에 해당하는 과일은 없습니다.");
    }
}
