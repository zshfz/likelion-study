package com.person.controller;

import com.person.model.*;
import com.person.service.*;
import com.person.view.*;

import java.util.List;
import java.util.Scanner;

public class PersonController {
	private final PersonService service = new PersonServiceImple();
	private final PersonConsolView view = new PersonConsolView();
	private final Scanner sc = new Scanner(System.in);

	public void run() {
		while (true) {
			System.out.println("1. 전체 출력  | 2. 추가 | 3. 삭제 | 4. 수정 | 5. 찾기 | 6. 파일 저장 | 7. 페이징 처리 | 0.  종료");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				// 서비스 컴포넌트가 받은 dao의 결과를 view에게 전달
				view.showAllList(service.selectAllPerson());
				break;
			case "2":
				// 1. input view에서 데이터 입력
				System.out.println("이름: ");
				String name = sc.nextLine();
				System.out.println("주소: ");
				String address = sc.nextLine();
				System.out.println("전화번호: ");
				String phone = sc.nextLine();

				// 2. Person 객체 생성해서 데이터 저장
				Person p1 = new Person(name, address, phone);

				// 3. controller person 객체 값을 service dao 전달
				//if(service.searchByName(p) != null) {입력한 이름이 존재하면 차단하겠다}
				int res1 = service.insertPerson(p1);
				view.showMessage(res1 > 0 ? "INSERT 성공" : "INSERT 실패");
				break;

			case "3":
				System.out.println("삭제 할 이름: ");
				String delete_name = sc.nextLine();
				Person p2 = new Person();
				p2.setName(delete_name);
				view.showMessage(service.deletePerson(p2) > 0 ? "DELETE 성공" : "DELETE 실패");
				break;
			case "4":
				// 1. input view에서 데이터 입력
				System.out.println("이름: ");
				String update_name = sc.nextLine();
				System.out.println("수정할 주소: ");
				String update_address = sc.nextLine();
				System.out.println("수정할 전화번호: ");
				String update_phone = sc.nextLine();

				// 2. Person 객체 생성해서 데이터 저장
				Person p3 = new Person(update_name, update_address, update_phone);

				// 3. controller person 객체 값을 service dao 전달
				int res2 = service.updatePerson(p3);
				view.showMessage(res2 > 0 ? "UPDATE 성공" : "UPDATE 실패");
				break;
			case "5":
				System.out.println("검색할 이름: ");
				String find_name = sc.nextLine();
				Person p4 = new Person();
				p4.setName(find_name);

				Person found = service.searchByName(p4);
				if (found != null) {
					view.showAllList(List.of(found));
				} else {
					view.showMessage("검색결과 없음");
				}
				break;
			case "6":
				System.out.print("저장할 파일을 입력하세요: ");
				String file_name = sc.nextLine();
				view.savToFile(service.selectAllPerson(), file_name);
				break;
			case "7":
				//페이징 처리
				//select * from person LIMIT ? OFFSET ?;
				System.out.print("페이지 번호: ");
				int page = Integer.parseInt(sc.nextLine());
				System.out.print("페이지 크기: ");
				int size = Integer.parseInt(sc.nextLine());
				
				List<Person> pageList = service.getPersonByPage(page, size);
				view.showAllList(pageList);
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
