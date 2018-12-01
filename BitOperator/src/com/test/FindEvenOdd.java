package com.test;
/**
 * & operator will compare the bit and if the bits are 1 then 
 * it will return 1 or return 0
 * 
 * ex) 0000 1001 & 0000 0001 -> it will return 0000 0001
 * ex) 0000 1000 & 0000 0001 -> it will return 0000 0000
 * 
 * if number is odd it will return 1
 * if number is even it will return 0
 * @author Sin-Kang
 *
 */
public class FindEvenOdd {
	
	private boolean checkEven(int a) {
		return (a & 1) == 0;
	}

	public static void main(String[] args) {
		FindEvenOdd ff = new FindEvenOdd();
		
		int a = 4;
		
		if( ff.checkEven(a)) {
			System.out.println("The number is EVEN");
		}else {
			System.out.println("The number is ODD");
		}

	}

}
