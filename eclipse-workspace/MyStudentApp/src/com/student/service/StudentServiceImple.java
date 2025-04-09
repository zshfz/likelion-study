package com.student.service;

import com.student.model.Student;
import com.student.dao.StudentDaoImple;
import com.student.dao.StudentDao;

public class StudentServiceImple implements StudentService {
	private final StudentDao dao = new StudentDaoImple();
	
	@Override
	public int insertStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.insertStudent(s);
	}

	@Override
	public int updateStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.updateStudent(s);
	}

	@Override
	public int deleteStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(s);
	}

	@Override
	public void selectAll() {
		dao.selectAll();
		
	}

}
