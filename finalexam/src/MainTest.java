import java.io.File;

import prob5.FileCounter;
import prob5.PowerCalculator;


public class MainTest {
	
	public static void main(String[] args) {
		System.out.println(PowerCalculator.pow(2, 3));
		
		System.out.println(FileCounter.countFiles(new File("/Users/rsmccloskey/Desktop")));
	}

}
