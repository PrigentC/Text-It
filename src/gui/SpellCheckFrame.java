package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SpellCheckFrame extends JFrame implements ActionListener{
	
	private JButton jButton = null;
	private JTextField text = null;
	private JTextField correctText = null;
	@SuppressWarnings("rawtypes")
	private JComboBox liste;
	
	public SpellCheckFrame(){
		text = new JTextField(10);
		correctText = new JTextField(10);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void openFrame(String line, Object[] elements) throws IOException{
		
		String[] table = line.split("\\s+");
		//Frame Settings
		setTitle("Spell Checker");
		setSize(300, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container contentPane = getContentPane();
		
		JPanel elementsPanel = new JPanel();
		
		JLabel jlabel1 = new JLabel(table[0]);
		JLabel jlabel2 = new JLabel(table[1]);
		text.setText(table[2]);
		JLabel jlabel3 = new JLabel(table[3]);
		JLabel jlabel4 = new JLabel(table[4]);
		
		elementsPanel.add(jlabel1);
		elementsPanel.add(jlabel2);
		elementsPanel.add(text);
		elementsPanel.add(jlabel3);
		elementsPanel.add(jlabel4);
		
		elementsPanel.add(new JSeparator(SwingConstants.VERTICAL));
				
		JLabel jlabelChosse = new JLabel("Choose : ");
		JLabel jlabelDet = new JLabel("Correct : ");
		
		//Object[] elements = new Object[]{"", "a", "an"};
		liste = new JComboBox(elements);
		
		elementsPanel.add(jlabelChosse);
		elementsPanel.add(liste);
		elementsPanel.add(jlabelDet);
		elementsPanel.add(correctText);
		
		contentPane.add(elementsPanel);
		
        JPanel buttonPanel = new JPanel();

        jButton = new JButton("OK");
        jButton.addActionListener(this);
        buttonPanel.add(jButton);

        // Add the button panel at the bottom of the JFrame
        contentPane.add(buttonPanel,BorderLayout.SOUTH);
		
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == jButton) {
            System.out.println("You have clicked on the ok action");
            if((correctText.getText() == null) || (correctText.getText().trim().equals("")) || liste.getSelectedIndex() <= -1){
        		final JPanel panel = new JPanel();
        		JOptionPane.showMessageDialog(panel, "Correct the word!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
            	
            	this.setVisible(false);
            }
        }
	}

}
