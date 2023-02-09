package scoreboard;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import acm.program.Program;



public class ScoreboardFont extends Program {
	public static Font scoreboardfont;
	
	public static Font makefont() {
		try {
			scoreboardfont = Font.createFont(Font.TRUETYPE_FONT, new File("/Users/arismith/Documents/scoreboardfont.ttf"));
			
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scoreboardfont;
		
	}
}
