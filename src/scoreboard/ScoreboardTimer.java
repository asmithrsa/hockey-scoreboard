package scoreboard;



import java.awt.Color;
import java.io.File;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acm.program.Program;
import acm.util.SoundClip;



public class ScoreboardTimer extends Thread {

	public Program Program;
	public int minutes;
	public int seconds;
	public int miliseconds;
	public boolean paused = true;
	public GLabel timerlabel = new GLabel("5:00",550,200);
	public Color colour;
	public GraphicsProgram GProgram;
	public char period;
	public SoundClip periodhorn = new SoundClip(new File("/Users/arismith/Documents/assets/periodhorn.wav"));
	public SoundClip end1period = new SoundClip(new File("/Users/arismith/Documents/assets/end1period.wav"));
	public SoundClip end2period = new SoundClip(new File("/Users/arismith/Documents/assets/end2period.wav"));
	
	
	public ScoreboardTimer(int minutes, int seconds, char period, Color colour,GraphicsProgram GProgram) {
		this.minutes = minutes;
		this.seconds = seconds;
		this.miliseconds = 0;
		this.period = period;
		this.colour = colour;
		if (this.seconds < 10) {
			timerlabel.setLabel(this.minutes+":0"+this.seconds);
		}
		else {
			timerlabel.setLabel(this.minutes+":"+this.seconds);
		}
		timerlabel.setFont("Cursed Timer ULiL-plain-150");
		timerlabel.setColor(colour);
		periodhorn.setVolume(1);
		end1period.setVolume(1);
		end2period.setVolume(1);
		this.GProgram = GProgram;
		this.GProgram.add(timerlabel);
	}
	
	public void setTimer(int minutes, int seconds,int miliseconds) {
		this.minutes = minutes;
		this.seconds = seconds;
		this.miliseconds = miliseconds;
		if (this.seconds < 10) {
			timerlabel.setLabel(this.minutes+":0"+this.seconds);
		}
		else {
			timerlabel.setLabel(this.minutes+":"+this.seconds);
		}
	}
	

	public void timerstart() {
		boolean beginning = true;
		while (true) {
			if (beginning) paused = true;
			while (paused) if (paused == false) break;
		
			while (!paused && (this.minutes > 0 || this.seconds > 0 || this.miliseconds > 0)) {
				
			
				if (minutes == 0 && seconds == 0) {
					GProgram.pause(100);
					if (paused == true) break;
					miliseconds--;
					timerlabel.setLabel(seconds+"."+miliseconds);
				}
				if (minutes==0) {
					GProgram.pause(100);
					if (paused == true) break;
					if (miliseconds == 0) {
						seconds--;
						miliseconds = 9;
					}
					if (paused == true) break;
					miliseconds--;
					timerlabel.setLabel(seconds+"."+miliseconds);
				}
				else if (seconds == 0 && minutes==1) {
					while (miliseconds != 0) {
						GProgram.pause(100);
						if (paused == true) break;
						miliseconds--;
					}
					if (paused == true) break;
					if (period == '1') end1period.play();
					else if (period == '2') end2period.play();
					minutes--;
					seconds = 59;
					miliseconds = 9;
					timerlabel.setLabel(seconds+"."+miliseconds);
				}
				else if (seconds == 0) {
					while (miliseconds != 0) {
						GProgram.pause(100);
						if (paused == true) break;
						miliseconds--;
					}
					if (paused == true) break;
					minutes--;
					seconds = 59;
					miliseconds = 9;
					timerlabel.setLabel(minutes+":"+seconds);
				}
				else if (seconds <= 10) {
					while (miliseconds != 0) {
						GProgram.pause(100);
						if (paused == true) break;
						miliseconds--;
					}
					if (paused == true) break;
					seconds--;
					miliseconds = 9;
					timerlabel.setLabel(minutes+":0"+seconds);
				}
				else {
					while (miliseconds != 0) {
						GProgram.pause(100);
						if (paused == true) break;
						miliseconds--;
					}
					if (paused == true) break;
					seconds--;
					miliseconds = 9;
					timerlabel.setLabel(minutes+":"+seconds);
				}
			
			
			}
			
			if (minutes == 0 && seconds == 0 && miliseconds == 0) {
				periodhorn.play();
				break;
			}
			
			beginning = false;
		}
	}
	
		
}
