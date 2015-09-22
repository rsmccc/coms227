package hw3;

import java.awt.Color;

import hw3.api.*;
import hw3.impl.Block;

/**
 * This class extends AbstractPiece to create a two-block piece with randomly generated colors. 
 * @author rsmccloskey
 *
 */
public class DiagonalPiece extends AbstractPiece  {
	
	public DiagonalPiece(Position position, Color[] colors) {
		super(position);
		if (colors.length != 2) {
			throw new IllegalArgumentException("Number of colors in Color[] is incorrect. Please use only 2.");
		}
		Block[] blocks = new Block[2];
		blocks[0] = new Block(colors[0], new Position(0, 0));
		blocks[1] = new Block(colors[1], new Position(1, 1));
		initializeBlocks(blocks);
	}

	
	

}
