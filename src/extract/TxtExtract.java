package extract;

import java.io.BufferedReader;
import java.io.FileReader;

public class TxtExtract extends Extractor{
	
	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public TxtExtract (){
		st = null;
	}
	
	@Override
	public void extractText(String fileName) {
        String fileContent = "";
         
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;
 
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String str = null;
 
            while ((str = reader.readLine()) != null) {
                contents.append(str);
            }
                     
            fileContent = contents.toString();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage()); }
        }
        st = fileContent;
    }
}
