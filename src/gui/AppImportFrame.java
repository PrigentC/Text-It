package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import extract.ExtractText;


@SuppressWarnings("serial")
public class AppImportFrame extends JDialog implements ActionListener{
	private JTextField jField;
	private JFileChooser fileChooser;
	private int mode;
	private String fullText;
	private BufferedImage buffImg;
	private String stat;
	
	public static final int MODE_OPEN = 1;
	public static final int MODE_SAVE = 2;
	
	private JButton jButton1;
	private JButton jButton2;
	

	public void openFrame() throws IOException{
		
		JPanel jPanel;
		JLabel jLabel;
		
		//Frame Settings
		setTitle("Import Text");
		setSize(520, 120);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Create Elements        
		jPanel = new JPanel(new FlowLayout());
		jLabel = new JLabel("File : ");
		jField = new JTextField(30);
		jButton1 = new JButton("Browse...");

		jButton2 = new JButton("Analyze");
		
		//Adding Elements
		jPanel.add(jLabel);
		jPanel.add(jField);
		jPanel.add(jButton1);

		jPanel.add(jButton2);
		
        jButton1.addActionListener(this);      
        jButton2.addActionListener(this);
        
		Container contentPane = getContentPane();
		contentPane.add(jPanel);

        setModal(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt) 	
    {
    	Object source = evt.getSource();
            
		if(source==jButton1){
			System.out.println("You have clicked on the browse action");
			
        	mode = MODE_OPEN;
            try {
            	
				button1ActionPerformed(evt);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
        }else if(source==jButton2){
        	System.out.println("You have clicked on the analyze action");
        	
        	if((jField.getText() == null) || (jField.getText().trim().equals(""))){
        		
        		final JPanel panel = new JPanel();
        		JOptionPane.showMessageDialog(panel, "Choose a File!", "Error", JOptionPane.ERROR_MESSAGE);
        		
        	}else{
        		ExtractText exText = new ExtractText();
	            exText.ExtractAllText(fileChooser.getSelectedFile().toString().substring(fileChooser.getSelectedFile().toString().lastIndexOf('.'), fileChooser.getSelectedFile().toString().length()), fileChooser.getSelectedFile().toString());
	            
	            SpellCheckFrame spellFrame = new SpellCheckFrame();
				spellFrame.setFullText(exText.getSt());
				this.setVisible(false);
				spellFrame.spellCheckFrameExecute();
	            
	            if(exText.getEnab() == true){
	    			this.setVisible(false);
	            }else{
	            	this.setVisible(true);
	            }
	            
	            setFullText(spellFrame.getFullText());
	            setBuffImg(spellFrame.getBuffImage());
	            setStat(spellFrame.getStats());
        	}
        }
    }
	
	public void button1ActionPerformed(ActionEvent evt) throws FileNotFoundException, IOException {
	    fileChooser = new JFileChooser();

		addFileTypeFilter(".txt", "Text File");
		addFileTypeFilter(".doc", "Document File");
		addFileTypeFilter(".docx", "XML Format Document File");
		addFileTypeFilter(".pdf", "Portable Document Format"); 
		
		if (mode == MODE_OPEN) {
	        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	            jField.setText(fileChooser.getSelectedFile().getAbsolutePath());
	        }
	     }	    
	     else if (mode == MODE_SAVE) {
	           if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
	               jField.setText(fileChooser.getSelectedFile().getAbsolutePath());
	           }
	    }
	 }
	
	 public void addFileTypeFilter(String extension, String description) {
	     FileFilter filter = new FileTypeFilter(extension, description);
	     fileChooser.addChoosableFileFilter(filter);
	     fileChooser.setFileFilter(filter);
	 }

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public BufferedImage getBuffImg() {
		return buffImg;
	}

	public void setBuffImg(BufferedImage buffImg) {
		this.buffImg = buffImg;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

}
