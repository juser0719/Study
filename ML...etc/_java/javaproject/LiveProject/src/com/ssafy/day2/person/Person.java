// ##DELETE_FILE:
package com.ssafy.day2.person;

/**
 * @since 2021. 7. 6.
 */
public class Person {
    String name;
    int age;
    boolean isHungry;
    
    void eat() {
        System.out.println("냠냠");
        isHungry = false;
    }
    
    void work() {
        System.out.println("열심히");
        isHungry = true;
    }
}
