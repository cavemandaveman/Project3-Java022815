package answers;

import java.util.ArrayList;
import java.util.List;

public class RawCardList {
	
	private List<String> cardList = new ArrayList<>();
	
	public RawCardList() {}
	
	public void setCardList(List<String> cardList) {
		this.cardList = cardList;
	}
	
	public List<String> getCardList() {
		return cardList;
	}
	
	public String getP1Cards() {
		return cardList.subList(0,5).toString();
	}

}
