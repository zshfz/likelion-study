package com.sec03;

public class MTest01 {

	public static void main(String[] args) {
		MyAddress a1 = new MyAddress();
		MyAddress b1 = new MyAddress();
		MyAddress c1 = new MyAddress();
		
		a1.setInfo("홍길동", "서울", "010-1234-5678");
		b1.setInfo("정길동", "인천", "031-1234-5678");
		c1.setInfo("최길동", "부산", "051-1234-5678");
		
		System.out.println("======== 주소록 ========");
		System.out.printf("%10s %10s %15s\n", a1.getName(), a1.getAddress(), a1.getTelNum());
		System.out.printf("%10s %10s %15s\n", b1.getName(), b1.getAddress(), b1.getTelNum());
		System.out.printf("%10s %10s %15s\n", c1.getName(), c1.getAddress(), c1.getTelNum());
		
		System.out.println("Q1. 홍길동을 이길동으로 변경후 a1 출력해보자");
		a1.setInfo("이길동", "서울", "010-1234-5678");
		System.out.printf("%10s %10s %15s\n", a1.getName(), a1.getAddress(), a1.getTelNum());
		
		System.out.println("Q2. 인천을 제주도로 변경후 정길동과 제주도만 출력해보자");
		b1.setInfo("정길동", "제주도", "031-1234-5678");
		System.out.printf("%10s %10s\n", b1.getName(), b1.getAddress());
		
		System.out.println("Q3. 부산을 대구로 변경후 이름과 대구를 출력해보자");
		c1.setInfo("최길동", "대구", "051-1234-5678");
		System.out.printf("%10s %10s\n", c1.getName(), c1.getAddress());
		
		System.out.println("Q4. 최길동의 전화번호를 000으로 변경 후 전체 c1의 레코드를 출력해보자");
		c1.setInfo("최길동", "대구", "000");
		System.out.printf("%10s %10s %15s\n", c1.getName(), c1.getAddress(), c1.getTelNum());
		
		System.out.println("Q5. 3명 레코드의 이름만 출력해보자");
		System.out.printf("%10s %10s %10s\n", a1.getName(), b1.getName(), a1.getTelNum());
		
		
	}

}

class MyAddress {
	private String name;
	private String address;
	private String telNum;
	
	public void setInfo(String name, String address, String telNum) {
		this.name = name;
		this.address = address;
		this.telNum = telNum;
	}
	
	public String getName() {
		return  name;
	}
	
	public String getAddress() {
		return  address;
	}
	
	public String getTelNum() {
		return  telNum;
	}
}
