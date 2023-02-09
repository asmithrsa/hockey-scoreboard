package scoreboard;

import java.awt.Color;

import acm.program.GraphicsProgram;
import acm.util.SoundClip;

public class HomeGoalCounter extends GoalCounter {
	public SoundClip goalhorn;
	
	public HomeGoalCounter(int xlocation, int ylocation, int fontsize, Color colour, GraphicsProgram GProgram, ScoreboardTimer timer, SoundClip goalhorn) {
		super(xlocation, ylocation, fontsize, colour, GProgram, timer);
		this.goalhorn = goalhorn;
		goalhorn.setVolume(1);
		
	}
	public void IncreaseHomeGoals() {
		this.IncreaseGoals();
		goalhorn.rewind();
		goalhorn.play();
	}
}
