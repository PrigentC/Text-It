package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
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
public class AppFrame extends JDialog implements ActionListener{
	
	private JMenuItem importAction, writeAction, exitAction, statAction, schematicAction;
	private JTextArea jText, jStat;
	private JLabel jImageLabel;
    
	public void AppFrameInit() {
		initUI();
		
		setTitle("Text It!");
		setSize(1000, 700); //resize the window to be 1000px wide and 700px
		setLocationRelativeTo(null); //center the window on the screen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		

		Font font = new Font("Verdana", Font.BOLD, 12);
		jText.setFont(font);
	}
	
	public void printText(){        
		jText = new JTextArea(37,40);
		jText.setText("");
		jText.setEditable(false);
		jStat = new JTextArea(18, 40);
		jStat.setText("");
		jStat.setEditable(false);
	}

	public final void initUI() {
		
		JSplitPane jSplitPane1, jSplitPane2;
        JPanel jPanel1 = null, jPanel2Top, jPanel2Bottom;
        JLabel jLabel1, jLabel2Top, jLabel2Bottom;
        
        //Menu Bar
		
		// Creates a menu bar for a JFrame
        JMenuBar menuBar = new JMenuBar();
 
        // Add the menu bar to the frame
        setJMenuBar(menuBar);
        
        // Define and add two drop down menu to the menu bar
        JMenu fileMenu = new JMenu("File");
        JMenu downloadMenu = new JMenu("Download");
        menuBar.add(fileMenu);
        menuBar.add(downloadMenu);

        // Create and add simple menu item to one of the drop down menu
        importAction = new JMenuItem("Import");
        writeAction = new JMenuItem("Write");
        exitAction = new JMenuItem("Exit");
        statAction = new JMenuItem("Satistics");
        schematicAction = new JMenuItem("Schematic");

        fileMenu.add(importAction);
        fileMenu.add(writeAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        
        downloadMenu.add(statAction);
        downloadMenu.add(schematicAction);
        
        //Actions for menu items
        importAction.addActionListener(this);
        writeAction.addActionListener(this);      
        exitAction.addActionListener(this); 
        
        statAction.addActionListener(this);
        schematicAction.addActionListener(this);
        
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
        jSplitPane2.setEnabled(false);
         
        jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
                jPanel1, jSplitPane2);
        jSplitPane1.setOneTouchExpandable(false);
        jSplitPane1.setDividerLocation(500);
        jSplitPane1.setEnabled(false);
         
        getContentPane().add(jSplitPane1);
        
        //Label
        
        //Create SplitPane Labels
        jLabel1 = new JLabel("Text");
        jLabel2Top = new JLabel("Schematic");
        jLabel2Bottom = new JLabel("Statistics");
        
        printText();
        
        //Adding Labels
        jPanel1.add(jLabel1);
        jPanel1.add(new JSeparator(SwingConstants.VERTICAL));
        jPanel1.add(jText);
        
        jPanel2Top.add(jLabel2Top);
        jPanel2Top.add(new JSeparator(SwingConstants.VERTICAL));
        
        jImageLabel = new JLabel();
        jPanel2Top.add(jImageLabel);

        jPanel2Bottom.add(jLabel2Bottom);
        jPanel2Bottom.add(new JSeparator(SwingConstants.VERTICAL));
        jPanel2Bottom.add(jStat);
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
        		revalidate();
        		repaint();
        		
        		jImageLabel.setIcon(new ImageIcon(importFrame.getBuffImg()));
        		revalidate();
        		repaint();
        		
        		jStat.setText(importFrame.getStat());
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
        		//jText.update(jText.getGraphics());
        		revalidate();
        		repaint();

        		jImageLabel.setIcon(new ImageIcon(writeFrame.getBuffImg()));
        		revalidate();
        		repaint();
        		
        		jStat.setText(writeFrame.getStat());
        		revalidate();
        		repaint();
            } catch (IOException ex) {                    
                ex.printStackTrace();
            }
        }else if(source==exitAction){
        	
        	 System.out.println("You have clicked on the exit action");
             System.exit(0);
             
        }else if(source==schematicAction){
        	
        	final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Unimplemented function!", "Download Schematic", JOptionPane.INFORMATION_MESSAGE);
         
        }else if(source==statAction){
        	
        	final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Unimplemented function!", "Download Statistics", JOptionPane.INFORMATION_MESSAGE);
      
        }
    }
}
