
import java.util.*;
import java.io.*;

public class HiLoStress {
		final String FILENAME = "jobs.txt";
		File text = new File(FILENAME);

		Scanner s = new Scanner(text);
		int n = s.nextInt();
		int[] high = new int[n];
		int[] low = new int[n];
		for (int i = 0; i<n ; i++) {
			low[i] = s.nextInt();
			high[i] = s.nextInt();
		}
		s.close();
	}
}
