package workshop.com.work7;

import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data[] = new double[5];
		double sum = 0;
		double tot = 0;
			
		StringTokenizer st = new StringTokenizer(str, ",");
		
		
		for(int i=0;i<data.length;i++) {
			data[i] = Double.parseDouble(st.nextToken());
		}
		
		for(int i=0;i<data.length;i++) {
			sum += data[i];
			tot++;
		}
		
		System.out.printf("합계 :  %.3f\n", sum);
		System.out.printf("평균 :  %.3f", sum/tot);
	}

}
