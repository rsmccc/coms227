package hw3;

import java.awt.Color;
import java.util.Random;

import hw3.api.*;
import hw3.impl.AbstractBlockGame;

/**
 * This class implements IPolyominoGenerator to create instances of the three concrete types that extend AbstractPiece.
 * @author rsmccloskey
 *
 */
public class BasicGenerator implements IPolyominoGenerator {
	
	/**
	 * Given instance of random number generator
	 */
	private Random rand;
	
	public BasicGenerator(Random rand) {
		this.rand = rand;
	}
	
	@Override
	public IPolyomino getNext() {

		int index = rand.nextInt(10);
		IPolyomino result = null;
		if (index < 6) {
			result = new IPiece(new Position(-2, 5), getColors(3));
		}
		else if (index > 7) {
			result = new DiagonalPiece(new Position(-1, 5), getColors(2));
		}
		else if (index >= 6 && index <= 7) {
			result = new LPiece(new Position(-2, 5), getColors(4));
		}
		return result;
	}
	
	/**
	 * Randomly selects an array of colors from the colors in AbstractBlockGame
	 * @param 
	 * 	number of colors to be returned in array
	 * @return
	 * 	an array of randomly selected colors
	 */
	private Color[] getColors(int numColors) {
		Color[] colors = new Color[numColors];
		for (int i = 0; i < numColors; i++) {
			colors[i] =  getColor();
		}
		//TODO TEST!
		return colors;
	}
	
	/**
	 * Selects a color randomly from the colors in AbstractBlockGame
	 * @return
	 * 	a randomly selected Color
	 */
	private Color getColor() {
		Color[] choices = AbstractBlockGame.COLORS;
		int length = choices.length;
		Color color = choices[rand.nextInt(length)];
		// generate random index to choose a color from AbstractBlockGame
		return color;
	}

}
