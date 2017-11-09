package com.chen.dao;



import com.chen.jdbc.JdbcUtils;
import com.chen.users.Student;
import com.chen.users.Users;

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

}
