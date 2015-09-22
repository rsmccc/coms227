package mini1;

public class Taxi 
{
	private double baseFare;
	
	private double perMileCharge;
	
	private double milesDriven;
	
	/**
	 * Cumulative cash earned by this Taxi in all rides
	 */
	private double cash;
	
	private double meter;
	
	/**
	 * current per-mile rate
	 * equals perMileCharge if ride started, if not, equals 0
	 */
	private double rate;
	
	// TODO
	
	/** 
	 * Constructs a taxi that will use the given base fare and per-mile rate
	 * @param givenBaseFare
	 * 	base fare charged for any ride
	 * @param givenPerMileRate
	 * 	per-mile rate */
	public Taxi(double givenBaseFare, double givenPerMileRate)
	{
		baseFare = givenBaseFare;
		perMileCharge = givenPerMileRate;
		milesDriven = 0;
		cash = 0;
		meter = 0;
		rate = 0;
	}
	
	public void startRide()
	{
		meter = baseFare;
		rate = perMileCharge;
	}
	
	public void endRide()
	{
		cash += meter;
		meter = 0;
		rate = 0;
	}
	
	public void drive(double miles)
	{
		milesDriven += miles;
		meter += rate*miles;
	}
	
	public double getTotalMiles()
	{
		return milesDriven;
	}
	
	public double getTotalCash()
	{
		return cash;
	}
	
	public double getMeter()
	{
		return meter;
	}
	
	public double getCurrentRate()
	{
		return rate;
	}
	
	public double getAverageIncomePerMile()
	{
		return cash/milesDriven;
	}
}
