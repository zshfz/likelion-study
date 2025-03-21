package workshop.com.work7;

public class Student extends Human {
	private String number;
	private String major;
	
	public Student() {
		super();
	}
	
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String printInformation() {
		return String.format("%5s %5s %5s",super.printInformation(), getNumber(), getMajor());
	}
}
