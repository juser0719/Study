package com.ssafy.guestbook.model.dao;

import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;

public interface GuestBookDao {
	void registerArticle(GuestBookDto guestBookDto) throws Exception;
	List<GuestBookDto>listArticle(String key,String word) throws Exception;
	GuestBookDto getArticle(int articleNo) throws Exception;
	void updateArticle(GuestBookDto guestBookDto) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
}
