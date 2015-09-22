package exam2;

public class MaxProcessor implements Processor {
	
	private double max;
	
	public void process(double i) {
		max = Math.max(i, max);
	}
	
	public double getResult() {
		return max;
	}

	
}
