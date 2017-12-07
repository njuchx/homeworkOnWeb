package com.chen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chen.jdbc.JdbcUtils;
import com.chen.users.Homework;
import com.chen.users.Question;
import com.chen.users.Student;
import com.chen.users.Class;
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
	
	public List<Student> showClassStudents(String classID){
		List<Student> students = new ArrayList<Student>();
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from class_student where classID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, classID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStuID(rs.getString("stuID"));
				student.setName(rs.getString("stuName"));
				students.add(student);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
		
	}
	public List<Class> showClasses(String teacherID){
		List<Class> classes = new ArrayList<Class>();
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from class_teacher where teacherID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, teacherID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Class classD = new Class();
				classD.setClassID(rs.getString("classID"));
				classD.setTeacherName(rs.getString("teacherName"));
				classD.setCourse(rs.getString("course"));
				classes.add(classD);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classes;		
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
	
	public void addClass(String classID,String course,String teacherID,String teacherName) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "insert into class_teacher(teacherID,teacherName,classID,course) values(?,?,?,?)";/////待修改///////////////
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
	
	public void addQuestion(Question question){
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "replace into questions(tskID,course,chapter,author,tskDetail) values(?,?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, question.getTskID());
			ps.setString(2, question.getCourse());
			ps.setString(3, question.getChapter());
			ps.setString(4, question.getAuthor());
			ps.setString(5, question.getTskDetail());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Question> showQuestions(String course) {
		List<Question> questions = new ArrayList<Question>();
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from questions where course=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setTskID(rs.getString("tskID"));
				question.setAuthor(rs.getString("author"));
				question.setCourse(rs.getString("course"));
				question.setChapter(rs.getString("chapter"));
				question.setTskDetail(rs.getString("tskDetail"));
				questions.add(question);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
		
	}
	
	public void addHomework(Homework homework){
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "replace into homework(homeworkID,classID,homeworkTitle,deadline,homeworkState) values(?,?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, homework.getHomeworkID());
			ps.setString(2, homework.getClassID());
			ps.setString(3, homework.getHomeworkTitle());
			ps.setDate(4, homework.getDeadline());
			ps.setString(5, homework.getHomeworkState());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Homework> showHomeworks(String course) {
		List<Homework> homeworks = new ArrayList<Homework>();
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from questions where course=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Homework homework = new Homework();
				homework.setClassID(rs.getString("classID"));
				homework.setHomeworkID(rs.getString("homeworkID"));
				homework.setHomeworkTitle(rs.getString("homeworkTitle"));
				homework.setDeadline(rs.getDate("deadline"));
				homework.setHomeworkState(rs.getString("homeworkState"));
				homeworks.add(homework);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homeworks;
		
	}
	
	public void addQuestionToHomework(String homeworkID,String tskID,String tskContent,String tskDetail) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "replace into tsk_detail(homeworkID,tskID,tskContent,tskDetail) values(?,?,?,?)";/////待修改///////////////
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, homeworkID);
			ps.setString(2, tskID);
			ps.setString(3, tskContent);
			ps.setString(4, tskDetail);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Question> showStuAnswer(String homeworkID,String stuID) {
		List<Question> questions = new ArrayList<Question>();
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from task_answerstu where homeworkID=? and stuID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, homeworkID);
			ps.setString(1, stuID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setTskID(rs.getString("tskID"));
				question.setTskDetail(rs.getString("tskDetail"));
				question.setTskStuAnswer(rs.getString("tskStuAnswer"));
				questions.add(question);
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
		
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
			ps.setString(5, subState);
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
