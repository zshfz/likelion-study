package java_start;

public class ChangeVarEx {
	public static void main(String[] args) {
		//변수값 서로 바꾸기
		int a = 10;
		int b = 20;
		int temp;
//시작: 코드를 작성하세요
		temp = a;
		a = b;
		b = temp;
//종료: 코드를 작성하세요
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
