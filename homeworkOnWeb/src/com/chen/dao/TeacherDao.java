package com.chen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chen.jdbc.JdbcUtils;
import com.chen.users.Student;
import com.chen.users.Teacher;
import com.chen.users.Users;

public class TeacherDao {

	public Teacher find(Users user) {
		Teacher teacher = new Teacher();
		JdbcUtils jdbc = new JdbcUtils();
		try {
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from teacher where teacherID=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				teacher.setName(rs.getString("name"));
				teacher.setTeacherID(rs.getString("teacherID"));
				teacher.setPassword(rs.getString("password"));
				jdbc.releace(conn, ps, rs);
			}else{
				teacher = null;
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
			
	}
	public boolean teacherLogin(Users user) {
		if (find(user)!=null) {
			return true;
		} else {
			return false;

		}	
	}
	public void modifyPassword(String teacherID,String newPassword) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "update teacher set password=? where teacherID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, teacherID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> showAllStudents(){
		List<Student> students = new ArrayList<Student>();
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from student";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStuID(rs.getString("stuID"));
				student.setName(rs.getString("name"));
				students.add(student);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
		
	}
	
	public List<Student> showClassStudents(){
		List<Student> students = new ArrayList<Student>();
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from student";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStuID(rs.getString("stuID"));
				student.setName(rs.getString("name"));
				students.add(student);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
		
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
			String sql = "replace into class_student(classID,stuID,stuName) values(?,?,?)";/////待修改///////////////
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
	
	public void addClass(String classID,String course,String teacherID,String teacherName) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "replace into class_teacher(teacherID,teacherName,classID,course) values(?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,teacherID);
			ps.setString(2, teacherName);
			ps.setString(3, classID);
			ps.setString(4, course);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addAssTeacher(String classID,String teacherID,String assTeacherID,String assTeacherName) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "replace into class_assteacher(classID,teacherID,assTeacherID,assTeacherName) values(?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, classID);
			ps.setString(2, teacherID);
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
	//////////////////////////////////////////////////////////////////////////重点////////////////////////////
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
	
	public void deleteClass(String classID,String teacherID) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "delete from class_teacher where teacherID=? and classID=?";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, teacherID);
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
	
	public void addGrade(String classID,String stuID,String homeworkTitle,String grade,String subState) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "replace into stugrade(classID,stuID,homeworkTitle,grade,subState) values(?,?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, classID);
			ps.setString(2, stuID);
			ps.setString(3, homeworkTitle);
			ps.setString(4, grade);
			ps.setString(4, subState);
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

}
