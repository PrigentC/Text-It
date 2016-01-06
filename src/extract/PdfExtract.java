package extract;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PdfExtract extends Extractor {
	
	protected PDDocument document;
	
	public PdfExtract (){
		document = null;
		setSt(null);
	}
	
	@Override
	public void extractText(String fileName){
		try{
			
		    PDDocument document = null; 
		    document = PDDocument.load(new File(fileName));
		    document.getClass();
		    
		    if( !document.isEncrypted() ){
		    	
		        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		        stripper.setSortByPosition( true );
		        PDFTextStripper Tstripper = new PDFTextStripper();
		        setSt(Tstripper.getText(document));
		        document.close();
		    
		    }
		 }catch(Exception e){
		        e.printStackTrace();
		 }

	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

}
