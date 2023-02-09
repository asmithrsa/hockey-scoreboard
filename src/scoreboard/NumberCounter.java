package scoreboard;

import java.awt.Color;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class NumberCounter extends Thread {
	public GLabel visualcount;
	public int xlocation;
	public int ylocation;
	public int counter = 0;
	public int fontsize;
	public Color colour;
	public GraphicsProgram GProgram;
	
	public NumberCounter(int xlocation, int ylocation, int fontsize, Color colour, GraphicsProgram GProgram) {
		this.xlocation = xlocation;
		this.ylocation = ylocation;
		this.colour = colour;
		this.fontsize = fontsize;
		this.GProgram = GProgram;
		visualcount = new GLabel((counter+""),xlocation,ylocation);
		visualcount.setFont("Cursed Timer ULiL-plain-"+fontsize);
		visualcount.setColor(colour);
		this.GProgram.add(visualcount);
		
	}
	public void IncreaseCounter() {
		counter++;
		visualcount.setLabel(counter+"");
	}
	public void DecreaseCounter() {
		counter--;
		visualcount.setLabel(counter+"");
	}

}
