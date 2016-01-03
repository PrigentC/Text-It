package extract;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class DocExtract {

	public String st;
	private OutputStream outputstream;
	private ParseContext context;
	private Detector detector;
	private Parser parser;
	private Metadata metadata;

	public DocExtract() {
		st = null;
	    context = new ParseContext();
	    detector = new DefaultDetector();
	    parser = new AutoDetectParser(detector);
	    context.set(Parser.class, parser);
	    outputstream = new ByteArrayOutputStream();
	    metadata = new Metadata();
	}

	public void DocExtractText(String filename) {
		try{
		    URL url;
		    File file = new File(filename);
		    if (file.isFile()) {
		        url = file.toURI().toURL();
		    } else {
		        url = new URL(filename);
		    }
		    InputStream input = TikaInputStream.get(url, metadata);
		    ContentHandler handler = new BodyContentHandler(outputstream);
		    parser.parse(input, handler, metadata, context); 
		    input.close();
	
		    st = outputstream.toString();
	        System.out.println("Text:"+st);
	    }catch(IOException e){
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*
	public void DocExtractText(String fileName) {
		try{
			InputStream inputstream = new FileInputStream(fileName); 
			//read the file 
			XWPFDocument adoc= new XWPFDocument(inputstream);
			//and place it in a xwpf format

			st = new XWPFWordExtractor(adoc).getText();           
			//gets the full text
	        /*WordDocument wd = new WordDocument(fileName);
	        StringWriter docTextWriter = new StringWriter();
	        wd.writeAllText(new PrintWriter(docTextWriter));
	        docTextWriter.close();
	        st = docTextWriter.toString();
	        System.out.println("Text:"+st);
		 }catch(Exception e){
		        e.printStackTrace();
		 }
    }*/
}
