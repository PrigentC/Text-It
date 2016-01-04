package representation.image;

import java.io.IOException;
import java.util.ArrayList;

import javafx.util.Pair;
import representation.image.ImageDraftman;

public class Test {
	public static void main(String args[]) {
		ImageDraftman imgDraftman = new ImageDraftman();
		imgDraftman.createWhiteImage();
		ArrayList<Pair<String,String>> a = new ArrayList<Pair<String,String>>();
		a.add(new Pair<String, String>("plop", "DT"));
		a.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "RBR"));
		a.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "RBR"));
		try {
			imgDraftman.doTheThing(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
