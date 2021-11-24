package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CommentDto : notice 질문에 대한 답변")
public class CommentDto {

	@ApiModelProperty(value = "글번호")
	private int comment_no;
	@ApiModelProperty(value = "작성자아이디")
	private String userid;
	@ApiModelProperty(value = "답변")
	private String comment;
	@ApiModelProperty(value = "작성시각")
	private String comment_time;
	@ApiModelProperty(value = "질문번호", example = "111-111-1111")
	private int noticeno;
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public int getQnano() {
		return noticeno;
	}
	public void setQnano(int noticeno) {
		this.noticeno = noticeno;
	}


}
