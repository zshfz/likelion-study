package java_start;

public class ForEx {

	public static void main(String[] args) {
//		반복문을 사용하여 처음 10개의 짝수를 출력하는 프로그램을 작성해 보세요. 이때, `num` 이라는 변수를 사용하여 수를
//		표현해야 합니다.
		
		for(int i=2, count=1;;i+=2,count++) {
			System.out.println(i);
			if(count == 10	) {
				break;
			}
		}
	}

}
