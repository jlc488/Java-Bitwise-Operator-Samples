package com.test;

public class FindNoOfCharacterRepeatedInString {

	public static void main(String[] args) {
		String a = "sin kang is so handsome";
		char[] arr = a.toCharArray();
		
		int counter = 0;
		
		for(int i =0; i < arr.length; i++) {
			if( ((int)arr[i] ^ (int)'s') == 0) {
				counter++;
			}
		}
			
		System.out.println(counter);

	}

}
