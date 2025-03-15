package java_start;

public class MethodReturn {

	public static void main(String[] args) {
		boolean result = MethodReturn2.odd(3);
		System.out.println(result);
	}

}

class MethodReturn2{
	public static boolean odd(int i) {
		if (i % 2 == 1) {
			return true;
			}else {
				return false;
			}
	}
}