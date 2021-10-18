package com.ssafy.guestbook.dto;

// DTO(Data Tranfer Object), VO(Value Object), Bean: 데이터를 담아서 전송할 목적으로 만든 클래스
//setter & getter
public class GuestBookDto {
	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private String regTime;
	
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
}
