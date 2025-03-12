package workshop.com.work7;

//InvalidException.java
class InvalidException extends Exception {
	public InvalidException() {
		super("입력 값에 오류가 있습니다.");
	}
}

//Calc.java
class Calc {
	public double getSum(int data) throws InvalidException {
		// 입력 값이 2에서 5 범위를 벗어나면 예외 발생
		if (data < 2 || data > 5) {
			throw new InvalidException();
		}

		// 1부터 data까지의 합 계산
		double sum = 0;
		for (int i = 1; i <= data; i++) {
			sum += i;
		}
		return sum;
	}
}

//ExTest.java
public class ExTest {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("입력 값이 없습니다. 숫자를 입력해 주세요.");
			return; // 프로그램 종료
		}
		try {
			// 입력 값 처리 (예시로 5를 입력)
			int input = Integer.parseInt(args[0]);

			// Calc 객체 생성 및 getSum 호출
			Calc calc = new Calc();
			double result = calc.getSum(input);

			// 결과 출력
			System.out.println("결과 값: " + result);
		} catch (InvalidException e) {
			// InvalidException 처리
			System.out.println(e.getMessage());
		}
	}
}
