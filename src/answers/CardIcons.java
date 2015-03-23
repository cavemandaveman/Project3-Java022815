package answers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardIcons {
	
	public String icons(List<String> cards) {
		
		Map<String, String> icons = new HashMap<>();
		
		icons.put("AS", "\uD83C\uDCA1");
		icons.put("2S", "\uD83C\uDCA2");
		icons.put("3S", "\uD83C\uDCA3");
		icons.put("4S", "\uD83C\uDCA4");
		icons.put("5S", "\uD83C\uDCA5");
		icons.put("6S", "\uD83C\uDCA6");
		icons.put("7S", "\uD83C\uDCA7");
		icons.put("8S", "\uD83C\uDCA8");
		icons.put("9S", "\uD83C\uDCA9");
		icons.put("TS", "\uD83C\uDCAA");
		icons.put("JS", "\uD83C\uDCAB");
		icons.put("QS", "\uD83C\uDCAD");
		icons.put("KS", "\uD83C\uDCAE");
		icons.put("AH", "\uD83C\uDCB1");
		icons.put("2H", "\uD83C\uDCB2");
		icons.put("3H", "\uD83C\uDCB3");
		icons.put("4H", "\uD83C\uDCB4");
		icons.put("5H", "\uD83C\uDCB5");
		icons.put("6H", "\uD83C\uDCB6");
		icons.put("7H", "\uD83C\uDCB7");
		icons.put("8H", "\uD83C\uDCB8");
		icons.put("9H", "\uD83C\uDCB9");
		icons.put("TH", "\uD83C\uDCBA");
		icons.put("JH", "\uD83C\uDCBB");
		icons.put("QH", "\uD83C\uDCBD");
		icons.put("KH", "\uD83C\uDCBE");
		icons.put("AD", "\uD83C\uDCC1");
		icons.put("2D", "\uD83C\uDCC2");
		icons.put("3D", "\uD83C\uDCC3");
		icons.put("4D", "\uD83C\uDCC4");
		icons.put("5D", "\uD83C\uDCC5");
		icons.put("6D", "\uD83C\uDCC6");
		icons.put("7D", "\uD83C\uDCC7");
		icons.put("8D", "\uD83C\uDCC8");
		icons.put("9D", "\uD83C\uDCC9");
		icons.put("TD", "\uD83C\uDCCA");
		icons.put("JD", "\uD83C\uDCCB");
		icons.put("QD", "\uD83C\uDCCD");
		icons.put("KD", "\uD83C\uDCCE");
		icons.put("AC", "\uD83C\uDCD1");
		icons.put("2C", "\uD83C\uDCD2");
		icons.put("3C", "\uD83C\uDCD3");
		icons.put("4C", "\uD83C\uDCD4");
		icons.put("5C", "\uD83C\uDCD5");
		icons.put("6C", "\uD83C\uDCD6");
		icons.put("7C", "\uD83C\uDCD7");
		icons.put("8C", "\uD83C\uDCD8");
		icons.put("9C", "\uD83C\uDCD9");
		icons.put("TC", "\uD83C\uDCDA");
		icons.put("JC", "\uD83C\uDCDB");
		icons.put("QC", "\uD83C\uDCDD");
		icons.put("KC", "\uD83C\uDCDE");
		
		String cardIcons = "";
		for(int i = 0; i < cards.size(); i++) {
			cardIcons += (icons.get(cards.get(i)) + " ");
		}
		
		return cardIcons;
	}

}
