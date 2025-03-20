package workshop.com.work1;

public class Test07 {

	public static void main(String[] args) {
		char ch = 'A';
		printResult(ch);
	}
	
	public static boolean isAlphabet(char ch) {
		return (ch >= 'A' && ch <= 'Z') || (ch >= 'A' && ch <= 'Z');
	}

	public static void printResult(char ch) {
		String result = isAlphabet(ch)
		? "입력한 문자 '" + ch + "'는 영문자입니다."
		: "입력한 문자 '" + ch + "'는 영문자가 아닙니다.";
		System.out.println(result);
	}
}
