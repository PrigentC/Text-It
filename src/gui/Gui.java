package gui;

import java.awt.EventQueue;

public class Gui {

    public static void main(String[] args) {
    	
    	EventQueue.invokeLater(new Runnable() {
	    	public void run() {
	    		
	    		AppFrame ex = new AppFrame();
	    		ex.AppFrameInit();
	    		ex.setVisible(true);
	    		
	    	}
    	});
    }
}
