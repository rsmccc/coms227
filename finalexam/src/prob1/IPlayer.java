package prob1;

public interface IPlayer {
	
	int play(); //Returns the player's move, which is always 0, 1, or 2 
	
	int getPreviousMove(int movesAgo); // Returns a previous move

}
