package analyzer.syntaxical;

import java.util.ArrayList;
import java.util.HashMap;

import io.theysay.affectr.client.AccountDetails;
import io.theysay.affectr.client.api.Api;
import javafx.util.Pair;

public class TISyntaxAnalyzer {
	private AccountDetails ad = new AccountDetails();
	private Api api;
	
	private ArrayList<String> svgdText = new ArrayList<String>();
	private HashMap<String, String> result = new HashMap<String, String>();
	
	public TISyntaxAnalyzer(String username, String password) {
		ad.setUsername(username);
		ad.setPassword(password);
		
		api = new Api(ad);
	}
	
	public void launchAnalysis(String text) {
		String[] p;
		
		for(int i = 0 ; i < api.posTag(text).length ; i++) {
			p = api.posTag(text)[i].getPosTaggedWord().split("/");
			
			svgdText.add(p[0]);
			result.put(p[0], p[1]);
			System.out.println(result.get(p[0]));
		}
	}
	
	public HashMap<String, String> getHashResult() {
		return result;
	}
	
	public ArrayList<String> getSvgdText() {
		return svgdText;
	}

	public ArrayList<Pair<String,String>> getResult() {
		ArrayList<Pair<String,String>> r = new ArrayList<Pair<String,String>>();
		
		for(String s : svgdText)
			r.add(new Pair<String, String>(s, result.get(s)));
		
		return r;
	}
}
