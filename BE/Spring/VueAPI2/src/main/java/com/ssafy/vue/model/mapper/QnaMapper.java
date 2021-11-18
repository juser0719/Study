package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.BoardDto;
import com.ssafy.vue.model.BoardParameterDto;
import com.ssafy.vue.model.QnADto;
import com.ssafy.vue.model.QnaParameterDto;

@Mapper
public interface QnaMapper {
	
	public int writeQna(QnADto qnaDto) throws SQLException;
	public List<QnADto> listQna(QnaParameterDto qnaParameterDto) throws SQLException;
	public int getTotalCount(QnaParameterDto qnaParameterDto) throws SQLException;
	public QnADto getQna(int qnano) throws SQLException;
	public void updateHit(int qnano) throws SQLException;
	public int modifyQna(QnADto qnaDto) throws SQLException;
	public void deleteMemo(int articleno) throws SQLException;
	public int deleteQna(int qnano) throws SQLException;
	
}