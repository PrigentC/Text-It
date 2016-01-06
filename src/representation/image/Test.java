package representation.image;

import java.io.IOException;
import java.util.ArrayList;

import javafx.util.Pair;
import representation.image.ImageDraftman;

public class Test {
	public static void main(String args[]) {
		ImageDraftman imgDraftman = new ImageDraftman();
		imgDraftman.createWhiteImage(1);
		ArrayList<Pair<String,String>> a = new ArrayList<Pair<String,String>>();
		a.add(new Pair<String, String>("plop", "DT"));
		a.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "MD"));
		a.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "WRB"));
		try {
			imgDraftman.draw(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
