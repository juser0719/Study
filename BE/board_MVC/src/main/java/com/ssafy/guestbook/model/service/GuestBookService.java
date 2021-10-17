package com.ssafy.guestbook.model.service;

import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;

public interface GuestBookService {
	void registerArticle(GuestBookDto guestBookDto) throws Exception;
	List<GuestBookDto>listArticle(String key,String word) throws Exception;
	GuestBookDto getArticle(int articleNo) throws Exception;
	void updateArticle(GuestBookDto guestBookDto) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
}
