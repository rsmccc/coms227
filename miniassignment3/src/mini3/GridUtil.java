package mini3;

/**
 * Utility class for applying transformations to 2d arrays.
 * A transformation computes a new value for a cell that is
 * based on the square neighborhood of cells that surround it.
 * Each transformation is an implementation of 
 * the ITransform interface.
 */
public class GridUtil
{
  /**
   * Applies the given transformation to all cells of the given
   * array and produces a new array of the same size.  The original
   * array is not modified.
   * @param arr
   *   given array
   * @param transform
   *   transformation to apply
   * @return
   *   new array consisting of transformed values
   */
  public static int[][] applyAll(int[][] arr, ITransform transform)
  {
    int numRows = arr.length;
    int numCols = arr[0].length;
    int[][] result = new int[numRows][numCols];
    for (int row = 0; row < numRows; row += 1)
    {
      for (int col = 0; col < numCols; col += 1)
      {
        int[][] subArray = getSubArray(arr, row, col, transform.getRadius(), transform.isWrapped());
        int newValue = transform.apply(subArray);
        result[row][col] = newValue;
      }
    }
    return result;
  }
  
  /**
   * Returns the neighborhood surrounding the specified cell.  In general,
   * the returned array is a square sub-array of <code>arr</code>, 
   * with width and height 2 * <code>radius</code> - 1, whose center is 
   * <code>arr[centerRow][centerCol]</code>.  For cells within
   * <code>radius</code> of the edge, the value for out-of-range
   * indices is determined by
   * the <code>wrapped</code> parameter, as follows:
   * <ul>
   * <li>if <code>wrapped</code> is false, cells for out-of-range indices
   * are filled with zeros
   * <li>if <code>wrapped</code> is true, cells for out-of-range indices
   * are determined by "wrapping" the indices:
   * <ul>
   * <li>for a row index, the array height is added to or subtracted from the index
   * to bring it within range
   * <li>for a column index, the array width is added to or subtracted from
   * the index to bring it within range
   * </ul>
   * </ul>
   * Note that the size of neighborhood, neighborhood size 2 * <code>radius</code> + 1, 
   * is not allowed to be greater than either the width or height of the given array.
   * @param arr
   *   the original array
   * @param centerRow
   *   row index of center cell
   * @param centerCol
   *   column index of center cell
   * @param radius
   *   radius of the neighborhood (return array has width and height
   *   equal to 2 * <code>radius</code> + 1
   * @param wrapped
   *   true if out-of-range indices should be wrapped, false if cells
   *   should be filled with zeros
   * @return
   *   a new 2d array consisting of the cells surrounding the given center
   *   cell
   * @throws IllegalArgumentException
   *   if the neighborhood size 2 * <code>radius</code> + 1 is greater
   *   than the given array's width or height
   */
  public static int[][] getSubArray(int[][] arr, int centerRow, int centerCol, int radius, boolean wrapped)
  {
	int newDim = 2 * radius + 1;
	int[][] subArr = new int[newDim][newDim];
	
	if (newDim > arr.length) { throw new IllegalArgumentException("Neighborhood size is greater than the array's height."); }
	if (newDim > arr[0].length) { throw new IllegalArgumentException("Neighborhood size is greater the array's width."); }
	if (centerRow < 0 || centerRow >= arr.length || centerCol < 0 || centerCol >= arr[0].length) { 
		throw new IllegalArgumentException("Center cell is outside of the range of the array");
	}
	
	if (wrapped) {
		for (int i = 0; i < newDim; i++) {
			for (int j = 0; j < newDim; j++) {
				int row = centerRow - radius + i;
				int col = centerCol - radius + j;
				if (centerRow - radius + i < 0) {
					row += arr.length;
				}
				else if (centerRow + i - radius >= arr.length) {
					row -= arr.length;
				}
				if (centerCol - radius + j < 0) {
					col += arr[0].length;
				}
				else if (centerCol + j - radius >= arr[0].length) {
					col -= arr[0].length;
				}
				subArr[i][j] = arr[row][col];
			}
		}
	}
	
	else {
		for (int i = 0; i < newDim; i++) {
			for (int j = 0; j < newDim; j++) {
				if (centerRow - radius + i < 0) {
					subArr[i][j] = 0;
				}
				else if (centerRow + i - radius >= arr.length) {
					subArr[i][j] = 0;
				}
				else if (centerCol - radius + j < 0) {
					subArr[i][j] = 0;
				}
				else if (centerCol + j - radius >= arr[0].length) {
					subArr[i][j] = 0;
				}
				else {
					subArr[i][j] = arr[centerRow - radius + i][centerCol - radius + j];
				}
			}
		}
	}
	return subArr;
  }
}
