package answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunRound {
	
	private List<String> playerHands = new ArrayList<>();
	private String winner = "";

	public void round() {
		
		CardValue values = new CardValue();
		CardValue suits = new CardValue();
		values.assignValue(playerHands);
		suits.assignSuits(playerHands);

		FindHighest high = new FindHighest();
		int p1score = 0;
		int p2score = 0;

		high.handRating(values.getNewValuesP1(), suits.getNewSuitsP1());
		p1score = high.countTotal();;
		high.handRating(values.getNewValuesP2(), suits.getNewSuitsP2());
		p2score = high.countTotal();


		if(p1score > p2score) 
			winner = "You Win This Round!";
		else if(p1score == p2score && values.getP1CardTotal() > values.getP2CardTotal() && values.getP1HighCard() > values.getP2HighCard())
			winner = "You Win This Round!";
		else if(p1score == p2score && values.getP1HighCard() >= values.getP2HighCard() && values.getP1CardTotal() > values.getP2CardTotal()) 
			winner = "You Win This Round!";
		else if(p1score == p2score && values.getP1HighCard() == values.getP2HighCard() && values.getP1CardTotal() == values.getP2CardTotal()) 
			winner = "You Win This Round!";
		else
			winner = "You Lose! CPU1 Wins Round";
		
	}
	
	public void setPlayerHands(List<String> cardList) {
		this.playerHands = cardList;
	}
	
	public List<String> getPlayerHands() {
		return playerHands;
	}
	
	public List<String> getP1Cards() {
		Collections.sort(playerHands.subList(0,5));
		return playerHands.subList(0,5);
	}
	
	public List<String> getCPU1Cards() {
		Collections.sort(playerHands.subList(5,10));
		return playerHands.subList(5,10);
	}
	
	public List<String> getCPU2Cards() {
		Collections.sort(playerHands.subList(10,15));
		return playerHands.subList(10,15);
	}
	
	public List<String> getCPU3Cards() {
		Collections.sort(playerHands.subList(15,20));
		return playerHands.subList(15,20);
	}
	
	public List<String> getCPU4Cards() {
		Collections.sort(playerHands.subList(20,25));
		return playerHands.subList(20,25);
	}

	public String whoWins() {
		return winner;
	}

}
