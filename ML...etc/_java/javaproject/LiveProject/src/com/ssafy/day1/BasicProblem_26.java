package com.ssafy.day1;

/**
 * @since 2021. 7. 5.
 */
public class BasicProblem_26 {
    public static void main(String[] args) {
        int age  =10;
        String status = null;
        if(age >=19) {
            status ="충분히 성장했다.";
        }else {
            status ="아직 어리다.";
        }
        
        // TODO:위 문장을 3항 연산자를 이용하는 형태로 처리하시오.
        status = age>=19?"충분히 성장했다.":"아직 어리다.";
        // END:
        
        System.out.println(status);
    }
}
