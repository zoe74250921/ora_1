package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.CodeVo;
import com.bit.vo.NoticeVo;

public class NoticeDao {
	private static NoticeDao dao;
	public NoticeDao() {
		
	}
	public static NoticeDao getInstance() {
		if(dao == null) {
			dao = new NoticeDao();
		}
		return dao;
	}
	
	public ArrayList<NoticeVo> listNotice(){
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		
		String sql= "SELECT n_no,n.code_value,code_name,n_title,n_content,TO_CHAR(n_regdate,'yyyy.mm.dd hh:mi'),"
				+ "n_hit FROM NOTICE n, CODE c WHERE "
				+" n.CODE_VALUE = c.CODE_VALUE";
		
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				 int n_no = rs.getInt(1);
				 String code_value = rs.getString(2);
				 String code_name= rs.getString(3);
				 String n_title= rs.getString(4);
				 String n_content= rs.getString(5);
				 String n_regdate= rs.getString(6);
				 int n_hit = rs.getInt(7);
				 
				 list.add(new NoticeVo(n_no, code_value, code_name, n_title, n_content, n_regdate, n_hit));
			}			
		}catch (Exception e) {
			System.out.println("listNotice 예외발생:" +e.getMessage());
		}
		return list;
	}
	
	public ArrayList<CodeVo> getBoardCategory(String code_type){
		ArrayList<CodeVo> list = new ArrayList<CodeVo>();
		String sql = "select code_value,code_type,code_name from code where code_type=?";
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code_type);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new CodeVo(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println("getBoardCategory 예외발생:"+e.getMessage());
		}
		return list;
	}
	
	public NoticeVo detailNotice(int n_no) {
		NoticeVo n = null;
		try {
			String sql= "SELECT n_no,n.code_value,code_name,n_title,n_content,TO_CHAR(n_regdate,'yyyy.mm.dd hh:mi'),n_hit FROM NOTICE n, CODE c WHERE n.CODE_VALUE = c.CODE_VALUE AND N_NO=?";
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				n = new NoticeVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			ConnectionProvider.close(rs, pstmt, conn);
		}catch (Exception e) {
			System.out.println("detailNotice 예외발생:"+e.getMessage());
		}
		return n;
	}
	
	
	public int insertNotice(NoticeVo n) {
		int re = -1;
		String sql = "insert into notice values(?,?,?,?,sysdate,0)";
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n.getN_no());
			pstmt.setString(2, n.getCode_value());
			pstmt.setString(3, n.getN_title());
			pstmt.setString(4, n.getN_content());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
		}catch (Exception e) {
			System.out.println("insertNotice 예외발생:"+e.getMessage());
		}
		
		return re;
	}
	
}
