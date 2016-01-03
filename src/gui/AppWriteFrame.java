package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AppWriteFrame extends JFrame implements ActionListener {
	private JTextArea sourcePane = null;

	private JButton jButton = null;
	
	public String completeText;
	
	public void openFrame() throws IOException{

		//Frame Settings
		setTitle("Write Text");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
				
		Container contentPane = getContentPane();
	       
        sourcePane = new JTextArea(20,50);
        sourcePane.setLineWrap(true);
        sourcePane.setWrapStyleWord(true);
        JScrollPane sourceScrollPane = new JScrollPane(sourcePane);

        contentPane.add(sourceScrollPane,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        jButton = new JButton("Analyze");
        jButton.addActionListener(this);
        buttonPanel.add(jButton);

        // Add the button panel at the bottom of the JFrame
        contentPane.add(buttonPanel,BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == jButton) {
            System.out.println("You have clicked on the analyze action");
            if((sourcePane.getText() == null) || (sourcePane.getText().trim().equals(""))){
        		final JPanel panel = new JPanel();
        		JOptionPane.showMessageDialog(panel, "No input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
            	TISpellChecker spellCheck = new TISpellChecker(sourcePane.getText());
	            while(!spellCheck.isTextCorrect()){
	            	SpellCheckFrame spellFrame = new SpellCheckFrame();
	            	spellFrame.openFrame(spellCheck.getContext(), (Object)spellCheck.check());
	            }
	            completeText = spellCheck.returnCompleteText();
	            this.setVisible(false);
	            
            }
        }
	}
}
