package com.student.dao;

import com.student.model.Student;

public interface StudentDao {
	String insert_sql = "insert into student(name, major, grade) values(?,?,?)";
	String update_sql = "update student set grade=? where name=?";
	String delete_sql = "delete from student where name=?";
	String select_sql = "select id, name, major, grade from student";
	
	public int insertStudent(Student s);
	public int updateStudent(Student s);
	public int deleteStudent(Student s);
	public void selectAll();
}
