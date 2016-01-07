package representation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.util.Pair;

public class ImageDraftman {
	private Graphics2D g;
	BufferedImage img;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private String lang = "EN";

	
	public ImageDraftman() {
	}
	
	public void drawGraphics(ArrayList<Pair<String,String>> a){
		switch (lang){
			case "EN" : 
				EnglishProperties enProp = new EnglishProperties(g);
				for(Pair<String, String> p : a){
					g.setColor(enProp.colorChooser(p.getValue()));
					setDim(p.getKey());
					g.drawRect(x, y, width, 14);
					}
				g.dispose();
				enProp.drawLegend();
			break;
			case "FR" :  
				FrenchProperties frProp = new FrenchProperties(g);
				for(Pair<String, String> p : a){
					g.setColor(frProp.colorChooser(p.getValue()));
					setDim(p.getKey());
					g.drawRect(x, y, width, 14);
					}
				g.dispose();
				frProp.drawLegend();
			break;
		}
	}

	public Graphics2D getG() {
		return g;
	}

	public void setG(Graphics2D g) {
		this.g = g;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public void setDim(String s){
		if(img.getWidth() > x + width + 4 + 5*s.length()){
			x = x + width + 4; 
		}
		else{
			x = 4;
			y = y + 14 + 4;
		}
		width = 5*s.length();
	}
	
	public void createWhiteImage(int i){
		img = new BufferedImage(300, i*18, BufferedImage.TYPE_INT_RGB);
		g=img.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
	}
	
	public void generateImage() throws IOException{
		File file = new File("img.png");
		ImageIO.write(img, "png", file);
	}
	
	public void draw(ArrayList<Pair<String,String>> a) throws IOException{
		drawGraphics(a);
		generateImage();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
