package mini3;

/**
 * Transformation implementing Conway's Game of Life.
 * All cells have value 0 or 1. The new value is based on the center 
 * cell along with the sum S of its eight neighbors, according to 
 * the rules:
 * <ul>
 *   <li>if S < 2 the result is 0
 *   <li>if the center cell is 1 and S is 2 or 3, the result is 1
 *   <li>if S > 3 the result is 0
 *   <li>if the center cell is 0 and S is exactly 3, the result is 1
 * </ul>
 * See
 * http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 *
 * <p>
 * The radius is 1 and the wrapping behavior is true.
 */
public class ConwayTransform implements ITransform
{

  @Override
  public int apply(int[][] elements)
  {
	// Should I change elements[r][r] to the resulting value? Or no because accessors shouldn't change the state of the object?
	int s = 0 - elements[getRadius()][getRadius()];
	int dim = 2 * getRadius() + 1;
	int result = elements[getRadius()][getRadius()];
	
	if (elements.length != dim || elements[0].length != dim) {
		throw new IllegalArgumentException("Neighborhood width or height is not equal to '2 * getRadius() - 1'");
	}
	
	for (int i = 0; i < elements.length; i++) {
		for (int j = 0; j < elements[0].length; j++) {
			s += elements[i][j];
		}
	}
	
	if (s < 2) { result = 0;}
	else if (s > 3) { result = 0; }
	else if (elements[getRadius()][getRadius()] == 1 && (s == 2 || s == 3)) { result = 1;	}
	else if (elements[getRadius()][getRadius()] == 0 && s == 3) { result = 1;	}
	return result;
  }

  @Override
  public int getRadius()
  {
    return 1;
  }

  @Override
  public boolean isWrapped()
  {
    return true;
  }
  
}
