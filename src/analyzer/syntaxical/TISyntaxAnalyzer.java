package analyzer.syntaxical;

import io.theysay.affectr.client.AccountDetails;
import io.theysay.affectr.client.AffectR;

public class TISyntaxAnalyzer {
	private AccountDetails ad = new AccountDetails();
	
	public TISyntaxAnalyzer(String username, String password) {
		ad.setUsername(username);
		ad.setPassword(password);
	}
	
	public String launchAnalysis(String text) {
		return AffectR.api.posTag(text)[0].getPosTaggedWord();
	}
}
