package com.ssafy.ws10.step3;

import java.util.List;

public class WeatherMain1 {
	public static void main(String[] args) {
		WeatherDAO weatherDao = WeatherDAO.getInstance();
		List<Weather> datas = weatherDao
				.getWeatherList("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000");

		for(Weather ob: datas) {
			System.out.println(ob.toString());
		}
	}
}
/*
https://www.weather.go.kr/w/index.do
(구)날씨누리 바로가기  -> 생활과 산업  -> 서비스(인터넷)


※ XML에 있는 데이터를 추출하는 방식(파싱 API)
1. DOM(Document Object Model)
   - XML 문서의 프로그래밍 interface
   - 정보 전체를 메모리에 로딩 후 접근
2. SAX(Simple API for XML)
   - SAX 방식은 라인을 하나하나 순차적으로 읽어가며 파싱을 수행한다.
   - XML 정보를 한줄씩 로딩하여 처리하지만 재로딩은 안됨
   - 속도가 빠르고 메모리 효율이 좋음
	
3. DOM과 SAX 방식 장단점
1)XML 문서를 수정하는 등의 추가적인 핸들링 작업이 들어갈 경우 DOM 방식을 사용한다.
2)단순히 데이터를 파싱하여, 화면에 View하는 경우는 SAX 방식을 사용한다.
3)대용량의 데이터로 인해서, 메모리에 문제가 발생할 경우, SAX 방식을 사용한다.
4)XML 문서의 구조가 복잡할 경우, DOM 방식을 사용한다.
5)단순한 설정을 읽는 경우는 SAX 방식을 사용한다.

DOM 방식의 파싱을 처리하는 파서 객체를 얻기 (DocumentBuilder)
DocumentBuilder를 얻기 위해서는 DocumentBuilderFactory 클래스를 활용한다.
DocumentBuilderFactory는 추상 클래스로 객체 생성이 불가능하다 
 */











