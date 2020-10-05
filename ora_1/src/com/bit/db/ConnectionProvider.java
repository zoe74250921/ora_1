package com.bit.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	public static Connection getConn() {
		Connection conn = null;
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		String user = "c##madang";
//		String pwd = "madang";
		try {
			Context context = new InitialContext();
			DataSource ds= (DataSource)context.lookup("java:comp/env/myDB");			 
			conn = ds.getConnection();			
		}catch (Exception e) {
			System.out.println("겟컨 예외 " + e.getMessage());
		}
		return conn;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		
		try {
			if(rs!=null)
				rs.close();
			
			if(stmt != null)
				stmt.close();
			
			if(conn != null)
				conn.close();
		}catch (Exception e) {
			System.out.println("클로즈 예외 " +e.getMessage());
		}
	}
	
}
