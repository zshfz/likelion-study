package java_mid1;

interface Hello {
	void hello();
}

public class AnonymousMain {

	public static void main(String[] args) {
		
		Hello hello = new Hello() {

			@Override
			public void hello() {
				System.out.println("Hello.hello");
				
			}
			
		};
		
		hello.hello();
	}

}
