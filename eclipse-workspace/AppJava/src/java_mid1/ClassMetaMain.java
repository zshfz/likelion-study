package java_mid1;

import java.lang.reflect.Field;

public class ClassMetaMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = String.class;
		System.out.println(clazz1);
		
//		Class clazz2 = new String().getClass();
//		System.out.println(clazz2);
//		
//		Class clazz3 = Class.forName("java.lang.Integer");
//		System.out.println(clazz3);
		
		
		Field[] fields = clazz1.getDeclaredFields();
		for (Field field : fields) {
		System.out.println(field.getName());
		}
		
	}

}
