package exam2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exam2Review {
	

	public Exam2Review() {	}
	
	public static String longestWord(String sentence)
	{
		Scanner in = new Scanner(sentence);
		String max = "";
		
		while (in.hasNext())
		{
			String word = in.next();
			if (word.length() > max.length()) {
				max = word;
			}
		}
		in.close();
		return max;
	}
	
	public void arrayDim(int[] input)
	{
		int[][] twoD = {{3, 2, 1}, {1, 2, 3}};
		int[][] another = new int[6][4];
		another[1][1] = 6;
	}
	
	public static void puzzler(int[] arr, int value) {
		int t = arr.length - 1; int i = 0;
		int j = 0;
		
		while (j <= t) {
		if (arr[j] < value) {
			swap(arr, i, j); 
			i += 1;
			j += 1;
		}
		else if (arr[j] > value) {
			swap(arr, j, t);
			t -= 1;
		}
		else { 
			j += 1; }
		System.out.println(Arrays.toString(arr)); }
		}
		
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp;
		} 
	
	public static boolean duplicate(String s) {
		char[] temp = s.toCharArray();
		
		
		boolean duplicate = false;
		
		return duplicate;
	}
	
}
	
	

