package exam2;

import java.util.Arrays;

public class MainTest {
	public static void main(String[] args) {
//		System.out.println(Exam2Review.longestWord("Hello there how are you today Alexander"));
		
		int[] arr = {1, 3, 5, 7, 9};
		
		System.out.println(Arrays.toString(arr));
		
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[arr.length - 1 - i] = arr[i];
		}
		arr = temp;
		
		System.out.println(Arrays.toString(arr));
		
//		System.out.println("PROBLEM 6*****");
//		int[] puzzle = {6, 7, 7, 9, 2, 7, 8, 5};
//		Exam2Review.puzzler(puzzle, 7);
		
		System.out.println("\n(g)\n");
		
		String s = "abcdefgghijkl";
	}
	

}
