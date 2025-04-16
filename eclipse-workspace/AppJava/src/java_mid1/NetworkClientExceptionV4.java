package java_mid1;

public class NetworkClientExceptionV4 extends RuntimeException {
	public NetworkClientExceptionV4(String message) {
		super(message);
	}
}

class ConnectExceptionV4 extends NetworkClientExceptionV4 {
	private final String address;

	public ConnectExceptionV4(String address, String message) {
		super(message);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}

class SendExceptionV4 extends NetworkClientExceptionV4 {
	private final String sendData;

	public SendExceptionV4(String sendData, String message) {
		super(message);
		this.sendData = sendData;
	}

	public String getSendData() {
		return sendData;
	}
}
