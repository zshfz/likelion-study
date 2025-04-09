package com.student.dao;

import com.student.model.Student;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImple implements StudentDao {

	@Override
	public int insertStudent(Student s) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMajor());
			pstmt.setString(3, s.getGrade());
			res = pstmt.executeUpdate();
			commit(conn);
		}catch(SQLException e){
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstmt);
			Close(conn);
		}
		return res;
	}

	@Override
	public int updateStudent(Student s) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, s.getGrade());
			pstmt.setString(2, s.getName());
			res = pstmt.executeUpdate();
			commit(conn);
		}catch(SQLException e){
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstmt);
			Close(conn);
		}
		return res;
	}

	@Override
	public int deleteStudent(Student s) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.setString(1, s.getName());
			res = pstmt.executeUpdate();
			commit(conn);
		}catch(SQLException e){
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstmt);
			Close(conn);
		}
		return res;
	}

	@Override
	public void selectAll() {
		Connection conn = getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
		pstmt = conn.prepareStatement(select_sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
		}
	    }catch(SQLException e){
			e.printStackTrace();
		}finally {
			Close(rs);
			Close(pstmt);
			Close(conn);
		}
	}

}
