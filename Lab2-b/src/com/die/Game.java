package com.die;

public class Game {

	private static int pointsEarned = 0;
	private static int die1Value = 0;
	private static int die2Value = 0;
	
	public static void playChicago() {
		Die die1 = new Die();
		Die die2 = new Die();
		
		die1Value = die1.getFaceValue();
		die2Value = die2.getFaceValue();
		
		System.out.println("Frist die value was " + die1Value);
		System.out.println("Second die value was " + die2Value);
	}
	
	
	public static void main(String[] args) {
		
		for(int i=2; i <=12; i++) {
			System.out.println("Round Number " + i);
			Game.playChicago();
			if( (Game.die1Value + Game.die2Value) == i ) {
				Game.pointsEarned ++;
				System.out.println("Points earned 1");
			}
			System.out.println();
		}
		
		System.out.println("Total Points Earned : " + Game.pointsEarned);
	}
}
