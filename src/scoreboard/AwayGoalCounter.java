package scoreboard;

import java.awt.Color;

import acm.program.GraphicsProgram;
import acm.util.SoundClip;

public class AwayGoalCounter extends GoalCounter {
	public SoundClip whistle;
	
	public AwayGoalCounter(int xlocation, int ylocation, int fontsize, Color colour, GraphicsProgram GProgram, ScoreboardTimer timer, SoundClip whistle) {
		super(xlocation, ylocation, fontsize, colour, GProgram, timer);
		this.whistle = whistle;
		whistle.setVolume(1);
		
	}
	public void IncreaseAwayGoals() {
		this.IncreaseGoals();
		whistle.rewind();
		whistle.play();
		
		
	}
}