package com.ssafy.day5.collection.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.ssafy.day5.collection.SmartPhone;

/**
 * @since 2021. 7. 8.
 */
public class ListSortTest {

    private List<String> names = Arrays.asList("Hi", "Java", "World", "Welcome");

    public void basicSort() {
        Integer n;
        Collections.sort(names);
        System.out.println(names); // [Hi, Java, Welcome, World]
    }

    public void sortPhone() {
        // TODO: 전화 번호에 따라 SmartPhone을 정렬해보자.
        // END:
    }

    public void stringLengthSort() {
        // TODO: 문자열의 길이에 따라 names를 정렬해보자.
        // END:
        System.out.println(names); // [Hi, Java, World, Welcome]
    }

    public static void main(String[] args) {
        ListSortTest st = new ListSortTest();
        st.basicSort();
        st.sortPhone();
        st.stringLengthSort();
    }

}
