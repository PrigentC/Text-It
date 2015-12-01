package analyzer;

import java.io.IOException;

public class Test {
	
	public static void main(String args[]) {
		try {
			TIDictionary tid = new TIDictionary("dictionary.txt");
			TISpellChecker tisc = new TISpellChecker();
			tisc.addDictionnary(tid);
			
			String[] suggestions = tisc.suggestSimilar("misspelt", 5);
			for(int i = 0; i < suggestions.length; i++) {
				System.out.println(suggestions[i]);
			}
			
			System.out.println("Bye !");
			
			
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
}
