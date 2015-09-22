package exam2;

public class RangeCounter implements Processor {
	
	private int count;
	
	private double min;
	
	private double max;
	
	public RangeCounter(double min, double max) {
		this.min = min;
		this.max = max;
		count = 0;
	}

	public void process(double i) {
		if (i <= max && i >= min) {
			count++;
		}
	}

	public double getResult() {
		return count;
	}

}
