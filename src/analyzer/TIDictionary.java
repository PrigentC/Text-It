package analyzer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.lucene.search.spell.Dictionary;
import org.apache.lucene.search.spell.PlainTextDictionary;

public class TIDictionary {
	private File data;
	
	public TIDictionary(File d) throws FileNotFoundException {
		this.data = d;
	}
	
	public TIDictionary(String path) throws FileNotFoundException {
		this.data = new File(path);
	}

	public PlainTextDictionary TIDictionnaryToPlainText() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(data);
		return new PlainTextDictionary(fis);
	}
	
}
