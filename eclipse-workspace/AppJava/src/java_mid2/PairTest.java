package java_mid2;

class Pair<T1, T2> {
	private T1 first;
	private T2 second;

	public void setFirst(T1 first) {
		this.first = first;
	}

	public void setSecond(T2 second) {
		this.second = second;
	}

	public T1 getFirst() {
		return first;
	}

	public T2 getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "Pair{" + "first=" + first + ", second=" + second + '}';
	}
}

public class PairTest {

	public static void main(String[] args) {
		Pair<Integer, String> pair1 = new Pair<>();
		pair1.setFirst(1);
		pair1.setSecond("data");
		System.out.println(pair1.getFirst());
		System.out.println(pair1.getSecond());
		System.out.println("pair1 = " + pair1);
		Pair<String, String> pair2 = new Pair<>();
		pair2.setFirst("key");
		pair2.setSecond("value");
		System.out.println(pair2.getFirst());
		System.out.println(pair2.getSecond());
		System.out.println("pair2 = " + pair2);
	}

}
