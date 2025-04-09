package com.student.controller;

import java.util.Scanner;

import com.student.model.Student;
import com.student.service.*;
import com.student.view.StudentConsoleView;

public class StudentController {
	private final StudentService service = new StudentServiceImple();
	private final StudentConsoleView view = new StudentConsoleView();
	Scanner sc = new Scanner(System.in);

	public void run() {
		while (true) {
			System.out.println("1. INSERT | 2. UPDATE | 3. DELETE | 4. SELECT | 0. EXIT");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				System.out.println("이름: ");
				String name = sc.nextLine();
				System.out.println("전공: ");
				String major = sc.nextLine();
				System.out.println("학점: ");
				String grade = sc.nextLine();

				Student s1 = new Student(name, major, grade);

				int res1 = service.insertStudent(s1);
				view.showMessage(res1 > 0 ? "INSERT 성공" : "INSERT 실패");
				break;
			case "2":
				System.out.println("이름: ");
				String update_name = sc.nextLine();
				System.out.println("수정할 학점: ");
				String update_grade = sc.nextLine();

				Student s2 = new Student();
				s2.setName(update_name);
				s2.setGrade(update_grade);

				int res2 = service.updateStudent(s2);
				view.showMessage(res2 > 0 ? "UPDATE 성공" : "UPDATE 실패");
				break;
			case "3":
				System.out.println("삭제 할 이름: ");
				String delete_name = sc.nextLine();
			
				Student s3 = new Student();
				s3.setName(delete_name);

				int res3 = service.deleteStudent(s3);
				view.showMessage(res3 > 0 ? "DELETE 성공" : "DELETE 실패");
				break;
			case "4":
				service.selectAll();
				break;
			case "0":
				view.showMessage("종료합니다");
				return;
			default:
				view.showMessage("잘못된 입력입니다");
			}
		}
	}
}
