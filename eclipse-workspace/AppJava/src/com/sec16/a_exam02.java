package com.sec16;

//Thread 클래스 이용해서 야옹이, 멍멍이 2개의 스레드를 생성해서 실행
public class a_exam02 extends Thread {
	public a_exam02(String thread_name) {
		super (thread_name); //Thread(String name);
	}
	@Override
	public void run() {
		for(int i=0;i<=50;i++) {
			System.out.println("나 스레드야 " + getName() + i);
		}
	}

	public static void main(String[] args) {
		//new Thread (new a_exam()).start();
	
		
		a_exam02 t1 = new a_exam02("야옹이");
		a_exam02 t2 = new a_exam02("멍멍이");
		t1.setPriority(9);
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		
		t1.start();
		t2.start();
	}

}
