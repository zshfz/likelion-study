package com.sec01.exam;

public class h_exam {

public static void main(String[] args) {
// %d: 정수 (decimal integer)
System.out.printf("[%%d:] ->  %d\n", 100); // 100
System.out.printf("[%%d:] ->  %5d\n", 100);
// %f: 실수 (floating-point number)
System.out.printf("%%f: %.2f\n", 3.14159); // 3.14

// %c: 문자 (character)
System.out.printf("%%c: %c\n", 'A'); // A

// %s: 문자열 (string)
System.out.printf("%%s: %s\n", "Hello"); // Hello

// %x, %X: 16진수 (hexadecimal)
System.out.printf("%%x: %x\n", 255); // ff
System.out.printf("%%X: %X\n", 255); // FF

// %o: 8진수 (octal)
System.out.printf("%%o: %o\n", 8); // 10

// %b: 논리값 (boolean)
System.out.printf("%%b: %b\n", true); // true
}

}