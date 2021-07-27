package com.ssafy.day1;

import java.util.Scanner;

/**
 * @since 2021. 7. 12.
 */
public class UseScanner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        fromString();
        // fromStream();
    }


    private static void fromString() {
        String src1 = "   Hello   \n   Hello   ";
        Scanner scanner = new Scanner(src1);
        System.out.printf("nextline: %s%n", scanner.nextLine()); // 개행 문자까지 읽기
        System.out.printf("next: %s%n", scanner.next()); // white space를 제외한 문자열 읽기
        System.out.printf("nextline: %s%n", scanner.nextLine());
        System.out.println();
        String src2 = "안녕\n안녕";
        scanner = new Scanner(src2);
        System.out.printf("next: %s%n", scanner.next());
        System.out.printf("nextline: %s%n", scanner.nextLine());
    }


    private static void fromStream() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력하세요.");
        String line = scanner.next();
        System.out.printf("입력한 문자열: %s%n", line);

        System.out.println("정수를 입력하세요.");
        int num1 = scanner.nextInt();
        System.out.printf("입력한 정수: %d%n", num1);
    }
}
