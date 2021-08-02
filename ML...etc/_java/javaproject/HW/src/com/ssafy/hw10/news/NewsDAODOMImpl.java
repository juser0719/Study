package com.ssafy.hw10.news;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {
	List<News> list = new ArrayList<>();
	
	private void connectNews(String url) {
		
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();//XML 문서로부터 DOM 객체 트리를 생성하는 파서를 취득할 수 있는 팩토리 API
		
		try {
			DocumentBuilder parser = f.newDocumentBuilder();
			Document dom = parser.parse(new URL(url).openConnection().getInputStream()); //돔 파싱.
			Element root = dom.getDocumentElement();
			NodeList n = root.getElementsByTagName("item");

			for (int i = 0; i < n.getLength(); i++) {
				News w = new News();
				Node item = n.item(i);
				NodeList kids = item.getChildNodes();
				for (int j = 0; j < kids.getLength(); j++) {
					Node kid = kids.item(j);
					String name = kid.getNodeName();
					if (name.equalsIgnoreCase("title")) {
						w.setTitle(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("description")) {
						w.setDesc(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("link")) {
						w.setLink(kid.getFirstChild().getNodeValue());
					} 
				}
				System.out.println(w);
				list.add(w);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Override
	public List<News> getNewsList(String url) {
		list.removeAll(list);// 리스트 먼저 비요주고,
		connectNews(url); //url로 xml 가져옴.
		return list;
	}
	@Override
	public News search(int index) {
		return list.get(index);
	}
}
