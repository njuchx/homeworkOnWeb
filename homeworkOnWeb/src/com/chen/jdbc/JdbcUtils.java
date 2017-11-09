package com.chen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtils {


	public  Connection getConection() throws SQLException {
		Connection conn=null;
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/homework?useSSL=true","root","123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			throw new ExceptionInInitializerError(e);
			
			e.printStackTrace();    
		}
		
		return conn;
	}
	public  void releace(Connection conn , Statement st, ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		if (st!=null) {
			try {
				st.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
