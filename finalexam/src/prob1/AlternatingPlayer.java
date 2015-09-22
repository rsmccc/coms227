package prob1;


public class AlternatingPlayer extends RandomPlayer {

	private int state;
	
	public AlternatingPlayer() {
		super();
		state = 0;
	}
	
	@Override
	public int play() {
		// usually returns 0, but every third move randomly chooses 1 or 2
		int move = 0;
		if (state % 3 == 2) {
//			move = rand.nextInt(2) + 1;
		}
		super.play();
		return 0;
	}

}
