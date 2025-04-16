package java_mid1;

public class NetworkClientV1 {
	private final String address;
	public boolean connectError;
	public boolean sendError;
	
	public NetworkClientV1(String address) {
		this.address = address;
	}
	
	public void initError(String data) {
		if(data.contains("error1")) {
			connectError = true;
		}
		if(data.contains("error2")) {
			sendError = true;
		}
		
	}
	
	//서버 연결
	public String connect() {
		if(connectError) {
			System.out.println(address + "서버 연결 실패");
			return "connectError";
		}
		
		System.out.println(address + "서버 연결 성공");
		return "success";
	}
	
	//데이터 전송
	public String send(String data) {
		if(sendError) {
			System.out.println(address + "서버에 데이터 전송 실패: " + data);
			return "sendError";
		}
		
		System.out.println(address + "서버에 데이터 전송: " + data);
		return "success";
	}
	
	
	//서버 연결 해제
	public void disconnect() {
		System.out.println(address + "서버 연결 해제");
	}
}
