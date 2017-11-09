package com.chen.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chen.jdbc.JdbcUtils;

public class AssTeacher {

	private String assTeacherID;
	private String name;
	private String password;
	
	public void modifyPassword(String newPassword) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "update assteacher set password=? where assteacherID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, this.getAssTeacherID());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addStudent(String stuID,String stuName,String classID) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "insert into class_student(classID,stuID,stuName) values(?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, classID);
			ps.setString(2, stuID);
			ps.setString(3, stuName);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteStudent(String stuID,String classID) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "delete from class_student where stuID=? and classID=?";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stuID);
			ps.setString(2, classID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteAssTeacher(String classID,String assTeacherID) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "delete from class_assteacher where assTeacherID=? and classID=?";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, classID);
			ps.setString(1, assTeacherID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addGrade(String classID,String stuID,String homeworkTitle,String grade) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "insert into stugrade(classID,stuID,homeworkTitle,Grade) values(?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, classID);
			ps.setString(2, stuID);
			ps.setString(3, homeworkTitle);
			ps.setString(4, grade);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void submitGrade(String classID,String stuID,String homeworkTitle,String grade) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "update stugrade set subState='1', Grade=? where stuID=? and homeworkTitle=? and classID=?";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, grade);
			ps.setString(2, stuID);
			ps.setString(3, homeworkTitle);
			ps.setString(4, classID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAssTeacherID() {
		return assTeacherID;
	}
	public void setAssTeacherID(String assTeacherID) {
		this.assTeacherID = assTeacherID;
	}
}
