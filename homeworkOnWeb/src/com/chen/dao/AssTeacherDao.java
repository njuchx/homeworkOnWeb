package com.chen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chen.jdbc.JdbcUtils;
import com.chen.users.AssTeacher;
import com.chen.users.Users;

public class AssTeacherDao {

	public AssTeacher find(Users user) {
		AssTeacher assTeacher = new AssTeacher();
		JdbcUtils jdbc = new JdbcUtils();
		try {
			Connection conn = jdbc.getConection();
			if(conn==null){
				System.out.println("数据库不存在");
			}
			String sql = "select * from assteacher where assTeacherID=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				assTeacher.setName(rs.getString("name"));
				assTeacher.setAssTeacherID(rs.getString("assTeacherID"));
				assTeacher.setPassword(rs.getString("password"));
				jdbc.releace(conn, ps, rs);
			}else{
				assTeacher = null;
			}
			jdbc.releace(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assTeacher;
			
	}
	public boolean assTeacherLogin(Users user) {
		if (find(user)!=null) {
			return true;
		} else {
			return false;

		}	
	}
	public void modifyPassword(String assTeacherID,String newPassword) {
		try {
			JdbcUtils jdbc = new JdbcUtils();
			Connection conn = jdbc.getConection();
			String sql = "update assteacher set password=? where assteacherID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, assTeacherID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
