package scoreboard;
import java.io.File;


import acm.program.GraphicsProgram;
import acm.util.SoundClip;
import java.util.Random;




public class RandomSongPlayer extends Thread {
	
	
	public SoundClip silence = new SoundClip(new File("/Users/arismith/Documents/assets/5seconds.wav"));
	public Random rgen = new Random();
	public Random sgen = new Random();
	public GraphicsProgram GProgram;
	public SoundClip songlist = new SoundClip(new File("/Volumes/BHHL/music1.wav"));
	
	public RandomSongPlayer(GraphicsProgram GProgram) {
		
		
		this.GProgram = GProgram;
	}
	
	public void playmusic() {
		songlist = new SoundClip(new File("/Volumes/BHHL/music"+sgen.nextInt(158)+".wav"));
		//songlist = new SoundClip(new File("/Volumes/BHHL/music5.wav"));
		songlist.setVolume(1);
		silence.setVolume(1);
		songlist.setFrameIndex(rgen.nextInt(songlist.getFrameCount()-(songlist.getFrameCount()/4)));
		songlist.play();
		
	}
	
}
