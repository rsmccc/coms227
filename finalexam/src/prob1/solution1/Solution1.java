package prob1.solution1;

import java.util.ArrayList;
import java.util.Random;

import prob1.IPlayer;


/**
 * One possible approach to reducing duplication is just
 * to have one of the players extend the other, and override
 * the play() method.  Note there is still some duplication
 * in the play() method in recording the history, and 
 * it lacks logical coherence (i.e., is an AlternatingPlayer
 * really a type of RandomPlayer?)
 */
public class Solution1
{
}

class RandomPlayer implements IPlayer
{
  private Random rand = new Random();
  private ArrayList<Integer> history = new ArrayList<Integer>();

  public int play()
  {
    int move = rand.nextInt(3); // randomly chooses 0, 1, or 2
    history.add(move);
    return move;
  }

  public int getPreviousMove(int movesAgo) 
  {
    return history.get(history.size() - movesAgo);
  }
  
  // accessor so subclass can use Random object
  protected int nextRandom(int n)
  {
    return rand.nextInt(n);
  }
  
  // allow subtype to add to history
  protected void addToHistory(int move)
  {
    history.add(move);
  }
}

class AlternatingPlayer extends RandomPlayer
{
  private int state = 0;

  public int play()
  {
    // usually returns 0, but every third move randomly chooses 1 or 2
    int move = 0;
    if (state % 3 == 2)
    {
      move = nextRandom(2) + 1;
    }
    ++state;
    addToHistory(move);
    return move;
  }


}