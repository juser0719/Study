package com.ssafy.day2.phone;

public class SmartPhoneTest {
    public static void main(String[] args) {
        SmartPhone sphone = new SmartPhone();
        sphone.number = "010";
        System.out.println(sphone.osName + " : " + sphone.number);
        sphone.call("011");

        SmartPhone sphone2 = new SmartPhone();
        sphone2.number = "010-111-1111";
        System.out.println(sphone2.osName + " : " + sphone2.number);

        SmartPhone.osName = "android 4.0";
        System.out.println(sphone.osName + " : " + sphone.number);
    }
}
