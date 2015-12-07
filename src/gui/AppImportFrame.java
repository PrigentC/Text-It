package gui;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AppImportFrame extends JFrame{
	
	private JPanel jPanel;
	private JLabel jLabel;
	private JTextField jField;
	private JButton jButton;

	public void openFrame() throws IOException{
		//Frame Settings
		setTitle("Import Text");
		setSize(520, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Create Elements
		jPanel = new JPanel();
		jLabel = new JLabel("File : ");
		jField = new JTextField(30);
		jButton = new JButton("Browse...");
		
		//Adding Elements
		jPanel.add(jLabel);
		jPanel.add(jField);
		jPanel.add(jButton);
		
		getContentPane().add(jPanel);
	}
	
	public void chooseFile (){
		JFileChooser filech = new JFileChooser();
		filech.showOpenDialog(this);
	}

}
