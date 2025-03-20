package workshop.com.work4;

public class BookTest {

    public static void main(String[] args) {
        // Book 객체 배열 생성
        Book[] b = new Book[] {
                new Book("SQL PLUS", 50000, 5.0),
                new Book("Java 2.0", 40000, 3.0),
                new Book("SQL PLUS", 60000, 6.0),
        };
        
        // 각 책에 대한 정보 출력
        System.out.println("책이름\t\t가격\t할인율\t\t할인후금액");
        System.out.println("---------------------------------------------------");
        
        for (Book book : b) {
            // 책 이름, 가격, 할인율, 할인 후 금액을 출력
            System.out.println(book.getBookName() + "\t" + 
                               book.getBookPrice() + "원\t" + 
                               book.getBookDiscountRate() + "%\t\t" + 
                               book.getDiscountBookPrice() + "원");
        }
    }
}

class Book {
    private String bookName;
    private int bookPrice;
    private double bookDiscountRate;
    
    // 기본 생성자
    public Book() {
        super();
    }

    // 생성자
    public Book(String bookName, int bookPrice, double bookDiscountRate) {
        super();
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookDiscountRate = bookDiscountRate;
    }

    // 책 이름 getter
    public String getBookName() {
        return bookName;
    }

    // 책 가격 getter
    public int getBookPrice() {
        return bookPrice;
    }

    // 할인율 getter
    public double getBookDiscountRate() {
        return bookDiscountRate;
    }

    // 할인 후 금액 계산 메서드
    public double getDiscountBookPrice() {
        return bookPrice * (1 - bookDiscountRate / 100);
    }
}
