package extract;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ExtractText extends JFrame {
	
	public Boolean enab;

	public ExtractText (){
	}
	
	public void ExtractAllText(String extension, String exFile){
		switch(extension){
		case ".pdf":
			PdfExtract pdf = new PdfExtract();
			pdf.PdfExtractText(exFile);
			enab = true;
			break;
		case ".doc":
			DocExtract doc = new DocExtract();
			doc.DocExtractText(exFile);
			enab = true;
			break;			
		case ".docx":
			DocExtract docx = new DocExtract();
			docx.DocExtractText(exFile);
			enab = true;
			break;
		case ".txt":
			TxtExtract txt = new TxtExtract();
			txt.TxtExtractText(exFile);
			enab = true;
			break;
		default:
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Wrong format!", "Error", JOptionPane.ERROR_MESSAGE);			
			enab = false;
			break;
		}

	}

}
