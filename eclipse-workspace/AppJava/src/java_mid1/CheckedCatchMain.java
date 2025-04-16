package java_mid1;

class MyCheckedException extends Exception {
	public MyCheckedException(String message) {
		super(message);
	}
}

class Client {
	public void call() throws MyCheckedException {
		throw new MyCheckedException("ex");
	}
}

class Service {
	Client client = new Client();

	/**
	 * 예외를 잡아서 처리하는 코드
	 */
	public void callCatch() {
		try {
			client.call();
		} catch (MyCheckedException e) {
//예외 처리 로직
			System.out.println("예외 처리, message=" + e.getMessage());
		}
		System.out.println("정상 흐름");
	}

	/**
	 * 체크 예외를 밖으로 던지는 코드 체크 예외는 예외를 잡지 않고 밖으로 던지려면 throws 예외를 메서드에 필수로 선언해야한다.
	 */
	public void callThrow() throws MyCheckedException {
		client.call();
	}
}

public class CheckedCatchMain {

	public static void main(String[] args) {
		Service service = new Service();
		service.callCatch();
		System.out.println("정상 종료");
	}

}
