package com.book.dao;

import java.util.List;

import com.book.entity.BookDTO;

public interface BookDao {
	public int insertBook(BookDTO dto);
	public List<BookDTO> listBook();
	public int updateBook(BookDTO dto);
	int deleteBook(BookDTO dto);
}
