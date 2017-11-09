package com.chen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chen.jdbc.JdbcUtils;
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

}
