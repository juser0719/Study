package com.ssafy.guestbook.model.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.guestbook.model.FileInfoDto;
import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.mapper.GuestBookDao;
import com.ssafy.util.PageNavigation;

@Service
public class GuestBookServiceImpl implements GuestBookService {
	
	@Autowired
	private SqlSession sqlSession;
	//SQL 사용은 SQLSession으로 조작가능.
	//mapper로 spring-mybatis로 .xml로 자동으로 Mapping 해줌.
	
	@Override
	@Transactional
	public void registerArticle(GuestBookDto guestBookDto) throws Exception {
		GuestBookDao guestBookMapper = sqlSession.getMapper(GuestBookDao.class);
		guestBookMapper.registerArticle(guestBookDto);
		List<FileInfoDto> fileInfos = guestBookDto.getFileInfos();
		if (fileInfos != null && !fileInfos.isEmpty()) {
			guestBookMapper.registerFile(guestBookDto);
		}
	}

	@Override
	public List<GuestBookDto> listArticle(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if("userid".equals(key))
			key = "g.userid";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pg") == null ? "1" : map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		int start = (currentPage - 1) * sizePerPage;
		param.put("start", start);
		param.put("spp", sizePerPage);
		return sqlSession.getMapper(GuestBookDao.class).listArticle(param);
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();
		
		int naviSize = 10;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(GuestBookDao.class).getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		
		return pageNavigation;
	}

	@Override
	public GuestBookDto getArticle(int articleNo) throws Exception {
		return sqlSession.getMapper(GuestBookDao.class).getArticle(articleNo);
	}

	@Override
	public void updateArticle(GuestBookDto guestBookDto) throws Exception {
		sqlSession.getMapper(GuestBookDao.class).updateArticle(guestBookDto);
	}

	@Override
	@Transactional
	public void deleteArticle(int articleNo, String path) throws Exception {
		GuestBookDao guestBookMapper = sqlSession.getMapper(GuestBookDao.class);
		List<FileInfoDto> fileList = guestBookMapper.fileInfoList(articleNo);
		guestBookMapper.deleteFile(articleNo);
		guestBookMapper.deleteArticle(articleNo);
		for(FileInfoDto fileInfoDto : fileList) {
			File file = new File(path + File.separator + fileInfoDto.getSaveFolder() + File.separator + fileInfoDto.getSaveFile());
			file.delete();
		}
	}

}
