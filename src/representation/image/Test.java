package representation.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javafx.util.Pair;
import representation.image.ImageDraftman;

public class Test {
	public static void main(String args[]) {
		BufferedImage img = new BufferedImage(300, 500, BufferedImage.TYPE_INT_RGB);
		ImageDraftman imgDraftman = new ImageDraftman(img, 14, 4, "ENG");
		ArrayList<Pair<String,String>> a = new ArrayList<Pair<String,String>>();
		a.add(new Pair<String, String>("plop", "DT"));
		a.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "RBR"));
		a.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "RBR"));
		imgDraftman.drawSchematics	(a);
		try {
			imgDraftman.generateImage("test", "png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
