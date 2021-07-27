package com.ssafy.day4.inter.relation;

/**
 * @since 2021. 7. 7.
 */
// @@DEL:※implements※Chargeable※
public class DigitalCamera extends Camera implements Chargeable{
    // TODO: Chargeable을 구현하시오.
    @Override
    public void charge() {
        System.out.println("DigitalCamera 충전중...");
    }    
    // END:
}
