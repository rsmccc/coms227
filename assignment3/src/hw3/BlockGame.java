package hw3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import hw3.api.IPolyominoGenerator;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;
import hw3.impl.GridCell;

/**
 * This class extends AbstractBlockGame for our BlockGame
 * @author rsmccloskey
 *
 */
public class BlockGame extends AbstractBlockGame {

	/**
	 * This variable keeps track of the total cells that have been collapsed
	 */
	private int score;
	
	public BlockGame(IPolyominoGenerator gen) {
		super(gen);
	}
	
	public BlockGame(IPolyominoGenerator gen, Random rand) {
		super(gen);
		GridCell[][] grid = getGrid();
		for (int row = 0; row < 8; row++) {
			// If the row is even, increment the starting column by one
			int start = (row % 2 == 0) ? 1 : 0;
			for (int col = 1; col <= 6; col++) {
				Color color = AbstractBlockGame.COLORS[rand.nextInt(AbstractBlockGame.COLORS.length)];
				grid[getHeight() - 1 - row][getWidth() - col * 2 + start] = new GridCell(color);
			}
		}
	}

	@Override
	public ArrayList<Position> determineCellsToCollapse() {
		
		ArrayList<Position> cellsToCollapse = new ArrayList<Position>();
		
		for (int row = 0; row < getHeight(); row++) {
				for (int col = 0; col < getWidth(); col++) {
					if (getGridIcon(row, col) != null) {
						Position focus = new Position(row, col);
						int r = focus.getRow();
						int c = focus.getCol();
						
						// Bounds checking, returns neighbors that are not null and within the grid
						ArrayList<Position> neighbors = getValidatedNeighbors(focus);
						
						GridCell center = getGridIcon(r, c);
						
						GridCell[] cells = new GridCell[neighbors.size()];
						ArrayList<Position> posMatches = new ArrayList<Position>();
						for (int i = 0; i < neighbors.size(); i++) {
							cells[i] = getGridIcon(neighbors.get(i).getRow(), neighbors.get(i).getCol());
							if (center.matches(cells[i])) {	 
								posMatches.add(neighbors.get(i));
							}
						}
						// Store position matches here until we know that there are at least two matches for the cell
						if (posMatches.size() >= 2) {
							posMatches.add(focus);
							cellsToCollapse.addAll(posMatches);
							posMatches.clear();
						}
					}
				}	
		}
		score += cellsToCollapse.size();
		return cellsToCollapse;
	}
	

	@Override
	public int determineScore() {
		return score;
	}
	
	/**
	 * This method accepts a position and returns an ArrayList made up of four or less cells
	 * that are 1) neighbors, 2) not null and 3) within the boundaries of the grid.
	 * @param p
	 * 	position to validate
	 * @return validated
	 * 	list of neighbors that are not null and within boundaries
	 */
	private ArrayList<Position> getValidatedNeighbors(Position p) {
		// Set boundaries
		int r = p.getRow();
		int c = p.getCol();
		int maxColIndex = getWidth() - 1;
		int maxRowIndex = getHeight() - 1;
		int minIndex = 0;
		
		// Create new positions for each neighbor
		Position above = new Position(r - 1, c);
		Position below = new Position(r + 1, c);
		Position left = new Position(r, c - 1);
		Position right = new Position(r, c + 1);
		
		Position[] temp = {above, below, left, right};
		
		ArrayList<Position> validated = new ArrayList<Position>();
		
		// If within boundaries and not null, add neighbor to validated
		for (int i = 0; i < 4; i++) {
			if (temp[i].getRow() > maxRowIndex || temp[i].getRow() < minIndex) {
				temp[i] = null;
			}
			else if (temp[i].getCol() > maxColIndex || temp[i].getCol() < minIndex) {
				temp[i] = null;
			}
			if (temp[i] != null) {
				validated.add(temp[i]);
			}
		}
		return validated;
	}
		
}
