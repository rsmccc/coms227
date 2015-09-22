package hw2;

public class TestMe
{
	public static void main(String[] args)
	{
		String r = "nirnugn";
		WordPair t = new WordPair("running", r);
//		System.out.println(t.getRealWord() + " | " + t.getScrambledWord());
//		System.out.println(t.isSolutionPossible());
//		System.out.println("Expected: true");
		System.out.println(r);
		t.doLetterHint();
		System.out.println(t.getScrambledWord());
		t.doLetterHint();
		System.out.println(t.getScrambledWord());
		t.doLetterHint();
		System.out.println(t.getScrambledWord());
	}

}
