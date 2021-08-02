package com.ssafy.ws10.step3;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {
	List<Weather> list = new ArrayList<>();

	private static WeatherDAO instance = new WeatherDAO();//싱글톤.
	
	public static WeatherDAO getInstance() { // 단일 객체 instance 주소 반환.
		return instance;
	}
	
	public WeatherDAO() {
		super();
	}

	public List<Weather> getWeatherList(String url) { //날씨 리스트 가져옴. 
		list.removeAll(list);// 리스트 먼저 비요주고,
		connectXML(url); //url로 xml 가져옴.
		return list;

	}
	
	private List<Weather> connectXML(String url) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();//XML 문서로부터 DOM 객체 트리를 생성하는 파서를 취득할 수 있는 팩토리 API
		
		try {
			DocumentBuilder parser = f.newDocumentBuilder();
			Document dom = parser.parse(new URL(url).openConnection().getInputStream()); //돔 파싱.
			Element root = dom.getDocumentElement();
			NodeList n = root.getElementsByTagName("data");

			for (int i = 0; i < n.getLength(); i++) {
				Weather w = new Weather();
				Node item = n.item(i);
				NodeList kids = item.getChildNodes();
				for (int j = 0; j < kids.getLength(); j++) {
					Node kid = kids.item(j);
					String name = kid.getNodeName();
					if (name.equalsIgnoreCase("hour")) {
						w.setHour(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("temp")) {
						w.setTemp(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("wfKor")) {
						w.setWfKor(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("reh")) {
						w.setReh(kid.getFirstChild().getNodeValue());
					}
				}
				System.out.println(w);
				list.add(w);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}