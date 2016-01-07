package representation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import javafx.util.Pair;
import representation.ImageDraftman;

public class Test {
	public static void main(String args[]) {
		ImageDraftman imgDraftman = new ImageDraftman();
		imgDraftman.createWhiteImage(1);
		ImageDraftman imgDraftman2 = new ImageDraftman();
		imgDraftman2.createWhiteImage(3);
		ArrayList<Pair<String,String>> a = new ArrayList<Pair<String,String>>();
		a.add(new Pair<String, String>("plop", "DT"));
		a.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "MD"));
		a.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "WRB"));
		ArrayList<Pair<String,String>> b = new ArrayList<Pair<String,String>>();
		b.add(new Pair<String, String>("plop", "DT"));
		b.add(new Pair<String, String>("plopuzeifpzegzemoihgioezio", "MD"));
		try {
			imgDraftman.draw(a);
			//imgDraftman2.draw(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgDraftman2.getG().setColor(Color.BLACK);
		
		imgDraftman2.getG().dispose();
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JSeparator sep = new JSeparator();
		JLabel lab = new JLabel();
		JButton button = new JButton("bwaaaaaaah");
		f.setPreferredSize(new Dimension(500, 500));
		f.setLocation(100,100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setLocationRelativeTo(null);
	    f.add(p);
	    lab.setIcon(new ImageIcon(imgDraftman2.getImg()));
	    p.add(lab);
	    p.add(sep);
	    p.add(button);
	    
		f.setVisible(true);
		f.pack();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lab.setIcon(new ImageIcon(imgDraftman2.getImg()));
			    f.pack();
				f.repaint();
			}
        }); 
	}
}
