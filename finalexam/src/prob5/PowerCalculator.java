package prob5;

public class PowerCalculator {
	
	public static int pow(int x, int p) {
	    if (p == 0) {
	        return 1;
	    }
	    else {
	        if (p % 2 == 0) {
	        	int result = pow(x, p / 2);
	            return result * result;
	        }
	        else {
	        	int result = pow(x, (p - 1) / 2); 
	        	return x * result * result;
	        }
	    }
	}

}
