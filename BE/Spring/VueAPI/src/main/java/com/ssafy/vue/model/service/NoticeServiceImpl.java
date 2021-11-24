package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.util.PageNavigation;
import com.ssafy.vue.model.NoticeDto;
import com.ssafy.vue.model.NoticeParameterDto;
import com.ssafy.vue.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean writeNotice(NoticeDto noticeDto) throws Exception {
		if (noticeDto.getSubject() == null || noticeDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(NoticeMapper.class).writeNotice(noticeDto) == 1;
	}

	@Override
	public List<NoticeDto> listNotice(NoticeParameterDto NoticeParameterDto) throws Exception {
		int start = NoticeParameterDto.getPg() == 0 ? 0
				: (NoticeParameterDto.getPg() - 1) * NoticeParameterDto.getSpp();
		NoticeParameterDto.setStart(start);
		return sqlSession.getMapper(NoticeMapper.class).listNotice(NoticeParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(NoticeParameterDto NoticeParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(NoticeParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(NoticeMapper.class).getTotalCount(NoticeParameterDto);// 총글갯수 269
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / NoticeParameterDto.getSpp() + 1;// 27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = NoticeParameterDto.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < NoticeParameterDto.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public NoticeDto getNotice(int Noticeno) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).getNotice(Noticeno);
	}

	@Override
	public void updateHit(int Noticeno) throws Exception {
		sqlSession.getMapper(NoticeMapper.class).updateHit(Noticeno);
	}

	@Override
	@Transactional
	public boolean modifyNotice(NoticeDto NoticeDto) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).modifyNotice(NoticeDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteNotice(int Noticeno) throws Exception {
		sqlSession.getMapper(NoticeMapper.class).deleteMemo(Noticeno);
		return sqlSession.getMapper(NoticeMapper.class).deleteNotice(Noticeno) == 1;
	}
}