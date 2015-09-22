package lab08;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MileageCalculator 
{
	public static ArrayList<FillUp> list() throws FileNotFoundException
	{
		ArrayList<FillUp> list = new ArrayList<>();
		File input = new File("mileage.txt");
		Scanner in = new Scanner(input);
		while (in.hasNext())
		{
			int odometer = in.nextInt();
			double gallons = in.nextDouble();
			FillUp record = new FillUp(odometer, gallons);
			list.add(record);
		}
		in.close();
		return list; 
	}
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		MileageCalculator.list();
		
		for (int i = 1; i < list().size(); i++)
		{
			System.out.print("Mileage " + i + ": ");
			int milesDriven = list().get(i).getOdometer() - list().get(i - 1).getOdometer();
			double gallons = list().get(i).getGallons();
			double mpg = milesDriven / gallons;
			System.out.println(mpg);
		}
	}

}
