package workshop.com.work15;

public class B15_1 {	   
	    public static void main(String[] args) {
	    	
	    	Thread.Builder builder = Thread.ofVirtual().name("my-thread");
	    	
	    	Runnable task = () -> System.out.println("스레드 실행");

	    	Thread thread = builder.unstarted(task); // 스레드 객체만 생성, 아직 시작 안됨

	    	// 스레드 시작 전에 추가 설정
	    	thread.setUncaughtExceptionHandler((t, e) -> System.err.println("예외 발생: " + e.getMessage()));

	    	thread.start(); // 스레드 시작
	    }
	}
