package java_mid1;

class OuterClass1{
	static class NestedClass{
		public void hello() {
			System.out.println("NestedClass.hello");
		}
	}
}

public class OuterClass1Main {

	public static void main(String[] args) {
		OuterClass1.NestedClass nested = new OuterClass1.NestedClass();
		nested.hello();
	}

}
