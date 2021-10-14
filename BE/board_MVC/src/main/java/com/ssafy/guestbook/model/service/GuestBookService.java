package com.ssafy.guestbook.model.service;

import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;

public interface GuestBookService {
	void registerArticle(GuestBookDto guestBookDto);
	List<GuestBookDto>listArticle(String key,String word);
	GuestBookDto getArticle(int articleNo);
	void updateArticle(GuestBookDto guestBookDto);
	void deleteArticle(int articleNo);
}
