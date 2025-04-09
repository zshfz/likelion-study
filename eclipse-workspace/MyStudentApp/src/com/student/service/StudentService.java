package com.student.service;

import com.student.model.Student;

public interface StudentService {
	int insertStudent(Student s);
	int updateStudent(Student s);
	int deleteStudent(Student s);
	void selectAll();
}
