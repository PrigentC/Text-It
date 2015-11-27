package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class AppFrame extends JFrame{
	
	//Main
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
	    	public void run() {
	    		AppFrame ex = new AppFrame();
	    		ex.setVisible(true);
	    	}
    	});
    }
    
	public AppFrame() {
		initUI();
		
		setTitle("Text It!");
		setSize(1000, 700); //resize the window to be 1000px wide and 700px
		setLocationRelativeTo(null); //center the window on the screen
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public final void initUI() {
		
		JSplitPane jSplitPane1, jSplitPane2;
        JPanel jPanel1, jPanel2Top, jPanel2Bottom;
        
        //Menu Bar
		
		// Creates a menu bar for a JFrame
        JMenuBar menuBar = new JMenuBar();
 
        // Add the menu bar to the frame
        setJMenuBar(menuBar);
        
        // Define and add two drop down menu to the menu bar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Create and add simple menu item to one of the drop down menu
        JMenuItem importAction = new JMenuItem("Import");
        JMenuItem writeAction = new JMenuItem("Write");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem copyAction = new JMenuItem("Copy");

        fileMenu.add(importAction);
        fileMenu.add(writeAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        
        editMenu.add(copyAction);
        
        //Action for import
        importAction.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("You have clicked on the import action");
            }
        });
        
        //Action for write
        writeAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("You have clicked on the write action");
            }
        });
        
        //Action for exit
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("You have clicked on the exit action");
            	System.exit(0);
            }
        });
        
        
        //Panel
        
        //Create panels
        jPanel1 = new JPanel();
        jPanel2Top = new JPanel();
        jPanel2Bottom = new JPanel();
         
        //Splitting panels
        jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
                jPanel2Top, jPanel2Bottom);
        jSplitPane2.setOneTouchExpandable(true);
        jSplitPane2.setDividerLocation(300);
         
        jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
                jPanel1, jSplitPane2);
        jSplitPane1.setOneTouchExpandable(true);
        jSplitPane1.setDividerLocation(500);
         
        getContentPane().add(jSplitPane1);
	}
}
