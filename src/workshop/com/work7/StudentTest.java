package workshop.com.work7;

public class StudentTest {

	public static void main(String[] args) {
		Student arrays [] = new Student[3];
		arrays[0] = new Student("홍길동", 15, 171, 81, "201101", "영문");
		arrays[1] = new Student("한사람", 15, 171, 81, "201101", "건축");
		arrays[2] = new Student("임걱정", 15, 171, 81, "201101", "무용");
		
		for(Student a : arrays) {
			System.out.println(a.printInformation());
		}
	}
	
}
