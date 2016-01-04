package representation.image;

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
	private int imgBoundx;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 14;
	private int separator = 4;
	private String lang = "EN";
	private int lineNumber = 1;

	
	public ImageDraftman() {
	}
	
	public void switchLang(ArrayList<Pair<String,String>> a){
		switch (lang){
			case "EN" : 
				for(Pair<String, String> p : a){
					g.setColor(switchEN(p.getValue()));
					setDim(p.getKey());
					g.drawRect(x, y, width, height);
					}
				g.dispose();
			break;
			case "FR" :  
				for(Pair<String, String> p : a){
					g.setColor(switchFR(p.getValue()));
					setDim(p.getKey());
					g.drawRect(x, y, width, height);
					}
				g.dispose();
			break;
		}
	}
	
	public Color switchEN(String s){
		Color c = null;
		switch (s){
	  		case "DT" : 
	  			c = new Color(0,153,0);
	  			break;
	  		case "NN" :
	  		case "NNS" :
	  			c = new Color(0,0,153);
	  			break;    
	  		case "NNP" :
	  		case "NNPS" :
	  			c = new Color(0,0,255);
			    break;
	  		case "PR":
	  		case "PRP" :
	  			c = new Color(0,255,0);
			    break;
	  		case "WP" :
	  			c = new Color(255,128,0);
			    break;
	  		case "VB" :
	  		case "VBZ" :
	  		case "VBP" :
	  		case "VBD" :
	  		case "VBN" :
	  		case "VBG" :
	  			c = new Color(204,0,0);
			    break;
	  		case "MD" :
	  			c = new Color(255,255,0);
			    break;
	  		case "JJ" :
		   	case "JJR" :
		   	case "JJS" :
		   		c = new Color(127,0,255);
			    break;
		   	case "RB" :
		   	case "RBR" :
		   	case "RBS" :
		   		c = new Color(255,51,51);
			    break;
		   	case "WRB" :
		   		c = new Color(153,153,0);
			    break;
		   	case "IN" :
		   		c = new Color(204,0,102);
			    break;
		   	case "POS" :
		   		c = new Color(0,204,0);
			    break;
		   	case "TO" :
		   		c = new Color(102,51,0);
			    break;
		   	case "CC" :
		   		c = new Color(51,0,0);
			    break;
		   	case "FN" :
		   		c = new Color(0,0,0);
		   		break;
		}
		return c;
	}
  
	public Color switchFR(String s){
		Color c = null;
		switch (s){
		case "DT" :
			c = new Color(0,153,0);            
            break;
           
        case "NN" :
        case "NNS" :
        	c = new Color(0,0,153);
            break;
           
        case "NNP" :
        case "NNPS" :
        	c = new Color(0,0,255);
            break;
           
        case "PR":
        case "PRP" :
        	c = new Color(0,255,0);
            break;
           
        case "VB" :
        case "VBZ" :
        case "VBP" :
        case "VBD" :
        case "VBN" :
        case "VBG" :
        	c = new Color(204,0,0);
            break;
           
        case "JJ" :
        case "JJR" :
        case "JJS" :
        	c = new Color(127,0,255);
            break;
           
        case "RB" :
        case "RBR" :
        case "RBS" :
        	c = new Color(255,51,51);
            break;
           
        case "IN" :
        	c = new Color(204,0,102);
            break;
           
        case "CC" :
        	c = new Color(51,0,0);
            break;
           
        case "FN" :
        	c = new Color(0,0,0);
            break;        
		}
		return c;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSeparator() {
		return separator;
	}

	public void setSeparator(int separator) {
		this.separator = separator;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}


	public void setDim(String s){
		if(imgBoundx > x + width + separator + 5*s.length()){
			x = x + width + separator; 
		}
		else{
			x = separator;
			y = y + height + separator;
		}
		width = 5*s.length();
	}
	
	public void createWhiteImage(){
		img = new BufferedImage(300, lineNumber*18, BufferedImage.TYPE_INT_RGB);
		g=img.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		imgBoundx = img.getWidth();
	}
  
	/*public void drawSchematics(ArrayList<Pair<String,String>> a) {
		for(Pair<String, String> p : a){
			switchLang(p.getValue());
			setDim(p.getKey());
			g.drawRect(x, y, width, height);
	  		}
		g.dispose();
	  	}*/
	
	public void generateImage() throws IOException{
		File file = new File("img.png");
		ImageIO.write(img, "png", file);
	}
	
	public void doTheThing(ArrayList<Pair<String,String>> a) throws IOException{
		switchLang(a);
		generateImage();
	}
}
