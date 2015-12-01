package analyzer;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.RAMDirectory;

public class TISpellChecker {
	private SpellChecker sc;
	private IndexWriterConfig config;
	private StandardAnalyzer analyzer;
	
	
	public TISpellChecker() throws IOException {
		RAMDirectory spellCheckerDir = new RAMDirectory();
		this.sc = new SpellChecker(spellCheckerDir);
		this.analyzer = new StandardAnalyzer();
		this.config = new IndexWriterConfig(analyzer);
	}
	
	public void addDictionnary(TIDictionary d) throws IOException {
		sc.indexDictionary(d.TIDictionnaryToPlainText(), config, true);
	}
	
	public String[] suggestSimilar(String word, int NSugg) throws IOException {
		return sc.suggestSimilar(word, NSugg);
	}

}
