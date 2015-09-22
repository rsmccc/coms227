package practice;
import java.util.Random;

public class Exam1Review
{
	
	public static String createID(String firstName, String lastName)
	{
		Random rand = new Random();
		int index = rand.nextInt(49) + 1;
		String result = firstName.toLowerCase().charAt(0) + lastName.toLowerCase() + index;
		return result;
	}
	
 
	
	
	
	
	public static void main(String[] args)
	{
		int j = 13;
		System.out.println(j / 3);
		System.out.println(j % 3);
		System.out.println(j / 10.0);
		System.out.println("");
		
		String ry = createID("Riley", "McCloskey");
		System.out.println(ry);
		
		
		
	}
	
	

}
