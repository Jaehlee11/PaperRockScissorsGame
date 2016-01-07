package anz.coding.challenge;

import java.util.Random;

public class Rule {
	
	public static final int WIN		= 1;
	public static final int TIE		= 0;
	public static final int LOSE	= -1;
	
	public static final int PAPER	= 1;
	public static final int ROCK	= 2;
	public static final int SCISSOR	= 3;
	public static final int EXIT	= 99;
	
	private static Random rand = new Random();
	
	public static int winRound(int user, int computer) {
		int result = LOSE;
		if(user == computer) {
			result = Rule.TIE;
		} else {
			switch (user) {
			case Rule.PAPER:
				if (computer == Rule.ROCK) {
					result = WIN;
				}
				break;
			case Rule.ROCK:
				if (computer == Rule.SCISSOR) {
					result = WIN;
				}
				break;
			case Rule.SCISSOR:
				if (computer == Rule.PAPER) {
					result = WIN;
				}
				break;
			}
		}
		return result;
	}
	
	public static int getNewComputerValue() {
		return rand.nextInt(3) + 1;
	}
}
