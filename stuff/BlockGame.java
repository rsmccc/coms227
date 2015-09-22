package hw3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import hw3.api.IPolyominoGenerator;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;
import hw3.impl.GridCell;

public class BlockGame extends AbstractBlockGame {

	public BlockGame(IPolyominoGenerator gen) {
		super(gen);
	}
	
	public BlockGame(IPolyominoGenerator gen, Random rand) {
		super(gen);
		GridCell[][] grid = getGrid();
		for (int row = 0; row < 8; row++) {
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
		
		int maxColIndex = getWidth() - 1;
		int maxRowIndex = getHeight() - 1;
		int minIndex = 0;
		
		for (int row = 0; row < getHeight(); row++) {
				for (int col = 0; col < getWidth(); col++) {
					if (getGridIcon(row, col) != null) {
						Position focus = new Position(row, col);
						int r = focus.getRow();
						int c = focus.getCol();
						
						//TODO Bounds checking
						
						GridCell center = getGridIcon(r, c);
						
						r = focus.getRow() - 1;
						GridCell above = getGridIcon(r, c); 
						
						r = focus.getRow() + 1;
						GridCell below = getGridIcon(r, c);
						
						r = focus.getRow();
						c = focus.getCol() - 1;
						GridCell left = getGridIcon(r, c);
						
						c = focus.getCol() + 1;
						GridCell right = getGridIcon(r, c);
						
//						GridCell[] neighbors = 
						
//						ArrayList<Position> neighbors = getValidatedNeighbors(focus);
						ArrayList<Position> matches = new ArrayList<Position>();
						for (Position element : neighbors) {
							if (getGridIcon(focus.getRow(), focus.getCol()).matches(getGridIcon(element.getRow(), element.getCol()))) {
								matches.add(element);
							}
						}
						if (matches.size() > 2) {
							cellsToCollapse.addAll(matches);
							matches.clear();
							neighbors.clear();
						}
					}
				}	
		}
		return cellsToCollapse;
	}
	
	

	@Override
	public int determineScore() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * This method accepts a position and returns an ArrayList made up of four or less cells
	 * that are 1) neighbors, 2) not null and 3) within the boundaries of the grid.
	 * @param p
	 * 	position to validate
	 * @return
	 */
	private ArrayList<Position> getValidatedNeighbors(Position p) {
		int r = p.getRow();
		int c = p.getCol();
		int maxColIndex = getWidth() - 1;
		int maxRowIndex = getHeight() - 1;
		int minIndex = 0;
		
		Position above = new Position(r - 1, c);
		Position below = new Position(r + 1, c);
		Position left = new Position(r, c - 1);
		Position right = new Position(r, c + 1);
		
		Position[] temp = {above, below, left, right};
		
		ArrayList<Position> validated = new ArrayList<Position>();
		
		for (int i = 0; i < 4; i++) {
			if (temp[i].getRow() > maxRowIndex || temp[i].getRow() < minIndex) {
				temp[i] = null;
			}
			else if (temp[i].getCol() > maxColIndex || temp[i].getCol() < minIndex) {
				temp[i] = null;
			}
//			else if (getGridIcon(temp[i].getRow(), temp[i].getCol()) == null) {
//				temp[i] = null;
//			}
			if (temp[i] != null) {
				validated.add(temp[i]);
			}
		}
		return validated;
	}
		
	private boolean hasMatches(Position p) {
		int r = p.getRow();
		int c = p.getCol();
		// checkAbove
//		getGridIcon(r)
		return false;
	}
}
