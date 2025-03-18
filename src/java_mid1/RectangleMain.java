package java_mid1;

public class RectangleMain {

	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(100, 20);
		Rectangle rect2 = new Rectangle(100, 20);
		System.out.println(rect1);
		System.out.println(rect2);
		System.out.println(rect1 == rect2);
		System.out.println(rect1.equals(rect2));

	}

}

class Rectangle {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle{width=" + width + ",height=" + height + "}";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Rectangle r = (Rectangle)obj;
		return width == r.width && height == r.height;
	}
	
	

}
