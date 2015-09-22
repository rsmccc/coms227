package mini3;

/**
 * Transformation implementing a smoothing operation
 * on cells of an array.  The new value is the 
 * average of the values in a neighborhood
 * around a given cell, rounded to the nearest
 * integer. The size of the neighborhood is 
 * 2 * radius + 1, where the radius is a parameter
 * provided to the constructor. Values are not wrapped.
 */
public class SmoothingTransform implements ITransform
{
  private int radius;
  
  public SmoothingTransform(int givenRadius)
  {
	radius = givenRadius; 
  }
  
  @Override
  public int apply(int[][] elements)
  {
	int dim = 2 * radius + 1;
	if (elements.length != dim || elements[0].length != dim) {
		throw new IllegalArgumentException("Width or height of the array does "
				+ "not equal 2 * radius + 1!");
	}
	int s = 0 - elements[getRadius()][getRadius()];
	for (int i = 0; i < elements.length; i++) {
		for (int j = 0; j < elements[0].length; j++) {
			s += elements[i][j];
		}
	}
	int avg = s / (dim * dim - 1);
    return avg;
  }

  @Override
  public int getRadius()
  {
    return radius;
  }

  @Override
  public boolean isWrapped()
  {
    return false;
  }

}
