package com.ssafy.guestbook.model.dao;

import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;

public class GuestBookDaoImpl implements GuestBookDao {
	
	private static GuestBookDao guestBookDao = new GuestBookDaoImpl();
	
	private GuestBookDaoImpl() {}
	
	public static GuestBookDao getGuestBookDao() {
		return guestBookDao;
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
