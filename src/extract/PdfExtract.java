package extract;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PdfExtract {
	
	protected PDDocument document;
	public String st;
	
	public PdfExtract (){
		document = null;
		st = null;
	}
		
	public void PdfExtractText(String fileName){
		try{
		    PDDocument document = null; 
		    document = PDDocument.load(new File(fileName));
		    document.getClass();
		    if( !document.isEncrypted() ){
		        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		        stripper.setSortByPosition( true );
		        PDFTextStripper Tstripper = new PDFTextStripper();
		        st = Tstripper.getText(document);
		        System.out.println("Text:"+st);
		    }
		 }catch(Exception e){
		        e.printStackTrace();
		 }
	
	}

}
