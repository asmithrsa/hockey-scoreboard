package scoreboard;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;


public class ScoreboardGraphics extends GraphicsProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GImage background = new GImage("/Users/arismith/Documents/assets/Period.png");
	
	public ScoreboardTimer timer;
	NumberCounter homeshots;
	NumberCounter awayshots;
	HomeGoalCounter homegoals;
	AwayGoalCounter awaygoals;
	PeriodCounter period;
	public SoundClip whistle = new SoundClip(new File("/Users/arismith/Documents/assets/whistle.wav"));
	public char home;
	public char away;
	public GLabel homelabel;
	public GLabel awaylabel;
	public RandomSongPlayer songlist;
	NumberCounter awayfaceoffs;
	NumberCounter homefaceoffs;
	
	
	
	public static void main(String[] args) {
		new ScoreboardGraphics().start(args);
	}
	
	
	public void run() {
		this.resize(1450, 906);
		add(background);
		
		addKeyListeners();
		timer = new ScoreboardTimer(10,0, 'W', Color.BLUE, this);
		homeshots = new NumberCounter(194, 819, 115, Color.RED, this);
		awayshots = new NumberCounter(1132, 819, 115, Color.RED, this);
		homegoals = new HomeGoalCounter(181, 509, 200, Color.GREEN, this, timer, new SoundClip(new File("/Users/arismith/Documents/assets/HuskiesGoalHorn.wav")));
		awaygoals = new AwayGoalCounter(1130, 509, 200, Color.GREEN, this, timer, new SoundClip(new File("/Users/arismith/Documents/assets/whistle.wav")));
		period = new PeriodCounter(Color.RED, this);
		awayfaceoffs = new NumberCounter(1000, 819, 64, Color.GRAY, this);
		homefaceoffs = new NumberCounter(390, 819, 64, Color.GRAY, this);
		songlist = new RandomSongPlayer(this);
		
		
		home = readLine("Who's home?").charAt(0);
		away = readLine("Who's away?").charAt(0);
		getHome();
		getAway();
		
		
		timer.setTimer(1, 0, 0);
		period.setPeriod("WU");
		whistle.setVolume(1);
		timer.timerstart();
		pause(4000); 
		period.setPeriod("1");
		timer.period = '1';
		timer.setTimer(5, 0, 0);
		timer.timerstart();
		period.setPeriod("INT");
		timer.period = 'I';
		timer.setTimer(2, 0, 0);
		timer.timerstart();
		pause(4000);
		
		period.setPeriod("2");
		timer.period = '2';
		timer.setTimer(5, 0, 0);
		timer.timerstart();
		if (homegoals.counter == awaygoals.counter) {
			pause(4000);
			period.setPeriod("OT");
			timer.setTimer(20, 0, 0);
			timer.timerstart();
		}
		
		
		
	
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_Q:
			homegoals.IncreaseHomeGoals();
			homeshots.IncreaseCounter();
			break;
		case KeyEvent.VK_A:
			homegoals.DecreaseCounter();
			
			break;
		case KeyEvent.VK_E:
			awaygoals.IncreaseAwayGoals();
			awayshots.IncreaseCounter();
			break;
		case KeyEvent.VK_D:
			awaygoals.DecreaseCounter();
			
			break;
		case KeyEvent.VK_I:
			homeshots.IncreaseCounter();
			break;
		case KeyEvent.VK_K:
			homeshots.DecreaseCounter();
			break;
		case KeyEvent.VK_P:
			awayshots.IncreaseCounter();
			break;
		case KeyEvent.VK_SEMICOLON:
			awayshots.DecreaseCounter();
			break;
		case KeyEvent.VK_SPACE:
			whistle.rewind();
			whistle.play();
			//if scoreboard is stopped and started less than 4 seconds apart whistle won't blow
			if (timer.paused == true) {
				timer.paused = false;
				homegoals.goalhorn.stop();
				songlist.songlist.stop();
			}
			else if (timer.paused == false) {
				timer.paused = true;
				this.pause(2000);
				songlist.playmusic();
			}
			
			break;
		case KeyEvent.VK_O:
			int minutes = readInt("How many minutes? ");
			int seconds = readInt("How many seconds? ");
			//fix bug where if seconds < 10 no 0
			timer.setTimer(minutes, seconds, 0);
			break;
		case KeyEvent.VK_M:
			period.setPeriod(readLine("What period? "));
			break;
		case KeyEvent.VK_B:
			songlist.songlist.stop();
			break;
		case KeyEvent.VK_Z:
			homefaceoffs.IncreaseCounter();
			break;
		case KeyEvent.VK_X:
			homefaceoffs.DecreaseCounter();
			break;
		case KeyEvent.VK_C:
			awayfaceoffs.IncreaseCounter();
			break;
		case KeyEvent.VK_V:
			awayfaceoffs.DecreaseCounter();
			break;
		}
	}
	
	public void getHome() {
		switch (home) {
		case 'm':
			homelabel = new GLabel("MTL", 170, 260);
			homelabel.setColor(Color.WHITE);
			homelabel.setFont("Futura-plain-64");
			add(homelabel);
			homegoals.goalhorn = new SoundClip(new File("/Users/arismith/Documents/assets/MissilesGoalHorn.wav"));
			homegoals.goalhorn.setVolume(1);
			break;
		case 'q':
			homelabel = new GLabel("QC", 170, 260);
			homelabel.setColor(Color.WHITE);
			homelabel.setFont("Futura-plain-64");
			add(homelabel);
			homegoals.goalhorn = new SoundClip(new File("/Users/arismith/Documents/assets/HuskiesGoalHorn.wav"));
			homegoals.goalhorn.setVolume(1);
			break;
		case 'r':
			homelabel = new GLabel("RC", 170, 260);
			homelabel.setColor(Color.WHITE);
			homelabel.setFont("Futura-plain-64");
			add(homelabel);
			homegoals.goalhorn = new SoundClip(new File("/Users/arismith/Documents/assets/RacehorsesGoalHorn.wav"));
			homegoals.goalhorn.setVolume(1);
			break;
		case 'f':
			homelabel = new GLabel("FL", 170, 260);
			homelabel.setColor(Color.WHITE);
			homelabel.setFont("Futura-plain-64");
			add(homelabel);
			homegoals.goalhorn = new SoundClip(new File("/Users/arismith/Documents/assets/FlamingosGoalHorn.wav"));
			homegoals.goalhorn.setVolume(1);
			break;
		}
	}
	
	public void getAway() {
		switch (away) {
		case 'm':
			awaylabel = new GLabel("MTL", 1147, 260);
			awaylabel.setColor(Color.WHITE);
			awaylabel.setFont("Futura-plain-64");
			add(awaylabel);
			break;
		case 'q':
			awaylabel = new GLabel("QC", 1147, 260);
			awaylabel.setColor(Color.WHITE);
			awaylabel.setFont("Futura-plain-64");
			add(awaylabel);
			break;
		case 'r':
			awaylabel = new GLabel("RC", 1147, 260);
			awaylabel.setColor(Color.WHITE);
			awaylabel.setFont("Futura-plain-64");
			add(awaylabel);
			break;
		case 'f':
			awaylabel = new GLabel("FL", 1147, 260);
			awaylabel.setColor(Color.WHITE);
			awaylabel.setFont("Futura-plain-64");
			add(awaylabel);
			break;
			
		}
	}
	
}
