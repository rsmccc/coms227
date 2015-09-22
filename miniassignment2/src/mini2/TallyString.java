package mini2;

public class TallyString
{
	public static final char LINE = '|';
	
	public static final char STAR = '*';
	
	public static final int STAR_VALUE = 5;
	
	private static final int LINE_VALUE = 1;
	
	public static int evaluateGroup(String group)
	{
		if (!isValidGroup(group))
		{
			return -1;
		}
		if (group.equals("0"))
		{
			return 0;
		}
		
		int sum = 0;
		for (int i = 0; i < group.length(); i++)
		{
			if (group.charAt(i) == LINE)
			{
				sum += LINE_VALUE;
			}
			else
			{
				sum += STAR_VALUE;
			}
		}
		return sum;
	}
	
	public static int evaluateString(String s)
	{
		
		int sum = 0;
		s = s.trim();
		if (s.equals(""))
		{
			return -1;
		}
		int end = s.length();
		int groupIndex = 0;
		for (int i = s.length() - 1; i >= 0; i--)
		{
			if ((s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') || i == 0)
			{
				String group = s.substring(i, end).trim();
				if (isValidGroup(group))
				{
					sum += (evaluateGroup(group) * (int)Math.pow(10, groupIndex));
					groupIndex++;
					end = i;
				}
				else
				{
					return -1;
				}
			}
		}
		return sum;
	}
	
	public static boolean isValidGroup(String s)
	{
		if (s.equals("0"))
		{
			return true;
		}
		for (int i = 0; i < s.length(); i++)
		{
			if (!(s.charAt(i) == LINE || s.charAt(i) == STAR))
			{
				return false;
			}
		}
		if (s.length() > 1 && s.contains("0"))
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	public static String makeGroup(int givenValue)
	{
		if (givenValue < 0)
		{
			return null;
		}
		if (givenValue == 0)
		{
			return "0";
		}
		int stars = givenValue / 5;
		int lines = givenValue % 5;
		String group = "";
		for (int i = 0; i < stars; i++) {
			group += STAR;
		}
		for (int i = 0; i < lines; i++)
		{
			group += LINE;
		}
		return group;
	}
	
	public static String makeNormalizedString(int givenValue)
	{
		if (givenValue < 0)
		{
			return null;
		}
		String numValue = "" + givenValue;
		System.out.println("thissss: " + numValue);
		String normal = "";
		for (int i = 0; i < numValue.length(); i++)
		{
			int num = Character.getNumericValue(numValue.charAt(i));
			if (num == 0)
			{
				normal += "0";
			}
			if (num >= STAR_VALUE)
			{
				normal += STAR;
			}
			
			for (int lines = 0; lines < num % 5; lines++)
			{
				normal += LINE;
			}
			normal += " ";
		}
		normal = normal.trim();
		return normal;
	}
}
