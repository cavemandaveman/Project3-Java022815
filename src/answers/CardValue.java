package answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardValue {
	
	private Map<String, Integer> values = new HashMap<>();
	private Map<String, Integer> suits = new HashMap<>();
	private List<Integer> newValues = new ArrayList<>();
	private List<Integer> newSuits = new ArrayList<>();
	private List<Integer> p1Values = new ArrayList<>();
	private List<Integer> p2Values = new ArrayList<>();
	private List<Integer> p1Suits = new ArrayList<>();
	private List<Integer> p2Suits = new ArrayList<>();
	private int p1CardTotal;
	private int p2CardTotal;
	private int p1HighCard;
	private int p2HighCard;
	
	public void assignValue(List<String> list) {
		values.put("2C", 2);
        values.put("2D", 2);
        values.put("2H", 2);
        values.put("2S", 2);
        values.put("3C", 3);
        values.put("3D", 3);
        values.put("3H", 3);
        values.put("3S", 3);
        values.put("4C", 4);
        values.put("4D", 4);
        values.put("4H", 4);
        values.put("4S", 4);
        values.put("5C", 5);
        values.put("5D", 5);
        values.put("5H", 5);
        values.put("5S", 5);
        values.put("6C", 6);
        values.put("6D", 6);
        values.put("6H", 6);
        values.put("6S", 6);
        values.put("7C", 7);
        values.put("7D", 7);
        values.put("7H", 7);
        values.put("7S", 7);
        values.put("8C", 8);
        values.put("8D", 8);
        values.put("8H", 8);
        values.put("8S", 8);
        values.put("9C", 9);
        values.put("9D", 9);
        values.put("9H", 9);
        values.put("9S", 9);
        values.put("TC", 10);
        values.put("TD", 10);
        values.put("TH", 10);
        values.put("TS", 10);
        values.put("JC", 11);
        values.put("JD", 11);
        values.put("JH", 11);
        values.put("JS", 11);
        values.put("QC", 12);
        values.put("QD", 12);
        values.put("QH", 12);
        values.put("QS", 12);
        values.put("KC", 13);
        values.put("KD", 13);
        values.put("KH", 13);
        values.put("KS", 13);
        values.put("AC", 14);
        values.put("AD", 14);
        values.put("AH", 14);
        values.put("AS", 14);
        
        for(int i = 0; i < list.size(); i++) {
        	newValues.add(values.get(list.get(i)));
        }
	}
	
	public void assignSuits(List<String> list) {
		suits.put("2C", 1);
	    suits.put("2D", 2);
	    suits.put("2H", 3);
	    suits.put("2S", 4);
	    suits.put("3C", 1);
	    suits.put("3D", 2);
	    suits.put("3H", 3);
	    suits.put("3S", 4);
	    suits.put("4C", 1);
	    suits.put("4D", 2);
	    suits.put("4H", 3);
	    suits.put("4S", 4);
	    suits.put("5C", 1);
	    suits.put("5D", 2);
	    suits.put("5H", 3);
	    suits.put("5S", 4);
	    suits.put("6C", 1);
	    suits.put("6D", 2);
	    suits.put("6H", 3);
	    suits.put("6S", 4);
	    suits.put("7C", 1);
	    suits.put("7D", 2);
	    suits.put("7H", 3);
	    suits.put("7S", 4);
	    suits.put("8C", 1);
	    suits.put("8D", 2);
	    suits.put("8H", 3);
	    suits.put("8S", 4);
	    suits.put("9C", 1);
	    suits.put("9D", 2);
	    suits.put("9H", 3);
	    suits.put("9S", 4);
	    suits.put("TC", 1);
	    suits.put("TD", 2);
	    suits.put("TH", 3);
	    suits.put("TS", 4);
	    suits.put("JC", 1);
	    suits.put("JD", 2);
	    suits.put("JH", 3);
	    suits.put("JS", 4);
	    suits.put("QC", 1);
	    suits.put("QD", 2);
	    suits.put("QH", 3);
	    suits.put("QS", 4);
	    suits.put("KC", 1);
	    suits.put("KD", 2);
	    suits.put("KH", 3);
	    suits.put("KS", 4);
	    suits.put("AC", 1);
	    suits.put("AD", 2);
	    suits.put("AH", 3);
	    suits.put("AS", 4);
	    
	    for(int i = 0; i < list.size(); i++) {
        	newSuits.add(suits.get(list.get(i)));
        }
	}

	public List<Integer> getNewValuesP1() {
		
		Collections.sort(newValues.subList(0, 5));
		
		for(int i = 0; i < 5; i++) {
			p1Values.add(newValues.get(i));
		}
		for(int i = 0; i < 5; i++) {
			p1CardTotal += p1Values.get(i);
		}
		
		p1HighCard = p1Values.get(4);
		
		return p1Values;
	}
	
	public List<Integer> getNewValuesP2() {
		
		Collections.sort(newValues.subList(5, 10));
		
		for(int i = 5; i < 10; i++) {
			p2Values.add(newValues.get(i));
		}
		for(int i = 0; i < 5; i++) {
			p2CardTotal += p2Values.get(i);
		}
		
		p2HighCard = p2Values.get(4);
		
		return p2Values;
	}

	public List<Integer> getNewSuitsP1() {
		
		Collections.sort(newSuits.subList(0, 5));
		
		for(int i = 0; i < 5; i++) {
			p1Suits.add(newSuits.get(i));
		}
		
		return p1Suits;
	}
	
	public List<Integer> getNewSuitsP2() {
		
		Collections.sort(newSuits.subList(5, 10));
		
		for(int i = 5; i < 10; i++) {
			p2Suits.add(newSuits.get(i));
		}
		
		return p2Suits;
	}

	public int getP1CardTotal() {
		return p1CardTotal;
	}

	public int getP2CardTotal() {
		return p2CardTotal;
	}

	public int getP1HighCard() {
		return p1HighCard;
	}

	public int getP2HighCard() {
		return p2HighCard;
	}
	
}
