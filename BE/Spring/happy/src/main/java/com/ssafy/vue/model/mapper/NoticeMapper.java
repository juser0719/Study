package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.NoticeDto;
import com.ssafy.vue.model.NoticeParameterDto;

@Mapper
public interface NoticeMapper {

	public int writeNotice(NoticeDto noticeDto) throws SQLException;

	public List<NoticeDto> listNotice(NoticeParameterDto noticeParameterDto) throws SQLException;

	public int getTotalCount(NoticeParameterDto noticeParameterDto) throws SQLException;

	public NoticeDto getNotice(int noticeno) throws SQLException;

	public void updateHit(int noticeno) throws SQLException;

	public int modifyNotice(NoticeDto noticeDto) throws SQLException;

	public void deleteMemo(int noticeno) throws SQLException;

	public int deleteNotice(int noticeno) throws SQLException;

}