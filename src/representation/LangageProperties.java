package representation;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class LangageProperties {
	
	protected Graphics2D g;
	
	public abstract Color colorChooser(String s);
	
	public abstract int gramarLength();
	
	public abstract void drawLegend();
}
