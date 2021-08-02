package com.ssafy.hw10.news;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
	JFrame f ;
	JButton b ;
	JList li;
	JTextArea ta ;
	INewsDAO dao;
	
	public NewsMain() {
//		dao = new NewsDAODOMImpl();
		dao = new NewsDAOSAXImpl();
		createGUI();
		addEvent();
//		showList();
	}
	
	public void createGUI() {
		f = new JFrame("NewsList");
		JPanel p = new JPanel();
		b = new JButton("News List 호출");
		li= new JList();
		ta= new JTextArea("");
		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(b,"North");
		p.add(li);
		f.setLayout(new GridLayout(2,1,5,5));
		f.add(p);
		f.add(ta);
		f.setSize(400,500);
		f.setVisible(true);
	}
	
	public void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		li.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int index = li.getSelectedIndex();
				News n = dao.search(index);
				ta.setText(n.getDesc());
			}
		});
	}
	
	public void showList() {
		java.util.List<News> datas = dao.getNewsList("http://rss.etnews.com/Section902.xml");
		li.removeAll();
		li.setListData(datas.toArray());
	}
	
	public static void main(String[] args) {
		new NewsMain();
	}
	
}
