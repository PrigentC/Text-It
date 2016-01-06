package representation.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class EnglishProperties extends LangageProperties {
	

	public EnglishProperties(Graphics2D g) {
		super();
		this.g = g;
	}

	public Graphics2D getG() {
		return g;
	}

	public void setG(Graphics2D g) {
		this.g = g;
	}
	
	public enum Gram{
		DT,
		NN,NNS,
		NNP,NNPS,
		PR,PRP,
		WP,
		VB,VBZ,VBP,VBD,VBN,VBG,
		MD,
		JJ,JJR,JJS,
		RB,RBR,RBS,
		WRB,
   		IN,
   		POS,
   		TO,
   		CC,
   		FN;
	}

	public Color colorChooser(String s) {
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
	  			c = new Color(0,204,102);
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

	public int gramarLength() {
		int r = 0;
		for(Gram gram : Gram.values()){
			r++;
		}
		return r;
	}
	
	public void drawLegend(){
		BufferedImage legendImg = new BufferedImage(80, 20*gramarLength()+1, BufferedImage.TYPE_INT_RGB);
		Graphics2D legendGraphic = legendImg.createGraphics();
		legendGraphic.setColor(Color.white);
		legendGraphic.fillRect(0, 0, legendImg.getWidth(), legendImg.getHeight());
		int x=0;
		int y=10;
		for(Gram gram : Gram.values()){
			legendGraphic.setColor(colorChooser(gram.name()));
			legendGraphic.drawLine(x, y, x+20, y);
			legendGraphic.drawString(gram.name(), x+24, y);
			y=y+20;
			}
		legendGraphic.dispose();
		File file = new File("LegendEnglish.png");
		try {
			ImageIO.write(legendImg, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
