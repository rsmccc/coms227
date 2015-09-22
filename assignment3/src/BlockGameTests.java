

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import hw3.BasicGenerator;
import hw3.BlockGame;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;
import hw3.impl.GridCell;
import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlockGameTests {
	
	AbstractBlockGame game = new BlockGame(new BasicGenerator(new Random()));
	GridCell[][] grid = game.getGrid();
	ArrayList<Position> cells;
	ArrayList<Position> myCells;
	
	@Before
	public void setup() {
		grid[1][11] = new GridCell(Color.RED);
		grid[2][11] = new GridCell(Color.RED);
	    grid[3][11] = new GridCell(Color.RED);  
	    grid[3][10] = new GridCell(Color.RED);
	    grid[3][4] = new GridCell(Color.BLUE);
	    myCells = new ArrayList<>();
	    cells = game.determineCellsToCollapse();
	    System.out.println(cells);
	    System.out.println();
	    GridTest.printGrid(grid);
	}
	
//	@Test
//	public void gridStuff() {
//	    assertEquals(cells.size(), 3);
//	    assertEquals(game.getGridIcon(2, 3).matches(game.getGridIcon(2, 4)), true);
//	}
	
	@Test
	public void row1() {
		assertTrue(cells.contains(grid[1][11]));
	}
	
	@Test
	public void row2() {
//		myCells.add(getGridIcon(1, 11));
//		assertTrue(cells.containsAll(c))
	}
	
}
