package extract;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ExtractText extends JFrame {
	
	private String st;
	private Boolean enab;
	
	public void ExtractAllText(String extension, String exFile){
		switch(extension){
		
		case ".pdf":
			PdfExtract pdf = new PdfExtract();
			pdf.extractText(exFile);
			setSt(pdf.getSt());
			setEnab(true);
			break;
		
		case ".doc":
			DocExtract doc = new DocExtract();
			doc.extractText(exFile);
			setSt(doc.getSt());
			setEnab(true);
			break;			
		
		case ".docx":
			DocExtract docx = new DocExtract();
			docx.extractText(exFile);
			setSt(docx.getSt());
			setEnab(true);
			break;
		
		case ".txt":
			TxtExtract txt = new TxtExtract();
			txt.extractText(exFile);
			setSt(txt.getSt());
			setEnab(true);
			break;
		
		default:
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Wrong format!", "Error", JOptionPane.ERROR_MESSAGE);			
			setEnab(false);
			break;
		}

	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public Boolean getEnab() {
		return enab;
	}

	public void setEnab(Boolean enab) {
		this.enab = enab;
	}

}
