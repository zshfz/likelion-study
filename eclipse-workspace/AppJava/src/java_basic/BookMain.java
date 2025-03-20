//package java_basic;
//
//class Book{
//	String title; //제목
//	String author; //저자
//	int page; //페이지 수
//	
//	Book(){
//		
//	}
//	
//	Book(String title, String author){
//		this.title = title;
//		this.author = author;
//	}
//	
//	Book(String title, String author, int page){
//		this(title, author);
//		this.page = page;
//	}
//	
//	void displayInfo() {
//		System.out.println("제목: " + title + ", 저자: " + author + ", 페이지 수: " + page);
//	}
//}
//
//public class BookMain {
//
//	public static void main(String[] args) {
//		// 기본 생성자 사용
//		Book book1 = new Book();
//		book1.displayInfo();
//		// title과 author만을 매개변수로 받는 생성자
//		Book book2 = new Book("Hello Java", "Seo");
//		book2.displayInfo();
//		// 모든 필드를 매개변수로 받는 생성자
//		Book book3 = new Book("JPA 프로그래밍", "kim", 700);
//		book3.displayInfo();
//		
//	}
//
//}
