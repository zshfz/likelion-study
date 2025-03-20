package com.sec02;
	public class BitOperator {
		
		public static void prn() {
			int a=51;
			int b=240;
			
			 System.out.println("AND ="+( a&b));
			 System.out.println("OR=" +(a|b));
			 System.out.println("XOR="+(a^b));
		}
		
		public static String BinaryStringPadding(int res) {
			String result = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
			return result;
		}
		
		public static String BinaryStringPadding_float(float res) {
			String result = String.format("%32s", Float.toHexString(res)).replace(' ', '0');
			return result;
		}
		
		public static void main(String[] args) {
			//정수를 2진 문자열로 변경해보자
			int a=51;
			int b=240;
			
			System.out.println("a의 51을 2진 문자열로  = " + Integer.toBinaryString(a));
			System.out.println("b의 240을 2진 문자열로  = " + Integer.toBinaryString(a));
			
			//Integer.toBinaryString(a)의 문자열로 리턴받은 이진 문자열의 32자리로 만들고 빈공간을 0으로 채우자
			String str = BinaryStringPadding(a);
			System.out.println(str);
			
			String str02 = BinaryStringPadding(b);
			System.out.println(str02);
			
			String str03 = BinaryStringPadding(-20);
			System.out.println(str03);
			
			int res_a = 2;
			System.out.println(BinaryStringPadding(res_a));
			
			float res_b = 72.f;
			System.out.println(BinaryStringPadding_float(res_b));
			
			double doubleValue = 3.14159265359;
			long bits = Double.doubleToLongBits(doubleValue);
			String binaryString = Long.toBinaryString(bits);
			System.out.println("bits = " + bits);
			System.out.println("binaryString = " + binaryString);
			
			System.out.println("=========NaN=========");
			double non_value = Double.NaN;
			System.out.println(non_value);
			
			long res_c = Double.doubleToLongBits(non_value);
			System.out.println(res_c);
			System.out.println(Long.toBinaryString(res_c));
			
			long res_d = Double.doubleToRawLongBits(non_value);
			System.out.println(res_d);
			System.out.println(Long.toBinaryString(res_d));
		}
		
		
	}




	
	
