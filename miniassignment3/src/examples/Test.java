package examples;

import mini3.GridUtil;

public class Test {
	public static void main(String[] args) {
		
//		int[][] arr = new int[3][8];
		
		int arr[][] = {
				{0,0,0,0,0},
				{1,1,1,1,1},
				{2,2,2,2,2},
				{3,3,3,3,3},
				{4,4,4,4,4}
		};
		
		int[][] test = { 
				{1, 2, 3, 4, 5, 6, 7, 8},
				{4, 4, 4, 4, 9, 9, 9, 9},
				{4, 3, 2, 1, 0, 0, 0, 0},
				{1, 2, 3, 4, 5, 6, 7, 8},
				{4, 4, 4, 4, 9, 9, 9, 9},
				{4, 3, 2, 1, 0, 0, 0, 0},
				{4, 3, 2, 2, 7, 7, 7, 7}
				};
		
//		System.out.println(test.length);
//		for (int i = 0; i < test.length; i++) {
//			for (int j = 0; j < test[0].length; j++) {
//				System.out.printf("%8d", test[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		int[][] subtest = GridUtil.getSubArray(test, 2, 3, 2, true);
//		
//		for (int i = 0; i < subtest.length; i++) {
//			for (int j = 0; j < subtest[0].length; j++) {
//				System.out.printf("%8d", subtest[i][j]);
//			}
//			System.out.println();
//		}
		
		LifeTest.printArray(arr);
		System.out.println("");
		
		LifeTest.printArray(GridUtil.getSubArray(arr, 3, 1, 2, true));
		
		
	}
}
