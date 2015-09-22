package hw1;

import java.util.Random;

public class IdGenerator
{
	public IdGenerator()
	{
		
	}
	
	
	
	public static String createID(String firstName, String lastName)
	{
		Random rand = new Random();
		int index = rand.nextInt(49) + 1;
		String result = firstName.toLowerCase().charAt(0) + lastName.toLowerCase() + index;
		return result;
	}

}
