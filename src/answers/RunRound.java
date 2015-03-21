package answers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunRound {

	public String round() throws IOException {
		
		int counter = 0;
		
		FileReader fr = new FileReader("./src/resources/hands.txt");
		BufferedReader reader = new BufferedReader(fr);

		RawCardList read = new RawCardList();
		
		String line = reader.readLine();
		String[] cardStrings = line.split(" ");
		
		reader.close();
		fr.close();

		List<String> cardList = new ArrayList<>();

		for(String s : cardStrings)
			cardList.add(s);

		CardIcons ci = new CardIcons();
		ci.icons(cardList);
		read.setCardList(cardList);

		CardValue values = new CardValue();
		CardValue suits = new CardValue();
		values.assignValue(read);
		suits.assignSuits(read);

		FindHighest high = new FindHighest();
		int p1score = 0;
		int p2score = 0;

		high.handRating(values.getNewValuesP1(), suits.getNewSuitsP1());
		p1score = high.countTotal();;
		high.handRating(values.getNewValuesP2(), suits.getNewSuitsP2());
		p2score = high.countTotal();


		if(p1score > p2score) {
			counter++;
			System.out.println("P1 Wins round\n");
			return "You Win!";
		}
		else if(p1score == p2score && values.getP1HighCard() > values.getP2HighCard()) {
			counter++;
			System.out.println("P1 Wins round\n");
			return "You Win!";
		}
		else if(p1score == p2score && values.getP1HighCard() >= values.getP2HighCard() && values.getP1CardTotal() > values.getP2CardTotal()) {
			counter++;
			System.out.println("P1 Wins round\n");
			return "You Win!";
		}
		else if(p1score == p2score && values.getP1HighCard() == values.getP2HighCard()) {
			System.out.println("Tie\n");
			return "Tie!";
		}
		else {
			System.out.println("P2 Wins round\n");
			return "CPU1 Wins!";
		}
		
	}


}
