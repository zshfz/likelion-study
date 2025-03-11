package com.sec06;

import java.util.Objects;

class U_Address {
	private String name;
	private String address;
	private String telNum;
	

	public U_Address() { //기본생성자
		
	}



	public U_Address(String name, String address, String telNum) {
		super();
		this.name = name;
		this.address = address;
		this.telNum = telNum;
	}

	





	@Override
	public int hashCode() {
		return Objects.hash(name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		U_Address other = (U_Address) obj;
		return Objects.equals(name, other.name);
	}



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
		U_Address u1 = new U_Address("홍길동", "성남", "111");
		U_Address u2 = new U_Address("홍길동", "성남", "111");
		
		System.out.println(u1.equals(u2));
		System.out.println(u1.hashCode());
	}

}
