package com.sec16;

//Runnable 인터페이스를 이용해서 야옹이, 멍멍이 2개의 스레드를 생성해서 실행
public class a_exam implements Runnable {
	@Override
	public void run() {
		System.out.println("나 스레드야");

	}

	public static void main(String[] args) {
		//new Thread (new a_exam()).start();
		Thread t1 = new Thread (new a_exam(), "cat");
		Thread t2 = new Thread (new a_exam(), "dog");
		t1.start();
		t2.start();
	}

}
