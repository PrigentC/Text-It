package gui;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AppWriteFrame extends JFrame {
	
private JPanel jPanel1;
private JLabel jLabel1;
private JTextArea jArea1;
private JButton jButton1;

	
	public void openFrame() throws IOException{
		//Frame Settings
		setTitle("Write Text");
		setLocationRelativeTo(null);
		setSize(600, 400);
		setVisible(true);
		
		//Create Elements
		jPanel1 = new JPanel();
		jLabel1 = new JLabel("Text :");
		jArea1 = new JTextArea();
		jButton1 = new JButton("Analyse");
		
		
		//Adding Elements
		jPanel1.add(jLabel1);
		jPanel1.add(jArea1);
		jPanel1.add(jButton1);
		
		
		getContentPane().add(jPanel1);

	}
	
	
}
