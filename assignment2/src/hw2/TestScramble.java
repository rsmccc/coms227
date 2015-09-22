package hw2;

import java.util.Random;
import util.PermutationGenerator;
import java.io.FileNotFoundException;

public class TestScramble
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
//		System.out.println(test.getScrambledWord());
//		test.moveRight(4, 2);
//		System.out.println(test.getScrambledWord());
		
		Random rand = new Random();
		PermutationGenerator gen = new PermutationGenerator(rand);
		String real = "epsilon";
		String scram = WordScrambler.scramble(real, gen);
		WordPair test = new WordPair(real, scram);
//		System.out.println(test.getRealWord() + " | " + test.getScrambledWord());
		
//		WordPair wp = new WordPair("EGGPLANT", "NTAGPEGL"); 
//		wp.doLetterHint(); 
//		System.out.println(wp.getScrambledWord()); 
//		System.out.println("Expected ETAGPNGL"); 
//		wp.doLetterHint(); 
//		System.out.println(wp.getScrambledWord()); 
//		System.out.println("Expected EGATPNGL"); 
//		System.out.println(wp.getNumLetterHints()); 
//		System.out.println("Expected 2");
		
//		System.out.println(test.isSolutionPossible());
		
		Words w = new Words("words2.txt");
		String myWord = w.getWord(rand);
//		System.out.println(myWord);
		
		String scrambly = WordScrambler.scramble(myWord, gen);
		WordPair t = new WordPair(myWord, scrambly);
		System.out.println(t.getRealWord() + " | " + t.getScrambledWord());
		System.out.println(t.isSolutionPossible());
		System.out.println("Expected: true");

		// millisPerLetter = 5000 (5 seconds)
		// hint penalty = 2 seconds
		// rescramble penalty = 1/10 of a second
		// incorrect guess penalty = 1 second
//		ScoreCalculator sc = new ScoreCalculator(5000, 2000, 100, 1000);
//		sc.start(10); // for a ten-letter word 
//		System.out.println(sc.getPossibleScore(0)); 
//		System.out.println("Expected 50000"); 
//		System.out.println(sc.getPossibleScore(1000)); 
//		System.out.println("Expected 49000");
//		
//		System.out.println(sc.getPossibleScore(20000)); 
//		System.out.println("Expected 30000");
//		sc.applyHintPenalty(); 
//		sc.applyHintPenalty(); 
//		System.out.println(sc.getPossibleScore(0)); 
//		System.out.println("Expected 46000");
		
		
	}
}
