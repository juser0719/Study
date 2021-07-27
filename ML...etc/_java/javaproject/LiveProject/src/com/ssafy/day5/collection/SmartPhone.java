package com.ssafy.day5.collection;

import java.util.Objects;

public class SmartPhone  {
    String number;

    public SmartPhone(String number) {
        this.number = number;
    }

    public String toString() {
        return "전화 번호: " + number;
    }
    // TODO: 동일한 번호의 SmartPhone이면 하나만 추가될 수 있도록 처리하시오.
    // END:

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SmartPhone other = (SmartPhone) obj;
		return Objects.equals(number, other.number);
	}
   
    // TODO: SmartPhone을 비교 가능하게 만들어보자.
    // END:
}
