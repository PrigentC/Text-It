package analyzer;

import java.io.IOException;

import analyzer.lexical.TIDictionary;
import analyzer.lexical.TISpellChecker;
import analyzer.syntaxical.TISyntaxAnalyzer;

public class Test {
	
	public void spellCheckTest() {
		try {
			TIDictionary tid = new TIDictionary("DIC_EN.txt");
			TISpellChecker tisc = new TISpellChecker();
			tisc.addDictionnary(tid);
			
			String testWord = "raisponse";
			
			if(!tisc.isWordCorrect(testWord)) {
				System.out.println("This word doesn't exist in our dictionary !");
				System.out.println("Here are some words suggestions : ");
				
				String[] suggestions = tisc.suggestSimilar(testWord, 5);
				for(int i = 0; i < suggestions.length; i++) {
					System.out.println(suggestions[i]);
				}
			} else {
				System.out.println("This word exists in our dictionary !");
			}
			
			System.out.println("Bye !");
			
			
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		//Test test = new Test();
		
		//test.spellCheckTest();
		
		TISyntaxAnalyzer syntax = new TISyntaxAnalyzer("cathie.prigent@uha.fr", "ahg5Awodu8ga");
		
		System.out.println(syntax.launchAnalysis("I like trains"));
	}
	
}
