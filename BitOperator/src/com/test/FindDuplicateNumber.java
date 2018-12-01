package com.test;

/**
 *  ^ operator compare the bit and if they are not same it will return 1
 *  which means if they are same in bit it will become in 0 in decimal
 *  
 *  ex) 0000 1001 ^ 0000 1001 -> it will return 0000 0000
 *  
 * @author Sin-Kang
 *
 */
public class FindDuplicateNumber {

	private boolean checkDuplicateNumber(int a, int b) {
		return (a ^ b) == 0; 
	}
	
	public static void main(String[] args) {
	
		FindDuplicateNumber ff = new FindDuplicateNumber();
		
		int a = 4;
		int b = 4;
		
		if( ff.checkDuplicateNumber(a, b) ) {
			System.out.println("Number is duplicated");
		}else {
			System.out.println("Number is not duplicated");
		}
		
	}
}
