package com.ssafy.guestbook.model.service;

import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;

public class GuestBookImpl implements GuestBookService {
	
	private static GuestBookService guestBookService = new GuestBookImpl();

	private GuestBookImpl() {}
	
	public static GuestBookService getGuestBookService() {
		return guestBookService;
	}

	@Override
	public void registerArticle(GuestBookDto guestBookDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuestBookDto getArticle(int articleNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateArticle(GuestBookDto guestBookDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(int articleNo) {
		// TODO Auto-generated method stub

	}

}
