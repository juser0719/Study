package com.ssafy.guestbook.model.service;

import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.dao.GuestBookDao;
import com.ssafy.guestbook.model.dao.GuestBookDaoImpl;

public class GuestBookServiceImpl implements GuestBookService {
	
	private static GuestBookService guestBookService = new GuestBookServiceImpl();
	
	private GuestBookDao guestBookDao;
	
	private GuestBookServiceImpl() {
		guestBookDao = GuestBookDaoImpl.getGuestBookDao();
	}
	
	public static GuestBookService getGuestBookService() {
		return guestBookService;
	}

	@Override
	public void registerArticle(GuestBookDto guestBookDto) throws Exception {
		guestBookDao.registerArticle(guestBookDto);
	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) throws Exception {
		// 검색한 모든 게시물 가져오기.
		key = key == null ? "" : key.trim();
		word = word == null? "" : word.trim();
		return guestBookDao.listArticle(key, word);
	}

	@Override
	public GuestBookDto getArticle(int articleNo) throws Exception {
		// 게시물 하나 가져오기.
		return guestBookDao.getArticle(articleNo);
	}

	@Override
	public void updateArticle(GuestBookDto guestBookDto)throws Exception {
		// 게시물 업데이트하기.
		guestBookDao.updateArticle(guestBookDto);
	}

	@Override
	public void deleteArticle(int articleNo)throws Exception {
		// 게시물 삭제하기.
		guestBookDao.deleteArticle(articleNo);
	}

}
