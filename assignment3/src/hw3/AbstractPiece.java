
package hw3;

import hw3.api.*;
import hw3.impl.*;


/**
 * @author rsmccloskey
 * This abstract class implements the IPolyomino interface and provides 
 * several methods for the three different Pieces in the Block Game.
 */
public abstract class AbstractPiece implements IPolyomino
{	
	private Block[] blocks;
	
	private Position pos;
				
	public AbstractPiece(Position initialPosition) {
		pos = new Position(initialPosition);
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public void initializePosition(Position givenPosition) {
		pos = new Position(givenPosition);
	}
	
	public void initializeBlocks(Block[] givenBlocks) {
		blocks = givenBlocks;
	}
	
	public Block[] getBlocks() {
		Block[] result = new Block[blocks.length];
		for (int i = 0; i < blocks.length; i++) {
			result[i] = new Block(blocks[i]);
			int c = blocks[i].getPosition().getCol() + pos.getCol();
			int r = blocks[i].getPosition().getRow() + pos.getRow();
			result[i].setPosition(new Position(r, c));
		}
		return result;
	}
	
	public void shiftDown() {
		pos.setRow(pos.getRow() + 1);
	}
	
	public void shiftLeft() {
		pos.setCol(pos.getCol() - 1);
	}
	
	public void shiftRight() {
		pos.setCol(pos.getCol() + 1);
	}
	
	public void cycle() {
		Position temp = blocks[0].getPosition();
		for (int i = 0; i < blocks.length - 1; i++) {
			blocks[i].setPosition(blocks[i + 1].getPosition());
		}
		blocks[blocks.length - 1].setPosition(temp);
	}
	
	public void transform() {
		int max = blocks.length - 1;
		for (int i = 0; i < blocks.length; i++) {
			int newCol = max - blocks[i].getPosition().getCol();
			blocks[i].getPosition().setCol(newCol);
		}
	}
  
  /**
   * Returns a deep copy of this object.
   * 
   * @return 
   *   a deep copy of this object.
   */
  public IPolyomino clone()
  {
    // The built-in cloning mechanism of the Java runtime will
    // create an object of the correct runtime type.
    AbstractPiece cloned = null;
    try
    {
      cloned = (AbstractPiece) super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen in this case
    }
    
    cloned.pos = new Position(pos);
    cloned.blocks = new Block[blocks.length];
    for (int i = 0; i < blocks.length; i++) {
    	cloned.blocks[i] = new Block(blocks[i]);
    }
    
    return cloned;
  }

}
