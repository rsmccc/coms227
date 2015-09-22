package hw2;

/**
 * A ScoreCalculator keeps track of the score calculation for a 
 * time-based word puzzle solving game.  The score starts out
 * at a maximum value determined by the difficulty of the puzzle
 * and decreases as time passes.  The calculator is initialized
 * for a round of the game by calling <code>start</code>.  
 * Thereafter, the current score can be obtained by calling
 * <code>getPossibleScore(int elapsedMillis)</code>.  Note that this
 * class only performs score calculation and does not do any
 * timekeeping; it is up to the caller to keep track of the 
 * actual time and provide the elapsed time in the 
 * <code>elapsedMillis</code> argument. 
 * <p>
 * For this implementation, the initial maximum score is always
 * the length of the word times the fixed value 
 * <code>millisPerLetter</code>.  The score is reduced by 
 * 1 for each elapsed millisecond. The score may also
 * be reduced by penalties for incorrect guesses or hints.
 */
public class ScoreCalculator
{
	private int millisPerLetter;
	
	private int hintPenalty;
	
	private int rescramblePenalty;
	
	private int incorrectGuessPenalty;
	
	private int score;
  
  /**
   * Constructs a ScoreCalculator for which the initial maximum score
   * is given by <code>millisPerLetter</code> times the number of
   * letters in a given word. 
   * @param millisPerLetter
   *   factor for determining initial maximum score
   * @param hintPenalty
   *   score penalty imposed for getting a hint in the game
   * @param incorrectGuessPenalty
   *   score penalty imposed for submitting an incorrect solution in the game
   */
  public ScoreCalculator(int millisPerLetter, int hintPenalty, int rescramblePenalty, int incorrectGuessPenalty)
  {
	this.millisPerLetter = millisPerLetter;
	this.hintPenalty = hintPenalty;
	this.rescramblePenalty = rescramblePenalty;
	this.incorrectGuessPenalty = incorrectGuessPenalty;
  }
  
  /**
   * Initializes this score calculator based on the given word length to start
   * a new round. The maximum possible score is <code>millisPerLetter</code> times
   * the word length.
   * @param wordLength
   *   length of the word for the current round
   */
  public void start(int wordLength)
  {
	score = wordLength * millisPerLetter;
  }

  /**
   * Returns the score the player would receive if the puzzle 
   * is solved in the given number of milliseconds.  The returned
   * value is the initial maximum score, less the given number
   * of milliseconds, less any accumulated penalties.  However, the
   * returned value is never less than zero.
   * @param elapsedMillis
   *   number of milliseconds it has taken the player so far 
   * @return
   *   current score for the given milliseconds
   */
  public int getPossibleScore(int elapsedMillis)
  {
	int currentScore = Math.max(0, score - elapsedMillis);
    return currentScore;
  }
  
  /**
   * Imposes the penalty for obtaining a hint.  This value will
   * be subtracted from the next call to <code>getScore</code>.
   */
  public void applyHintPenalty()
  {
	score -= hintPenalty;
  }

  /**
   * Imposes the penalty for rescrambling.  This value will
   * be subtracted from the next call to <code>getScore</code>.
   */
  public void applyRescramblePenalty()
  {
	score -= rescramblePenalty;
  }

  /**
   * Imposes the penalty for an incorrect guess.  This value will
   * be subtracted from the next call to <code>getScore</code>.
   */
  public void applyIncorrectGuessPenalty()
  {
	score -= incorrectGuessPenalty;
  }

}
