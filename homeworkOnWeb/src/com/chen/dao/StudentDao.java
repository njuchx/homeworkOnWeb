package com.chen.dao;



import com.chen.jdbc.JdbcUtils;
import com.chen.users.Student;
import com.chen.users.Homework;
import com.chen.users.Question;
import com.chen.users.Users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	public Student find(Users user) {
		Student student = new Student();
		JdbcUtils jdbc = new JdbcUtils();
		try {
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from student where stuID=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student.setName(rs.getString("name"));
				student.setStuID(rs.getString("stuID"));
				student.setPassword(rs.getString("password"));
				student.setClassID(rs.getString("classID"));
				jdbc.releace(conn, ps, rs);
			}else{
				student = null;
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
			
	}
	public boolean studentLogin(Users user) {
		if (find(user)!=null) {
			return true;
		} else {
			return false;

		}	
	}

	public void submitHomework(String stuID,String homeworkID,String tskID,String tskStuAnswer,String tskState) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "update task_answerstu set tskStuAnswer=?,tskState=? where stuID=? and homeworkID=? and tskID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tskStuAnswer);
			ps.setString(2, tskState);
			ps.setString(3, stuID);
			ps.setString(4, homeworkID);
			ps.setString(5, tskID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Homework setHomework(String homeworkID) {
		Homework homework = new Homework();
		JdbcUtils jdbc = new JdbcUtils();
		try {
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from homework where homeworkID=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, homeworkID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				homework.setHomeworkID(rs.getString("homeworkID"));
				homework.setClassID(rs.getString("classID"));
				homework.setHomeworkTitle(rs.getString("homeworkTitle"));
				homework.setDeadline(rs.getDate("deadline"));
				homework.setHomeworkState(rs.getString("homeworkState"));
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homework;
	}
	
	public List<Homework> seeAllHomework() {
		
		List<Homework> homeworks = new ArrayList<Homework>();
		JdbcUtils jdbc = new JdbcUtils();
		try {
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from homework";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Homework homework = new Homework();
				homework.setHomeworkID(rs.getString("homeworkID"));
				homework.setClassID(rs.getString("classID"));
				homework.setHomeworkTitle(rs.getString("homeworkTitle"));
				homework.setDeadline(rs.getDate("deadline"));
				homework.setHomeworkState(rs.getString("homeworkState"));
				homeworks.add(homework);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeworks;
	}
	
	public List<Homework> seeHomework(String stuID) {
		
		List<Homework> homeworks = new ArrayList<Homework>();
		JdbcUtils jdbc = new JdbcUtils();
		Set<String> homeworkSet = new HashSet<String>();
		try {
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from task_answerStu where stuID=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stuID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(homeworkSet.contains(rs.getString("homeworkID"))){
					continue;
				}
				homeworkSet.add(rs.getString("homeworkID"));
				
				Homework homework = new Homework();
				homework = setHomework(rs.getString("homeworkID"));
				homework.setTskState(rs.getString("tskState"));
				
				homeworks.add(homework);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeworks;
	}
	
	public List<Question> showHomeworkTsk(String homeworkID) {
		
		List<Question> questions = new ArrayList<Question>();
		JdbcUtils jdbc = new JdbcUtils();
		try {
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from task_detail where homeworkID=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, homeworkID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setTskDetail(rs.getString("tskDetail"));
				question.setTskID(rs.getString("tskID"));
				question.setTskContent(rs.getString("tskContent"));
				questions.add(question);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}
	
	public Question getTskStu(Question question,String stuID,String homeworkID) {
		JdbcUtils jdbc = new JdbcUtils();
		try {
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from task_answerStu where stuID=? and tskID=? and homeworkID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stuID);
			ps.setString(2, question.getTskID());
			ps.setString(3, homeworkID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				question.setTskState(rs.getString("tskState"));
				question.setTskStuAnswer(rs.getString("tskStuAnswer"));
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return question;
		
	}
	public void modifyPassword(String stuID,String newPassword) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "update student set password=? where stuID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, stuID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
