/*

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import hw3.api.IPolyominoGenerator;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;
import hw3.impl.GridCell;

public class BlockGameDeprecated extends AbstractBlockGame {

	public BlockGameDeprecated(IPolyominoGenerator gen) {
		super(gen);
	}
	
	public BlockGameDeprecated(IPolyominoGenerator gen, Random rand) {
		super(gen);
		GridCell[][] grid = getGrid();
		//TODO test
		for (int row = 0; row < 8; row++) {
			int start = (row % 2 == 0) ? 0 : 1;
			for (int col = 1; col <= 6; col++) {
				Color color = AbstractBlockGame.COLORS[rand.nextInt(AbstractBlockGame.COLORS.length)];
				grid[HEIGHT - 1 - row][WIDTH - col * 2 + start] = new GridCell(color);
			}
		}
	}

	@Override
	public ArrayList<Position> determineCellsToCollapse() {
		
		ArrayList<Position> cellsToCollapse = new ArrayList<Position>();
		
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				int row = i;
				int col = j;
				if (getGridIcon(row, col) != null) {
					
					ArrayList<Position> relPos = new ArrayList<>();
					ArrayList<GridCell> rel = new ArrayList<>();
					
					// GridCell in focus
					relPos.add(new Position(row, col));
					rel.add(getGridIcon(row, col));
					
					// Above
					try {
						if (getGridIcon(row - 1, col) != null) {
							relPos.add(new Position(row - 1, col));
							rel.add(getGridIcon(row - 1, col));
						}
					}
					catch (ArrayIndexOutOfBoundsException exception) {
						System.out.println("Array Index Out of Bounds: " + exception.getMessage());
//						relPos.remove(relPos.size() - 1);
					}
					// Below
					try {
						if (getGridIcon(row + 1, col) != null) {
							relPos.add(new Position(row + 1, col));
							rel.add(getGridIcon(row + 1, col));
						}
					}
					catch (ArrayIndexOutOfBoundsException exception) {
						System.out.println("Array Index Out of Bounds: " + exception.getMessage());
//						relPos.remove(relPos.size() - 1);
					}
					// Left
					try {
						if (getGridIcon(row, col - 1) != null) {
							relPos.add(new Position(row, col - 1));
							rel.add(getGridIcon(row, col - 1));
						}
					}
					catch (ArrayIndexOutOfBoundsException exception) {
						System.out.println("Array Index Out of Bounds: " + exception.getMessage());
//						relPos.remove(relPos.size() - 1);
					}
					// Right
					try {
						if (getGridIcon(row, col + 1) != null) {
							relPos.add(new Position(row, col + 1));
							rel.add(getGridIcon(row, col + 1));
						}
					}
					catch (ArrayIndexOutOfBoundsException exception) {
						System.out.println("Array Index Out of Bounds: " + exception.getMessage());
//						relPos.remove(relPos.size() - 1);
					}
	
					ArrayList<Position> neighbors = new ArrayList<>();
					
					for (int cell = 1; cell < rel.size(); cell++) {
						if (rel.get(0).matches(rel.get(cell))) { 
							neighbors.add(relPos.get(cell)); 
							}
					}
					
					if (neighbors.size() >= 2) {
						neighbors.add(relPos.get(0));
						cellsToCollapse.addAll(neighbors);
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
	
	private boolean isRowEmpty(int row) {
	    int numEmpty = 0;
		for (int col = 0; col < getWidth(); col ++)
	    {
	      if (getGridIcon(row, col) == null)
	      {
	    	numEmpty++;  
	      }
	    }
		return (numEmpty == getWidth()) ? true : false;
	}
	
}
*/