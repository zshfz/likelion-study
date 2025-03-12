package workshop.com.work7;

public class Human {
	protected String name;
	protected int age;
	protected int height;
	protected int weight;
	
	public Human() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String printInformation() {
		return String.format("%5s %5d %5d %5d",getName(), getAge(), getHeight(), getWeight());
	}
	
	
	
}
