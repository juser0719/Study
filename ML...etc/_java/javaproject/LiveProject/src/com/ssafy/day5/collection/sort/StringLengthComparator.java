package com.ssafy.day5.collection.sort;

import java.util.Comparator;

/**
 * @since 2021. 7. 8.
 */
public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int len1 = o1.length();
        int len2 = o2.length();
        return Integer.compare(len1, len2);
    }
}
