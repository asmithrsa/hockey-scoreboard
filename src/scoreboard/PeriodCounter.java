package scoreboard;

import java.awt.Color;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class PeriodCounter {
	GLabel periodlabel = new GLabel("WU",678,480);
	GraphicsProgram GProgram;
	Color colour;
	
	public PeriodCounter(Color colour, GraphicsProgram GProgram) {
		this.GProgram = GProgram;
		this.colour = colour;
		periodlabel.setFont("Cursed Timer ULiL-plain-64");
		periodlabel.setColor(colour);
		GProgram.add(periodlabel);
	}
	
	public void setPeriod(String period) {
		periodlabel.setLabel(period);
		
	}
}
