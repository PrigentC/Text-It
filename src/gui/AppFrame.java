package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")	
public class AppFrame extends JFrame implements ActionListener{
	
	private JMenuItem importAction, writeAction, exitAction, copyAction;
	private JTextArea jText;
	
	private String fullText;

    
	public void AppFrameInit() {
		initUI();
		
		setTitle("Text It!");
		setSize(1000, 700); //resize the window to be 1000px wide and 700px
		setLocationRelativeTo(null); //center the window on the screen
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		Font font = new Font("Verdana", Font.BOLD, 12);
		jText.setFont(font);
	}
	
	public void printText(String text){        
		jText = new JTextArea(38,40);
		jText.setText(text);
		jText.setEnabled(false);
	}

	public final void initUI() {
		
		JSplitPane jSplitPane1, jSplitPane2;
        JPanel jPanel1 = null, jPanel2Top, jPanel2Bottom;
        JLabel jLabel1, jLabel2Top, jLabel2Bottom;
        
        //ImageDraftman img = new ImageDraftman();
        //img.createWhiteImage();
        
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
        importAction = new JMenuItem("Import");
        writeAction = new JMenuItem("Write");
        exitAction = new JMenuItem("Exit");
        copyAction = new JMenuItem("Copy");

        fileMenu.add(importAction);
        fileMenu.add(writeAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        
        editMenu.add(copyAction);
        
        //Actions for menu items
        importAction.addActionListener(this);
        writeAction.addActionListener(this);      
        exitAction.addActionListener(this);        
        
        //Panel
        
        //Create panels
        jPanel1 = new JPanel();
        jPanel2Top = new JPanel();
        jPanel2Bottom = new JPanel();
         
        //Splitting panels
        jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
                jPanel2Top, jPanel2Bottom);
        jSplitPane2.setOneTouchExpandable(false);
        jSplitPane2.setDividerLocation(300);
        //jSplitPane2.setResizeWeight(0.5);
         
        jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
                jPanel1, jSplitPane2);
        jSplitPane1.setOneTouchExpandable(false);
        jSplitPane1.setDividerLocation(500);
        //jSplitPane1.setResizeWeight(0.5);
         
        getContentPane().add(jSplitPane1);
        
        //Label
        
        //Create SplitPane Labels
        jLabel1 = new JLabel("Text");
        jLabel2Top = new JLabel("Schematic");
        jLabel2Bottom = new JLabel("Statistics");
        
        printText("");
        
        //Adding Labels
        jPanel1.add(jLabel1);
        jPanel1.add(new JSeparator(SwingConstants.VERTICAL));
        jPanel1.add(jText);
        jPanel2Top.add(jLabel2Top);
        jPanel2Top.add(new JSeparator(SwingConstants.VERTICAL));
        //jPanel2Top.add(img);
        jPanel2Bottom.add(jLabel2Bottom);
	}

	public void actionPerformed(ActionEvent evt) 	
    {
    	Object source = evt.getSource();
		if(source==importAction){
        	System.out.println("You have clicked on the import action");
			
            AppImportFrame importFrame = new AppImportFrame();
            try {
            	importFrame.openFrame();
            	
        		jText.setText(importFrame.getFullText());
        		jText.update(jText.getGraphics());
        		revalidate();
        		repaint();
            } catch (IOException ex) {                    
            	final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Choose a File!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(source==writeAction){
        	System.out.println("You have clicked on the write action");
        	
        	AppWriteFrame writeFrame = new AppWriteFrame();
            try {
            	writeFrame.openFrame();

            	jText.setText(writeFrame.getFullText());
        		jText.update(jText.getGraphics());
        		revalidate();
        		repaint();
            } catch (IOException ex) {                    
                ex.printStackTrace();
            }
        }else if(source==exitAction){
        	 System.out.println("You have clicked on the exit action");
             System.exit(0);
        }
    }

	public String getFullText() {
		SpellCheckFrame spellcheck = new SpellCheckFrame();
		fullText = spellcheck.getFullText();
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
}
