package analyzer.statistics;

import java.util.ArrayList;
import javafx.util.Pair;

public class TIENStats extends TIStats {
	String[] ENWordClass = { "det", "noun", "p_noun", "pronoun", "wh_pronoun", "verb", "mod", "adj", "adv", "wh_adv", "prep", "poss_mark", "inf_mark", "conj_coord", "foreign", "total" };
	
	public TIENStats() {
		for (String s : ENWordClass) {
			number.put(s, 0);
			percent.put(s, 0.0);
		}
	}
	
	/* determinant : DT
  * noun : NN, NNS
  * proper_noun : NNP, NNPS (?)
  * pronoun : PR, PRP
  * wh_pronoun : WP
  * verb : VB, VBZ, VBP, VBD, VBN, VBG
  * modal : MD
  * adjective : JJ, JJR, JJS
  * adverb : RB, RBR, RBS (?)
  * wh_adverb : WRB
  * preposition : IN
  * possessive_mark : POS
  * infinitve_mark : TO
  * coordination_conjunction : CC
  * foreign word : FN */
	
	public void numberWordPerClass(ArrayList<Pair<String,String>> result) {
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
				
			case "WP" :
				updateMap("wh_pronoun");
				break;
				
			case "VB" :
			case "VBZ" :
			case "VBP" :
			case "VBD" :
			case "VBN" :
			case "VBG" :
				updateMap("verb");
				break;
				
			case "MD" :
				updateMap("mod");
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
				
			case "WRB" :
				updateMap("wh_adv");
				break;
				
			case "IN" :
				updateMap("prep");
				break;
				
			case "POS" :
				updateMap("poss_mark");
				break;
				
			case "TO" :
				updateMap("inf_mark");
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
	
	public void percentWordPerClass() {
		for(String s : ENWordClass) {
			percent.put(s, Double.valueOf(number.get(s)/number.get("total")));
		}
	}
}
