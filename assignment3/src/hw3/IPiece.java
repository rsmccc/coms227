package hw3;

import java.awt.Color;

import hw3.api.Position;
import hw3.impl.Block;

/**
 * This class extends AbstractPiece to a straight, three-block piece with randomly generated colors.
 * @author rsmccloskey
 *
 */
public class IPiece extends AbstractPiece {
	
	public IPiece(Position position, Color[] colors) {
		super(position);
		if (colors.length != 3) {
			throw new IllegalArgumentException("Number of colors in Color[] is incorrect. Please use only 3.");
		}
		Block[] blocks = new Block[3];
		blocks[0] = new Block(colors[0], new Position(0, 1));
		blocks[1] = new Block(colors[1], new Position(1, 1));
		blocks[2] = new Block(colors[2], new Position(2, 1));
		initializeBlocks(blocks);
	}
	
}
