package mini1;

public class TaxiTest 
{
	public static void main(String[] args)
	{
		Taxi ry = new Taxi(1, 20);
		
		ry.startRide();
		
		ry.drive(8000);
		
		System.out.println("$" + ry.getMeter());
		
		ry.endRide();
		
		ry.drive(8000);
		
		System.out.println(ry.getTotalMiles() + " miles driven");
		
		System.out.println("$" + ry.getTotalCash());
		
		System.out.println("$" + ry.getAverageIncomePerMile() + " on average");
	}
}
