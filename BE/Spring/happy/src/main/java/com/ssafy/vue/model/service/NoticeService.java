package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.util.PageNavigation;
import com.ssafy.vue.model.NoticeDto;
import com.ssafy.vue.model.NoticeParameterDto;

public interface NoticeService {
	public boolean writeNotice(NoticeDto noticeDto) throws Exception;

	public List<NoticeDto> listNotice(NoticeParameterDto noticeParameterDto) throws Exception;

	public PageNavigation makePageNavigation(NoticeParameterDto noticeParameterDto) throws Exception;

	public NoticeDto getNotice(int noticeno) throws Exception;

	public void updateHit(int noticeno) throws Exception;

	public boolean modifyNotice(NoticeDto noticeDto) throws Exception;

	public boolean deleteNotice(int noticeno) throws Exception;
}
