package analyzer.lexical;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TIScanner {
	private Scanner s;
	
	public TIScanner(File f) throws FileNotFoundException {
		s = new Scanner(f);
	}
	
	public String nextWord() {
		return s.next();
	}
}
