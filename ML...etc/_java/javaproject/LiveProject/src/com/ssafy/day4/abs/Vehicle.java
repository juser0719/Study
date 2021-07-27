package com.ssafy.day4.abs;

class Vehicle {
    private int curX, curY;

    public void reportPosition() {
      System.out.printf("현재 위치: (%d, %d)%n", curX, curY);
    }

    public void addFuel() {
      System.out.println("모든 운송 수단은 연료가 필요");
    }
  }
