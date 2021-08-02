package com.ssafy.hw10.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class NewsDAOSAXImpl implements INewsDAO {
	
	static List<News> list = new ArrayList<>();

	private void connectNews(String url) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			SAXHandler handler = new SAXHandler();
			
			parser.parse(url, handler);
		} catch (IOException | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
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
	
	class SAXHandler extends DefaultHandler {
		private String content;
		 private News n;
		 
		 @Override
		    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		        // 방금 읽은 태그가 item라면 --> 새로운 News 생성
		        if (qName.equals("item")) {
		            n = new News();
		        }
		    }
		
		    @Override
		    public void characters(char[] ch, int start, int length) throws SAXException {
		        this.content = new String(ch, start, length);
		    }
		
		    @Override
		    public void endElement(String uri, String localName, String qName) throws SAXException {
		    	if (n != null) {
		    		if (qName.equals("item")) {
			            list.add(n);
			            n = null;
			        } else if (qName.equals("title")) {
			            n.setTitle(this.content);
			        } else if (qName.equals("description")) {
			            n.setDesc(this.content);
			        } else if (qName.equals("link")) {
			            n.setLink(this.content);
			        } 
		    	}
		       
		    }
	}
	
	
}



