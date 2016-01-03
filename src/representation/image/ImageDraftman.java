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
	private int height = 0;
	private int separator = 0;
	private String lang;

	
	public ImageDraftman() {
	}

	public ImageDraftman(BufferedImage img, int height,int separator, String lang) {
		super();
		this.img = img;
		this.imgBoundx = img.getWidth();
		this.height = height;
		this.separator = separator;
		this.lang = lang;
	}
	
	public void switchLang(String type){
		switch (lang){
			case "EN" : 
				g.setColor(switchEN(type));
			break;
			case "FR" : 
				g.setColor(switchFR(type));;
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
  
	public void drawSchematics(ArrayList<Pair<String,String>> a) {
		g=img.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		for(Pair<String, String> p : a){
			switchLang(p.getValue());
			setDim(p.getKey());
			g.drawRect(x, y, width, height);
	  		}
	  	}
	
	public void generateImage(String name, String extension) throws IOException{
		g.dispose();
		File file = new File(name+"."+	extension);
		ImageIO.write(img, extension, file);
	}
}
