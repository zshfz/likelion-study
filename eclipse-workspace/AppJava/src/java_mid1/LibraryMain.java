package java_mid1;

class Library {
	private Book[] books;
	private int bookCount;

	public Library(int size) {
		books = new Book[size];
		bookCount = 0;
	}

	public void addBook(String title, String author) {
		if (bookCount < books.length) {
			books[bookCount] = new Book(title, author);
			bookCount++;
		} else {
			System.out.println("도서관 저장 공간이 부족합니다");
		}
	}

	public void showBooks() {
		for (int i = 0; i < books.length; i++) {
			System.out.println("도서 제목: " + books[i].title + ", 저자: " + books[i].author);
		}
	}

	private static class Book {
		private String title;
		private String author;

		public Book(String title, String author) {
			this.title = title;
			this.author = author;
		}
	}
}

public class LibraryMain {

    public static void main(String[] args) {
        Library library = new Library(4); // 최대 4권의 도서를 저장할 수 있는 도서관 생성
        library.addBook("책1", "저자1");
        library.addBook("책2", "저자2");
        library.addBook("책3", "저자3");
        library.addBook("자바 ORM 표준 JPA 프로그래밍", "김영한");
        // library.addBook("OneMoreThing", "잡스"); // 주석 처리 or 공간 부족 메시지 확인용

        library.showBooks(); // 도서관의 모든 도서 정보 출력
    }
}

