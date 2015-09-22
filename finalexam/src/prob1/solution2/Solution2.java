package prob1.solution2;


import java.util.ArrayList;
import java.util.Random;

import prob1.IPlayer;


/**
 * Solution that factors all common code into an abstract base
 * class.  This approach does a better job of reducing duplicated
 * code and allowing for further types of players to be added.
 * 
 * Note that each player still has its own Random object, but
 * this is logically consistent with the idea that the AbstractPlayer
 * should have attributes common to *all* players, and it's
 * reasonable to supposed that not all players will use
 * randomness.
 */
public class Solution2
{
}

abstract class AbstractPlayer implements IPlayer
{
  private ArrayList<Integer> history = new ArrayList<Integer>();

  protected abstract int getMove();
  
  public int play()
  {
    int move = getMove();
    history.add(move);
    return move;
  }
  
  public int getPreviousMove(int movesAgo) 
  {
    return history.get(history.size() - movesAgo);
  }
}

class RandomPlayer extends AbstractPlayer
{
  private Random rand = new Random();

  public int getMove()
  {
    return rand.nextInt(3);
  }
}

class AlternatingPlayer extends AbstractPlayer
{
  private int state = 0;
  private Random rand = new Random();

  public int getMove()
  {
    // usually returns 0, but every third move randomly chooses 1 or 2
    int move = 0;
    if (state % 3 == 2)
    {
      move = rand.nextInt(2) + 1;
    }
    ++state;
    return move;
  }
}