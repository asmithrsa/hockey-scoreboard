package scoreboard;

import java.awt.Color;

import acm.program.GraphicsProgram;

public class GoalCounter extends NumberCounter {
	public ScoreboardTimer timer;
	
	public GoalCounter(int xlocation, int ylocation, int fontsize, Color colour, GraphicsProgram GProgram, ScoreboardTimer timer) {
		super(xlocation, ylocation, fontsize, colour, GProgram);
		this.timer = timer;
	}
	
	public void IncreaseGoals() {
		this.IncreaseCounter();
		timer.paused = true;
	}
	
}
