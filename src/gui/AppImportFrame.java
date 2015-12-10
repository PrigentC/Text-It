package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;


@SuppressWarnings("serial")
public class AppImportFrame extends JFrame{
	
	private JPanel jPanel;
	private JLabel jLabel;
	private JTextField jField;
	private JButton jButton1;
	private JButton jButton2;
	
	private JFileChooser fileChooser;
	private int mode;
	
	public static final int MODE_OPEN = 1;
	public static final int MODE_SAVE = 2;

	public void openFrame() throws IOException{
		//Frame Settings
		setTitle("Import Text");
		setSize(520, 120);
		setLocationRelativeTo(null);
		setVisible(true);
		
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
		
		Container contentPane = getContentPane();
		contentPane.add(jPanel);
		
		jButton1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) {
            	mode = MODE_OPEN;
                try {
					button1ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
	}
	
	public void button1ActionPerformed(ActionEvent evt) throws FileNotFoundException, IOException {
	    fileChooser = new JFileChooser();

		addFileTypeFilter(".txt", "Text File");
		addFileTypeFilter(".doc", "Document File");
		addFileTypeFilter(".docx", "XML Format Document File");
		addFileTypeFilter(".odt", "Word Processing Document");
		addFileTypeFilter(".pdf", "Portable Document Format"); 
		
		if (mode == MODE_OPEN) {
	        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	            jField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.printf("%s", fileChooser.getSelectedFile().toString());
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

	 public void setMode(int mode) {
	     this.mode = mode;
     } 

}
