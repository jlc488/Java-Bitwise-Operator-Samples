package com.die;

import java.util.Random;

public class Die {

	private int faceValue;
	
	private Random random;
	
	public Die(){
		random = new Random();
		faceValue = this.roll();
	}
	
	public int roll() {
		return random.nextInt(7);
	}

	public int getFaceValue() {
		return faceValue;
	}
	
	
}

