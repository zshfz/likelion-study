package workshop.com.work1;

public class Test04 {

	public static void main(String[] args) {
		char ch = 'G';
		
		String result = (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')
				? "입력한 문자 " + ch + "는 영문자 입니다"
				: "입력한 문자 " + ch + "는 영문자 아닙니다";
		
		System.out.println(result);

	}

}
