package java_basic;

public class ShopMain {

	public static void main(String[] args) {
		Book book = new Book("JAVA", 10000, "han", "12345");
		Album album = new Album("앨범1", 15000, "seo");
		Movie movie = new Movie("영화1", 18000, "감독1", "배우1");
		book.print();
		album.print();
		movie.print();
		int sum = book.getPrice() + album.getPrice() + movie.getPrice();
		System.out.println("상품 가격의 합: " + sum);
	}

}

class Item {
	private String name;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public void print() {
		System.out.println("이름: " + name + ", 가격: " + price);
	}

	public int getPrice() {
		return price;
	}

}

class Book extends Item {
	private String author;
	private String isbn;

	public Book(String name, int price, String author, String isbn) {
		super(name, price);
		this.author = author;
		this.isbn = isbn;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("- 저자:" + author + ", isbn:" + isbn);
	}

}

class Album extends Item {
	private String artist;

	public Album(String name, int price, String artist) {
		super(name, price);
		this.artist = artist;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("- 아티스트:" + artist);
	}

}

class Movie extends Item {
	private String director;
	private String actor;

	public Movie(String name, int price, String director, String actor) {
		super(name, price);
		this.director = director;
		this.actor = actor;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("- 감독:" + director + ", 배우:" + actor);
	}

}