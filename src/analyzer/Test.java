package analyzer;

import java.io.IOException;
import java.util.HashMap;

import analyzer.lexical.TIDictionary;
import analyzer.lexical.TISpellChecker;
import analyzer.statistics.TIENStats;
import analyzer.syntaxical.TISyntaxAnalyzer;

public class Test {
	
	public void spellCheckTest() {
		try {
			TIDictionary tid = new TIDictionary("DIC_EN.txt");
			TISpellChecker tisc = new TISpellChecker("elephant utd an example");
			tisc.addDictionnary(tid);
			
			while(!tisc.isTextCorrect()) {
				Object[] suggestions = tisc.check();
				tisc.correct("has");
				tisc.correct("year");
				
				System.out.println(suggestions);
			}
			
			/*if(!tisc.isWordCorrect("elephant utd an example")) {
				System.out.println("This word doesn't exist in our dictionary !");
				System.out.println("Here are some words suggestions : ");
				
				String[] suggestions = tisc.suggestSimilar("elephant utd an example", 5);
				for(int i = 0; i < suggestions.length; i++) {
					System.out.println(suggestions[i]);
				}
			} else {
				System.out.println("This word exists in our dictionary !");
			}*/
			
			System.out.println("Bye !");
			
			
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	public void syntaxTest() {
		TISyntaxAnalyzer syntax = new TISyntaxAnalyzer("cathie.prigent@uha.fr", "ahg5Awodu8ga");
		
		syntax.launchAnalysis("I would be interesed applying for a job");
		System.out.println(syntax.getResult());
		
		TIENStats tis = new TIENStats();
		
		tis.numberWordPerClass(syntax.getResult());
		tis.percentWordPerClass();
		
		System.out.println(tis.toString());
		
		/*HashMap<String, Integer> test = tis.getNumber();
		HashMap<String, Double> test2 = tis.getPercent();

		
		for(String s : tis.ENWordClass) {
			System.out.println(s + " " + test.get(s));
			System.out.println(s + " " + test2.get(s));
		}*/
		
		System.out.println("Bye !");
	}
	
	
	
	public static void main(String args[]) {
		Test test = new Test();
		
		//test.spellCheckTest();
		
		test.syntaxTest();
				
		
	}
	
}
