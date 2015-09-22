package prob1;

import java.util.ArrayList;
import java.util.Random;

public abstract class RandomPlayer implements IPlayer {
	private Random rand;
	private ArrayList<Integer> history;
	
	public RandomPlayer() {
		rand = new Random();
		history = new ArrayList<Integer>();
	}

	public int play() {
		int move = rand.nextInt(3); // randomly chooses 0, 1, or 2
		history.add(move);
		return move;
	}

	public int getPreviousMove(int movesAgo) {
		return history.get(history.size() - movesAgo);
	}

}
