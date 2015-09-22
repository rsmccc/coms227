//import hw3.api.Position;
//import hw3.impl.GridCell;
//
//import java.util.ArrayList;
//
////import java.util.ArrayList;
////
////import hw3.*;
////import hw3.api.*;
////import hw3.impl.*;
//
////public class SloppyTests extends AbstractBlockGame {
////	
////	protected SloppyTests(IPolyominoGenerator generator) {
////		super(generator);
////		// TODO Auto-generated constructor stub
////	}
////	
////	public GridCell getGridIcon(int x, int y) {
////		return null;
////	}
//
////	public static void main(String[] args)  {
////		int row = 0;
////		int col = 1;
////		
////		Position[] relPos = new Position[5];
////		relPos[0] = new Position(row, col);
////		relPos[1] = new Position(row - 1, col);
////		relPos[2] = new Position(row + 1, col);
////		relPos[3] = new Position(row, col - 1);
////		relPos[4] = new Position(row, col + 1);
////		GridCell[] rel = new GridCell[5];
////		rel[0] = getGridIcon(row, col);
////		rel[1] = getGridIcon(row - 1, col);
////		rel[2] = getGridIcon(row + 1, col);
////		rel[3] = getGridIcon(row, col - 1);
////		rel[4] = getGridIcon(row, col + 1);
////		
////		
////		ArrayList<Position> relPos = new ArrayList<>();
////		ArrayList<GridCell> rel = new ArrayList<>();
////		
////		
////		try {
////			relPos.add(new Position(row - 1, col));
////			rel.add(getGridIcon(row - 1, col));
////		}
////		catch (ArrayIndexOutOfBoundsException exception) {
////			System.out.println("Array Index Out of Bounds: " + exception.getMessage());
////			relPos.remove(relPos.size() - 1);
////	//		exception.printStackTrace();
////		}
////		try {
////			relPos.add(new Position(row + 1, col));
////			rel.add(getGridIcon(row + 1, col));
////		}
////		catch (ArrayIndexOutOfBoundsException exception) {
////			System.out.println("Array Index Out of Bounds: " + exception.getMessage());
////			relPos.remove(relPos.size() - 1);
////		}
////		try {
////			relPos.add(new Position(row, col - 1));
////			rel.add(getGridIcon(row, col - 1));
////		}
////		catch (ArrayIndexOutOfBoundsException exception) {
////			System.out.println("Array Index Out of Bounds: " + exception.getMessage());
////			relPos.remove(relPos.size() - 1);
////		}
////		try {
////			relPos.add(new Position(row, col + 1));
////			rel.add(getGridIcon(row, col + 1));
////		}
////		catch (ArrayIndexOutOfBoundsException exception) {
////			System.out.println("Array Index Out of Bounds: " + exception.getMessage());
////			relPos.remove(relPos.size() - 1);
////		}
////	
////	}
////
////	@Override
////	public ArrayList<Position> determineCellsToCollapse() {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////	@Override
////	public int determineScore() {
////		// TODO Auto-generated method stub
////		return 0;
////	}
////}
//
//if (!isRowEmpty(i)) {
//					int row = i;
//					int col = j;
//					if (getGridIcon(row, col) != null) {
//						
//						ArrayList<Position> relPos = new ArrayList<>();
//						ArrayList<GridCell> rel = new ArrayList<>();
//						
//						// GridCell in focus
//						Position fPos = new Position(row, col); 
//						relPos.add(fPos);
//						GridCell fCell = getGridIcon(fPos.getRow(), fPos.getCol());
//						rel.add(fCell);
//						
//						// Above
//	//					try {
//							if (getGridIcon(row - 1, col) == null || i == 0) {
//								// Nothing
//							}
//							else {
//								relPos.add(new Position(row - 1, col));
//								rel.add(getGridIcon(row - 1, col));
//							}
//	//					}
//	//					catch (ArrayIndexOutOfBoundsException exception) {
//	//						System.out.println("ABOVE - Array Index Out of Bounds: " + exception.getMessage());
//	//						exception.printStackTrace(System.out);
//	//					}
//						// Below
////						try {
//							if (getGridIcon(row + 1, col) == null || i == getWidth() - 1) {
//								//Nothing
//							}
//							else {
//								relPos.add(new Position(row + 1, col));
//								rel.add(getGridIcon(row + 1, col));
//							}
////						}
////						catch (ArrayIndexOutOfBoundsException exception) {
////							System.out.println("BELOW - Array Index Out of Bounds: " + exception.getMessage());
////							exception.printStackTrace(System.out);
////						}
//						// Left
////						try {
//							if (getGridIcon(row, col - 1) == null || j == 0) {
//								// Nothing
//							}
//							else {
//								relPos.add(new Position(row, col - 1));
//								rel.add(getGridIcon(row, col - 1));
//							}
////						}
////						catch (ArrayIndexOutOfBoundsException exception) {
////							System.out.println("LEFT - Array Index Out of Bounds: " + exception.getMessage());
////							exception.printStackTrace(System.out);
////						}
//						// Right
////						try {
//							if (getGridIcon(row, col + 1) == null || j == getWidth() - 1) {
//								// Nothing
//							}
//							else {
//								relPos.add(new Position(row, col + 1));
//								rel.add(getGridIcon(row, col + 1));
//							}
////						}
////						catch (ArrayIndexOutOfBoundsException exception) {
////							System.out.println("RIGHT - Array Index Out of Bounds: " + exception.getMessage());
////							exception.printStackTrace(System.out);
////						}
//		
//						ArrayList<Position> neighbors = new ArrayList<>();
//						
//						for (int cell = 1; cell < rel.size(); cell++) {
//							if (fCell.matches(rel.get(cell))) { 
//								neighbors.add(relPos.get(cell)); 
//								}
//						}
//						
//						if (neighbors.size() >= 2) {
//							neighbors.add(fPos);
//							cellsToCollapse.addAll(neighbors);
//							neighbors.clear();
//						}

//						r = focus.getRow() - 1;
//						GridCell above = getGridIcon(r, c); 
//						
//						r = focus.getRow() + 1;
//						GridCell below = getGridIcon(r, c);
//						
//						r = focus.getRow();
//						c = focus.getCol() - 1;
//						GridCell left = getGridIcon(r, c);
//						
//						c = focus.getCol() + 1;
//						GridCell right = getGridIcon(r, c);