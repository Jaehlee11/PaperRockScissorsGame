package anz.coding.challenge;

import java.util.ArrayList;

public class RoundResult {
	
	private String newline = System.getProperty("line.separator");

	private ArrayList<Round> results = new ArrayList<>();
	private int userWins = 0;
	private int ties = 0;
	private int computerWins = 0;
	
	class Round {
		int user;
		int computer;
		int result;
		
		Round(int user, int computer) {
			this.user = user;
			this.computer = computer;
		}
		
		String getResult() {
			switch(result) {
			case Rule.WIN:
				return "WIN";
			case Rule.LOSE:
				return "LOSE";
			default:
				return "TIE";
			}
		}
		
		String getUser() {
			return getValueToString(user);
		}
		
		String getComputer() {
			return getValueToString(computer);
		}
		
		String getValueToString(int value) {
			switch(value) {
			case Rule.PAPER:
				return "PAPER";
			case Rule.ROCK:
				return "ROCK";
			case Rule.SCISSOR:
				return "SCISSOR";
			default:
				return "";
			}
		}
	}
	
	public void addRound(int user, int computer) {
		Round round = new Round(user, computer);
		round.result = Rule.winRound(user, computer);
		results.add(round);
		
		switch(round.result) {
		case Rule.WIN:
			userWins++;
			break;
		case Rule.LOSE:
			computerWins++;
			break;
		default:
			ties++;	
		}
	}
	
	public int getRoundNumber() {
		return results.size() + 1;
	}
	
	public String score() {
		return String.format("USER: %s, TIES: %s, COMPUTER: %s", userWins, ties, computerWins);
	}
	
	public String result() {
		Round round = results.get(results.size() - 1);
		return String.format("%4s : USER[%s] / COMPUTER[%s]", round.getResult(), round.getUser(), round.getComputer());
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(String.format("ROUND  RESULT      USER   COMPUTER")).append(newline);
		for(int i = 0; i < results.size(); i++) {
			Round round = results.get(i);
			stringBuffer.append(String.format("#%-2s  ->  %4s : %7s / %-7s", (i+1), round.getResult(), round.getUser(), round.getComputer())).append(newline);
		}
		stringBuffer.append(newline).append(score()).append(newline).append(newline);
		return stringBuffer.toString();
	}
}
