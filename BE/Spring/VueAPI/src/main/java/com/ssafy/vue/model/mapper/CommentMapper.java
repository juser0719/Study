package com.ssafy.vue.model.mapper;

import java.util.List;

import com.ssafy.vue.model.CommentDto;

public interface CommentMapper {

	List<CommentDto> list(int qnano);

	int create(CommentDto commentDto);

	int modify(CommentDto commentDto);

	int delete(int commentNo);
	
}
