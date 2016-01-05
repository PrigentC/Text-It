package analyzer.lexical;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.RAMDirectory;

public class TISpellChecker {
	private TIDictionary dict;
	private SpellChecker sc;
	private IndexWriterConfig config;
	private StandardAnalyzer analyzer;
	private String[] svgdText;
	private String context;
	private int index;
	
	
	public TISpellChecker(String text) throws IOException {
		RAMDirectory spellCheckerDir = new RAMDirectory();
		this.dict = new TIDictionary("DIC_EN.txt");
		this.sc = new SpellChecker(spellCheckerDir);
		this.analyzer = new StandardAnalyzer();
		this.config = new IndexWriterConfig(analyzer);
		this.svgdText = text.split(" ");
	}
	
	public String getContext() {
		return context;
	}
	
	public void addDictionnary(TIDictionary d) throws IOException {
		sc.indexDictionary(d.TIDictionnaryToPlainText(), config, true);
	}
	
	public boolean isWordCorrect(String word) throws IOException {
		return sc.exist(word);
	}
	
	public boolean isTextCorrect() throws IOException {
		for(int i = 0 ; i < svgdText.length ;) {
			if(isWordCorrect(svgdText[i])){
				return false;
			}
		}
		return true;
	}
	
	public String[] suggestSimilar(String word, int NSugg) throws IOException {
		return sc.suggestSimilar(word, NSugg);
	}
	
	public String[] check() throws IOException {
		for(int i = 0 ; i < svgdText.length ; i++) {
			System.out.println(svgdText.length);
			if (!isWordCorrect(svgdText[i])) {
				
				
				if(svgdText.length <= 4) {
					context = returnCompleteText();
				} else if(i > svgdText.length-1) {
					context = svgdText[i-2] + svgdText[i-1] + svgdText[i];
				} else {
					context = svgdText[i-2] + svgdText[i-1] + svgdText[i] + svgdText[i+1] + svgdText[i+2];
				}
				
				index = i;
				
				ArrayList<String> result = new ArrayList<String>();
				
				result.add(" ");
				String[] sugg = suggestSimilar(svgdText[i], 5);
				for(int j = 0 ; j < sugg.length ; j++) {
					result.add(sugg[j]);
				}
				
				return (String[]) result.toArray(new String[0]);
			}
		}
		return null;
	}
	
	public void correct(String word) {
		svgdText[index] = word;
	}
	
	public String returnCompleteText() {
		String text = null;
		
		for(int i = 0 ; i < svgdText.length ; i++) {
			text += svgdText[i];
		}
		
		return text;
	}

}
