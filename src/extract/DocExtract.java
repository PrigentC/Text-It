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

public class DocExtract extends Extractor {

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

	@Override
	public void extractText(String filename) {
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

	    }catch(IOException e){
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
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
