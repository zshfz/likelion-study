package workshop.com.work6;

public class Test03 {

	public static void main(String[] args) {
		int[] intArg = new int[args.length];
		int sum = 0;
		
		for(int i=0;i<args.length;i++) {
			intArg[i] = Integer.parseInt(args[i]);
		}
		
		for(int i = intArg[0];i<=10;i++) {
			if(i % 3 != 0 && i % 5 != 0) {
				sum += i;
			}
		}
		
		System.out.println("결과 : " + sum);
		
	}

}
