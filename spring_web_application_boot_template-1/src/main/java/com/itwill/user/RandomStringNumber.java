package com.itwill.user;

import java.util.Random;

public class RandomStringNumber {
	public static void RandomTest() {
		
		int leftLimit = 48; //numeral '0'
		int rightLimit = 122; //letter 'z'
		int targetStringLength = 10;
		
		Random random = new Random();
		String generateString =null;
		
		random.ints(leftLimit, rightLimit+1)
		.filter(i ->(i<=57||i>=65)&&(i<=90||i>97))
		.limit(targetStringLength)
		.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		.toString()
		;
		System.out.println(generateString);
	}
	
	public static void main(String[] args) {
		System.out.println("*******************************test");
		RandomTest();
	}
	
	  
	 	
}
