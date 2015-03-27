package answers;

import java.util.List;

public class FindHighest {
	
	private int rank = 0;
	
	public FindHighest() {}
	
	public void handRating(List<Integer> value, List<Integer> suit) {
		
		if( (value.get(4) + value.get(0) == 24)  &&  (suit.get(4) - suit.get(0) == 0) ) 
			rank = 10; //Royal Flush
		else if( (value.get(4) - value.get(0) == 4)  &&  (suit.get(4) - suit.get(0) == 0) ) 
			rank = 9; //Straight Flush
		else if( (value.get(0) == value.get(3))  ||  (value.get(1) == value.get(3)) ) 
			rank = 8; //Four-of-a-kind
		else if( ( (value.get(0) == value.get(2)) && (value.get(3) == value.get(4)) )  ||  ( (value.get(2) == value.get(4)) && (value.get(0) == value.get(1)) ) )
			rank = 7; //Full House
		else if(suit.get(4) - suit.get(0) == 0) 
			rank = 6; //Flush
		else if( ((value.get(4)+value.get(3)+value.get(2)+value.get(1)+value.get(0)) / 5 == value.get(2)) && ((value.get(4) - value.get(0) == 4) )  ||  ( ( (value.get(3) - value.get(0) == 3) && (value.get(4) - value.get(0) == 12) ) ) )
			rank = 5; //Straight
		else if( (value.get(0) == value.get(2))  ||  (value.get(1) == value.get(3))  ||  (value.get(2) == value.get(4)) ) 
			rank = 4; //Three-of-a-kind
		else if( ((value.get(0) == value.get(1)) && (value.get(2) == value.get(3)))  ||  ((value.get(0) == value.get(1)) && (value.get(3) == value.get(4)))  ||  ((value.get(1) == value.get(2)) && (value.get(3) == value.get(4))))
			rank = 3; //Two Pairs
		else if( (value.get(0) == value.get(1))  ||  (value.get(1) == value.get(2))  ||  (value.get(2) == value.get(3))  ||  (value.get(3) == value.get(4)))
			rank = 2; //One Pair
		else
			rank = 1; //High Card
	}
	
	public int countTotal() {
		return rank;
	}

}
