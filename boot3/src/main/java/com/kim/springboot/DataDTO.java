package com.kim.springboot;

public class DataDTO { // 유효성 검사 객체
	private int id;
	private String writer;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "DataValidator [id=" + id + ", writer=" + writer + ", content=" + content + "]";
	}
	
}
