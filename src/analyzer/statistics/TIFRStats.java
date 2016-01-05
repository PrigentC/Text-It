package analyzer.statistics;

import java.util.ArrayList;

import javafx.util.Pair;

public class TIFRStats extends TIStats {
	String[] FRWordClass = { "det", "noun", "p_noun", "pronoun", "verb", "adj", "adv", "prep", "conj_coord", "foreign", "total" };
	
	public TIFRStats() {
		for (String s : FRWordClass) {
			number.put(s, 0);
			percent.put(s, 0.0);
		}
	}

	@Override
	public void numberWordPerClass(ArrayList<Pair<String, String>> result) {
		for(Pair<String, String> p : result) {
			switch(p.getValue()) {
			case "DT" :
				updateMap("det");			
				break;
				
			case "NN" :
			case "NNS" :
				updateMap("noun");
				break;
				
			case "NNP" :
			case "NNPS" :
				updateMap("p_noun");
				break;
				
			case "PR":
			case "PRP" :
				updateMap("pronoun");
				break;
				
			case "VB" :
			case "VBZ" :
			case "VBP" :
			case "VBD" :
			case "VBN" :
			case "VBG" :
				updateMap("verb");
				break;
				
			case "JJ" :
			case "JJR" :
			case "JJS" :
				updateMap("adj");
				break;
				
			case "RB" :
			case "RBR" :
			case "RBS" :
				updateMap("adv");
				break;
				
			case "IN" :
				updateMap("prep");
				break;
				
			case "CC" :
				updateMap("conf_coord");
				break;
				
			case "FN" :
				updateMap("foreign");
				break;				
			}
		}
	}

	@Override
	public void percentWordPerClass() {
		for(String s : FRWordClass) {
			percent.put(s, Double.valueOf(number.get(s)/number.get("total")));
		}
	}
	
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		
		for (String s : FRWordClass) {
			tmp.append(s);
			tmp.append(" (");
			tmp.append(number.get(s).toString());
			tmp.append(") ");
		}
		
		return tmp.toString();
	}

}
