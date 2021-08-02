package com.ssafy.hw10.news;

import java.util.List;

interface INewsDAO {
	List<News> getNewsList(String url);
	public News search(int index);
}
