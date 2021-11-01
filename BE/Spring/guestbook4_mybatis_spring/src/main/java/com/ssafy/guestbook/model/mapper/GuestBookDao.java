package com.ssafy.guestbook.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.guestbook.model.FileInfoDto;
import com.ssafy.guestbook.model.GuestBookDto;
// 이제 mybatis-config를 통해 guestbook.xml의 각 메소드는 DaoImpl의 역할을 해주기 때문에 더이상 DaoImpl을 구현할 필요 X
// DB는 SQLssesion이 해줌.
public interface GuestBookDao {
	
	void registerArticle(GuestBookDto guestBookDto) throws Exception;
	void registerFile(GuestBookDto guestBookDto) throws Exception;
	List<GuestBookDto> listArticle(Map<String, Object> map) throws Exception;
	int getTotalCount(Map<String, String> map) throws Exception;
	GuestBookDto getArticle(int articleNo) throws Exception;
	void updateArticle(GuestBookDto guestBookDto) throws Exception;
	void deleteFile(int articleNo) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;
	
}
