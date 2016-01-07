package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import analyzer.lexical.TISpellChecker;
import analyzer.syntaxical.TISyntaxAnalyzer;
import javafx.util.Pair;
import representation.image.ImageDraftman;

@SuppressWarnings("serial")
public class SpellCheckFrame extends JDialog implements ActionListener{
	
	private JButton jButton = null;
	private JTextField text = null;
	private JTextField correctText = null;
	private String contexte;
	private Object [] elements;
	
	private ArrayList<Pair<String,String>> syntaxResult;
	private String fullText;


	@SuppressWarnings("rawtypes")
	private JComboBox liste;
	private TISpellChecker spellCheck;
	private TISyntaxAnalyzer synataxAnalyzer;
	private ImageDraftman imageDraft;
	private BufferedImage buffImage;
	
	public void spellCheckFrameExecute(){
		text = new JTextField(10);
		correctText = new JTextField(10);

		try {
			spellCheck = new TISpellChecker(fullText);
			spellCheck.addDictionnary(spellCheck.getDict());

			if(!spellCheck.isTextCorrect()){
				
				elements = spellCheck.check();
				contexte = spellCheck.getContext();

				openFrame(contexte, elements);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		synataxAnalyzer = new TISyntaxAnalyzer("cathie.prigent@uha.fr", "ahg5Awodu8ga");
		synataxAnalyzer.launchAnalysis(fullText);
		syntaxResult = synataxAnalyzer.getResult();
		
		imageDraft = new ImageDraftman();
		imageDraft.createWhiteImage(fullText.length());
		try {
			imageDraft.draw(syntaxResult);
			buffImage = imageDraft.getImg();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void openFrame(String line, Object[] elements) throws IOException{
		String[] table = line.split("\\s+");
		//Frame Settings
		setTitle("Spell Checker");
		setSize(300, 150);
		setLocationRelativeTo(null);

		Container contentPane = getContentPane();
		
		JPanel elementsPanel = new JPanel();
		
		if(table.length == 5){
			
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
		} else{

			text.setText(table[0]);
			JLabel jlabel1 = new JLabel(table[1]);
			JLabel jlabel2 = new JLabel(table[2]);
			
			elementsPanel.add(text);
			elementsPanel.add(jlabel1);
			elementsPanel.add(jlabel2);
		}
		
		elementsPanel.add(new JSeparator(SwingConstants.VERTICAL));
				
		JLabel jlabelChosse = new JLabel("Choose : ");
		JLabel jlabelDet = new JLabel("Correct : ");
		
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
        revalidate();
        repaint();
        
		setModal(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == jButton) {
			
            System.out.println("You have clicked on the ok action");
            
            if((correctText.getText() == null) || liste.getSelectedIndex() <= 0){
            	
        		final JPanel panel = new JPanel();
        		JOptionPane.showMessageDialog(panel, "Correct the word!", "Error", JOptionPane.ERROR_MESSAGE);
            
            }
            else{
				if((correctText.getText() == null) || liste.getSelectedIndex() > 0){
					
					spellCheck.correct(liste.getSelectedItem().toString());
					setFullText(spellCheck.returnCompleteText());
				}else if((correctText.getText() != null) || liste.getSelectedIndex() <= 0){
					spellCheck.correct(correctText.getText());
					setFullText(spellCheck.returnCompleteText());
				}else if((correctText.getText() != null) || liste.getSelectedIndex() > 0){
					spellCheck.correct(correctText.getText());
					setFullText(spellCheck.returnCompleteText());
				}
				
				setVisible(false);
            }
        }
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}


	public ArrayList<Pair<String,String>> getSyntaxResult() {
		return syntaxResult;
	}


	public void setSyntaxResult(ArrayList<Pair<String,String>> syntaxResult) {
		this.syntaxResult = syntaxResult;
	}


	public BufferedImage getBuffImage() {
		return buffImage;
	}


	public void setBuffImage(BufferedImage buffImage) {
		this.buffImage = buffImage;
	}

}
