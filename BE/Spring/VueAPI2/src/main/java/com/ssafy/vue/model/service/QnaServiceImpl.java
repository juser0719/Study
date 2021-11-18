package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.util.PageNavigation;
import com.ssafy.vue.model.BoardDto;
import com.ssafy.vue.model.BoardParameterDto;
import com.ssafy.vue.model.QnADto;
import com.ssafy.vue.model.QnaParameterDto;
import com.ssafy.vue.model.mapper.BoardMapper;
import com.ssafy.vue.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean writeQna(QnADto qnaDto) throws Exception {
		if(qnaDto.getSubject() == null || qnaDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(QnaMapper.class).writeQna(qnaDto) == 1;
	}

	@Override
	public List<QnADto> listQna(QnaParameterDto qnaParameterDto) throws Exception {
		int start = qnaParameterDto.getPg() == 0 ? 0 : (qnaParameterDto.getPg() - 1) * qnaParameterDto.getSpp();
		qnaParameterDto.setStart(start);
		return sqlSession.getMapper(QnaMapper.class).listQna(qnaParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(QnaParameterDto qnaParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(qnaParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(QnaMapper.class).getTotalCount(qnaParameterDto);//총글갯수  269
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / qnaParameterDto.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = qnaParameterDto.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < qnaParameterDto.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public QnADto getQna(int qnano) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).getQna(qnano);
	}

	@Override
	public void updateHit(int qnano) throws Exception {
		sqlSession.getMapper(QnaMapper.class).updateHit(qnano);	
	}

	@Override
	@Transactional
	public boolean modifyQna(QnADto qnaDto) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).modifyQna(qnaDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteQna(int qnano) throws Exception {
		sqlSession.getMapper(QnaMapper.class).deleteMemo(qnano);
		return sqlSession.getMapper(QnaMapper.class).deleteQna(qnano) == 1;
	
	}

	
}