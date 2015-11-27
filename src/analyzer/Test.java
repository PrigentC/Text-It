package analyzer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.RAMDirectory;

public class Test {
	
	public static void main(String args[]) {
		RAMDirectory spellCheckerDir = new RAMDirectory();		
		SpellChecker spellchecker = null;
		try {
			spellchecker = new SpellChecker(spellCheckerDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        
        File dictionary = new File("dictionary.txt");
        FileInputStream fis = null;
		try {
			fis = new FileInputStream(dictionary);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		  // To index a file containing words:
		  try {
			spellchecker.indexDictionary(new PlainTextDictionary(fis), config,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			String[] suggestions = spellchecker.suggestSimilar("misspelt", 5);
			for(int i = 0; i < suggestions.length; i++)
				System.out.println(suggestions[i]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
