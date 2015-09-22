package lab4;

import java.util.Scanner;

public class Bibliography {
	public static void main(String[] args) {

		String s1 = "Dijkstra, Edsger#Go To Statement Considered Harmful#Communications of the ACM#1968#11";
		String s2 = "Levoy, Marc#Display of Surfaces from Volume Data#IEEE Computer Graphics and Applications#1988#8";
		String s3 = "Dean, Jeffrey; Ghemawat, Sanjay#MapReduce: Simplified Data Processing on Large Clusters#Communications of the ACM#2008#51";
		
		BibItem b1 = myHelperMethod(s1);
		BibItem b2 = myHelperMethod(s2);
		BibItem b3 = myHelperMethod(s3);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
	}

	public static BibItem myHelperMethod(String s)

	// parse the given string s and return a new BibItem

	{

		String authors;
		String title;
		String journal;
		int year;
		int volume;
		Scanner scanner1 = new Scanner(s);
		scanner1.useDelimiter("#");
		authors = scanner1.next();
		title = scanner1.next();
		journal = scanner1.next();
		year = scanner1.nextInt();
		volume = scanner1.nextInt();

		return new BibItem(authors, title, journal, year, volume);

	}

	
	
}
