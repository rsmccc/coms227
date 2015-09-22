package prob5;

import java.io.File;

public class FileCounter {
	public static int countFiles(File directory) {
	    int sum = 0;
	    if (!directory.isDirectory()) {
	    	return 1;
	    }
	    else {
		    File[] files = directory.listFiles();
		    for (File f : files) {
		        sum += countFiles(f);
		    }
		    return sum;
	    }
	}
}
