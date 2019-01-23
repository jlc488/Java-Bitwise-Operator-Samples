package com.test;

import java.util.Arrays;

public class FindSmallestOfTwo {

	
	public int solution(int[] A) {
		int min1 = Arrays.stream(A).min().getAsInt();
		int min2 = Arrays.stream(A).filter(n -> n != min1).boxed().findFirst().get().intValue();
		
		int ret = min1 + min2;
		
		Arrays.stream(A).filter(n -> n != ret).boxed().findFirst().get().intValue();
		
		return min1 + min2;
	}
	
	
	public static void main(String[] args) {
		FindSmallestOfTwo ff = new FindSmallestOfTwo();
		int[] A = {1,2,3};
		
		System.out.println(ff.solution(A));
	}
}
