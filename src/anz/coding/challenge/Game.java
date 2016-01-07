package anz.coding.challenge;

import java.io.Console;

public class Game {

	public static void main(String[] args) {
		
		Console console = System.console();
		if(console != null) {
			console.printf("This is a Paper Rock Scissors Game.\nYou can choose one each round and all rounds will be recorded.");
			console.printf("\n[P, R, S, E] is avaliable input and E is to end this game.");
			RoundResult roundResult = new RoundResult();
			String input = "";
			while(!input.equals("E")) {
				console.printf("\n=== Round #%s ===", roundResult.getRoundNumber());
				console.printf("\n%s", roundResult.score());
				input = console.readLine("\nChoose one of [P]aper, [R]ock, [S]cissors and [E]xit: ").toUpperCase();
				
				if(input.equals("E")) {
					console.printf("\n%s", roundResult.toString());
				} else if (input.equals("P") || input.equals("R") || input.equals("S")){
					roundResult.addRound((input.equals("P")) ? Rule.PAPER : (input.equals("R")) ? Rule.ROCK: Rule.SCISSOR
							, Rule.getNewComputerValue());
					console.printf("\n%s\n", roundResult.result());
				} else {
					console.printf("Input is invalid.");
				}
			}
		}
	}
}
