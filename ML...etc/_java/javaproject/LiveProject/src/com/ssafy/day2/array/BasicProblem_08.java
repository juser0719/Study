package com.ssafy.day2.array;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_08 {
    public static void main(String[] args) {
        String[] students = {"홍길동", "임꺽정", "장길산", "이몽룡"};
        // TODO: 배열에서 임꺽정과 장길산의 위치를 변경해서 출력하시오.
        String temp = students[1];
        students[1] = students[2];
        students[2] = temp;

        for (String student : students) {
            System.out.println(student);
        }
        // END:
    }
}
