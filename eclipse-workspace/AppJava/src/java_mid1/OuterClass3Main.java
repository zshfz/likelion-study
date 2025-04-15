package java_mid1;

class OuterClass3{
	public void myMethod() {
		class LocalClass{
			public void hello() {
				System.out.println("LocalClass.hello");
			}
		}
		
		LocalClass local = new LocalClass();
		local.hello();
	}
}

public class OuterClass3Main {

	public static void main(String[] args) {
		OuterClass3 outerClass3 = new OuterClass3();
		outerClass3.myMethod();
		
	}

}
