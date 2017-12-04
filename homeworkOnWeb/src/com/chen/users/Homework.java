package com.chen.users;

import java.sql.Date;
import java.util.List;

public class Homework {

	private String homeworkID;
	private String classID;
	private String homeworkTitle;
	private Date deadline;
	private String homeworkState;
	private String stuID;
	private String tskState="未保存";
	private List<Question> questions;
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getHomeworkTitle() {
		return homeworkTitle;
	}
	public void setHomeworkTitle(String homeworkTitle) {
		this.homeworkTitle = homeworkTitle;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getHomeworkState() {
		return homeworkState;
	}
	public void setHomeworkState(String homeworkState) {
		this.homeworkState = homeworkState;
	}
	public String getHomeworkID() {
		return homeworkID;
	}
	public void setHomeworkID(String homeworkID) {
		this.homeworkID = homeworkID;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getTskState() {
		return tskState;
	}
	public void setTskState(String tskState) {
		this.tskState = tskState;
	}
	
}
