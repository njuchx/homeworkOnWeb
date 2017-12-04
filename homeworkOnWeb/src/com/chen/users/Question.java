package com.chen.users;

public class Question {

	private String tskID;
	private String course;
	private String chapter;
	private String author;
	private String tskDetail;
	private String tskContent;
	private String tskState;
	private String tskStuAnswer;
	public String getTskState() {
		return tskState;
	}
	public void setTskState(String tskState) {
		this.tskState = tskState;
	}
	public String getTskContent() {
		return tskContent;
	}
	public void setTskContent(String tskContent) {
		this.tskContent = tskContent;
	}
	public String getTskID() {
		return tskID;
	}
	public void setTskID(String tskID) {
		this.tskID = tskID;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTskDetail() {
		return tskDetail;
	}
	public void setTskDetail(String tskDetail) {
		this.tskDetail = tskDetail;
	}
	public String getTskStuAnswer() {
		return tskStuAnswer;
	}
	public void setTskStuAnswer(String tskStuAnswer) {
		this.tskStuAnswer = tskStuAnswer;
	}
}
