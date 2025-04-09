package com.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;

import com.person.model.Person;

//DB CRUD
// view <-> controller <-> dao <-> db
public class PersonDaoImple implements PersonDao {
	//1. insert
	public int insertPerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			 pstm = conn.prepareStatement(insert_sql); //쿼리 준비
			 pstm.setString(1, p.getName());
			 pstm.setString(2, p.getAddress());
			 pstm.setString(3, p.getPhone());
			 
			 res = pstm.executeUpdate();
			 commit(conn);
			 
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}
	
	//2. delete
	public int deletePerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			 pstm = conn.prepareStatement(delete_sql); //쿼리 준비
			 pstm.setString(1, p.getName());
			 res = pstm.executeUpdate();
			 commit(conn);
			 
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}
	
	//3. update
	public int updatePerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			 pstm = conn.prepareStatement(update_sql); //쿼리 준비
			 pstm.setString(3, p.getName());
			 pstm.setString(1, p.getAddress());
			 pstm.setString(2, p.getPhone());
			 
			 res = pstm.executeUpdate();
			 commit(conn);
			 
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}
	
	//4. select
	public List<Person> selectAllPerson() {
		List<Person> all = new ArrayList<>(); //전체 레코드를 Person으로 담아서 리턴 
		Connection conn = getConnection(); //연결
		Statement stmt = null; //명령
		ResultSet rs = null; //명령실행 결과 select를 참조할 객체
		Person person = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			while(rs.next()) {
				//case1 : 매개인자 생성자로 값 전달 후 add
				//all.add(new Person(rs.getString(1),rs.getString(2),rs.getString(3)));
				
				//case2 : 기본 생성자 객체 생성 후 setter로 값 전달 후 add
				person = new Person();
				person.setName(rs.getString(1));
				person.setAddress(rs.getString(2));
				person.setPhone(rs.getString(3));
				all.add(person);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
		
		return all;
	}

	@Override
	public Person searchByName(Person p) {
		Connection conn = getConnection(); //연결
		PreparedStatement pstmt = null; //명령
		ResultSet rs = null; //명령실행 결과 select를 참조할 객체
		Person person = null;
		
		try {
			pstmt = conn.prepareStatement(find_sql);
			pstmt.setString(1, p.getName());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				person = new Person();
				person.setName(rs.getString(1));
				person.setAddress(rs.getString(2));
				person.setPhone(rs.getString(3));
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {
			Close(rs);
			Close(pstmt);
			Close(conn);
		}
		
		return person;
	}

	@Override
	public List<Person> getPersonByPage(int page, int size) {
		List<Person> all = new ArrayList<>();
		Connection conn = getConnection(); //연결
		PreparedStatement pstmt = null; //명령
		ResultSet rs = null; //명령실행 결과 select를 참조할 객체
		Person person = null;
		
		try {
			pstmt = conn.prepareStatement(page_sql);
			pstmt.setInt(1, size);
			pstmt.setInt(2, (page-1)*size);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				person = new Person();
				person.setName(rs.getString(1));
				person.setAddress(rs.getString(2));
				person.setPhone(rs.getString(3));
				all.add(person);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {
			Close(rs);
			Close(pstmt);
			Close(conn);
		}
		
		return all;
	}
}
