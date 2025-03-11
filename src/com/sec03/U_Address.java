package com.sec03;

class U_Address {
	private String name;
	private String address;
	private String telNum;
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getTelNum() {
		return telNum;
	}



	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}



	@Override
	public String toString() {
		return String.format("U_Address [getName()=%s, getAddress()=%s, getTelNum()=%s]", getName(), getAddress(),
				getTelNum());
	}



	public static void main(String[] args) {
		U_Address a1 = new U_Address();
		U_Address b1 = new U_Address();
		
//		a1.prn();
//		b1.prn();
		a1.setName("111");
		a1.setAddress("111");
		a1.setTelNum("111");
		
		System.out.println(a1);
		System.out.println(b1);
	}
}
