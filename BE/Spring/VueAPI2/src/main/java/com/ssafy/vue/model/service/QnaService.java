package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.util.PageNavigation;
import com.ssafy.vue.model.BoardDto;
import com.ssafy.vue.model.BoardParameterDto;
import com.ssafy.vue.model.QnADto;
import com.ssafy.vue.model.QnaParameterDto;

public interface QnaService {
	public boolean writeQna(QnADto qnaDto) throws Exception;
	public List<QnADto> listQna(QnaParameterDto qnaParameterDto) throws Exception;
	public PageNavigation makePageNavigation(QnaParameterDto qnaParameterDto) throws Exception;
	
	public QnADto getQna(int qnano) throws Exception;
	public void updateHit(int qnano) throws Exception;
	public boolean modifyQna(QnADto qnaDto) throws Exception;
	public boolean deleteQna(int qnano) throws Exception;
}
