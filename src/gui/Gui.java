package gui;

import java.awt.EventQueue;

public class Gui {

    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
	    	public void run() {
	    		AppFrame ex = new AppFrame();
	    		ex.setVisible(true);
	    		/*
	    		SpellCheckFrame sp = new SpellCheckFrame();
	    		Object[] elements = new Object[]{"", "a", "an"};
	    		try {
					sp.openFrame("This is a test ex", elements);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	    	}
    	});
}
}
