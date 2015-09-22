package hw3;

import java.awt.Color;

import hw3.api.Position;
import hw3.impl.Block;

/**
 * This class extends AbstractPiece to create a four-block piece with randomly generated colors.
 * @author rsmccloskey
 *
 */
public class LPiece extends AbstractPiece {
	
	public LPiece(Position position, Color[] colors) {
		super(position);
		if (colors.length != 4) {
			throw new IllegalArgumentException("Number of colors in Color[] is incorrect. Please use only 4.");
		}
		Block[] blocks = new Block[4];
		blocks[0] = new Block(colors[0], new Position(0, 0));
		blocks[1] = new Block(colors[1], new Position(0, 1));
		blocks[2] = new Block(colors[2], new Position(1, 1));
		blocks[3] = new Block(colors[3], new Position(1, 2));
		initializeBlocks(blocks);
	}
	
	

}
