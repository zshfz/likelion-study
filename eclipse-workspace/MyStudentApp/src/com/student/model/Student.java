package com.student.model;

public class Student {
	private int id;
	private String name;
	private String major;
	private String grade;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String major, String grade) {
		super();
		this.name = name;
		this.major = major;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
