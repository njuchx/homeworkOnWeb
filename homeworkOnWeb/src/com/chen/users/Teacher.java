package com.chen.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chen.jdbc.JdbcUtils;

public class Teacher {

	private String name;
	private String password;
	private String teacherID;
	
	public void modifyPassword(String newPassword) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "update teacher set password=? where teacherID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, this.getTeacherID());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addStudent(String stuID,String stuName) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "replace into student(stuID,stuName) values(?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stuID);
			ps.setString(2, stuName);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addStudentToClass(String stuID,String stuName,String classID) {
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
	
	public void addClass(String classID,String course) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "insert into class_teacher(teacherID,teacherName,classID,course) values(?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.getTeacherID());
			ps.setString(2, this.getName());
			ps.setString(3, classID);
			ps.setString(4, course);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addAssTeacher(String classID,String assTeacherID,String assTeacherName) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "insert into class_assteacher(classID,teacherID,assTeacherID,assTeacherName) values(?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, classID);
			ps.setString(2, this.getTeacherID());
			ps.setString(3, assTeacherID);
			ps.setString(4, assTeacherName);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(String stuID) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "delete from student where stuID=?";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stuID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentFromClass(String stuID,String classID) {
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
	
	public void deleteClass(String classID) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "delete from class_teacher where teacherID=? and classID=?";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.getTeacherID());
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
	
	public void setPermission(String assTeacherID,int permission,int tof) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = null;
			switch (permission) {
			case 1:
				sql = "update class_assteacher set stuManState=? where assTeacherID=?";
				break;
			case 2:
				sql = "update class_assteacher set addQuestion=? where assTeacherID=?";
				break;
			case 3:
				sql = "update class_assteacher set addHomework=? where assTeacherID=?";
				break;
			case 4:
				sql = "update class_assteacher set correctHomework=? where assTeacherID=?";
				break;

			default:
				break;
			}
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tof);
			ps.setString(2, assTeacherID);
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
			String sql = "replace into stugrade(classID,stuID,homeworkTitle,Grade) values(?,?,?,?)";/////待修改///////////////
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
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
}
