package answers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffler {

	public void shuffle(int numPlayers) throws IOException {
		
		FileWriter fw = new FileWriter("./src/resources/hands.txt");
	    	
		List<String> deck = new ArrayList<>();

		deck.add("2C");
		deck.add("2D");
		deck.add("2H");
		deck.add("2S");
		deck.add("3C");
		deck.add("3D");
		deck.add("3H");
		deck.add("3S");
		deck.add("4C");
		deck.add("4D");
		deck.add("4H");
		deck.add("4S");
		deck.add("5C");
		deck.add("5D");
		deck.add("5H");
		deck.add("5S");
		deck.add("6C");
		deck.add("6D");
		deck.add("6H");
		deck.add("6S");
		deck.add("7C");
		deck.add("7D");
		deck.add("7H");
		deck.add("7S");
		deck.add("8C");
		deck.add("8D");
		deck.add("8H");
		deck.add("8S");
		deck.add("9C");
		deck.add("9D");
		deck.add("9H");
		deck.add("9S");
		deck.add("TC");
		deck.add("TD");
		deck.add("TH");
		deck.add("TS");
		deck.add("JC");
		deck.add("JD");
		deck.add("JH");
		deck.add("JS");
		deck.add("QC");
		deck.add("QD");
		deck.add("QH");
		deck.add("QS");
		deck.add("KC");
		deck.add("KD");
		deck.add("KH");
		deck.add("KS");
		deck.add("AC");
		deck.add("AD");
		deck.add("AH");
		deck.add("AS");

		Collections.shuffle(deck);

		for(int i = 0; i < numPlayers*5; i++) {
			fw.write(deck.get(i) + " ");
		}

		fw.write("\n");

		fw.close();
		
	}

}
