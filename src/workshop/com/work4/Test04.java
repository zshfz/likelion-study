package workshop.com.work4;

public class Test04 {

	public static void main(String[] args) {
		int[] intArgs = new int[args.length];

		for (int i = 0; i < args.length; i++) {
			intArgs[i] = Integer.parseInt(args[i]);
		}

		Calc c = new Calc();

		char grade;
		int sum = c.calcSum(intArgs[0], intArgs[1], intArgs[2], intArgs[3]);
		double avg = sum / 4.0;
		
		
		
		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 70) {
			grade = 'B';
		} else if (avg >= 50) {
			grade = 'C';
		} else if (avg >= 30) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.println(sum);
		System.out.println(avg);
		System.out.println(grade);
	}

}

class Calc {
	public static int calcSum(int a, int b, int c, int d) {
		int sum = a + b + c + d;
		return sum;
	}
}
