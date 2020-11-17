
import java.util.*;
import java.io.*;

public class HiLoStress {
	public static void main(String[] args) throws IOException {
		final String FILENAME = "jobs.txt";
		File text = new File(FILENAME);

		Scanner s = new Scanner(text);
		int n = s.nextInt();
		int[] high = new int[n+1];
		int[] low = new int[n+1];
		for (int i = 1; i<=n ; i++) {
			low[i] = s.nextInt();
			high[i] = s.nextInt();
		}
		s.close();
		

		int[] payouts = new int[n+1];
		//first two days
		payouts[1] = low[1];
		if (high[2] > low[1] + low[2]) {
			payouts[2] = high[2];
		} else {
			payouts[2] = low[1] + low[2];
		}
		for (int i=3; i<=n; i++) {
			int highRoute = high[i] + payouts[i-2];
			int lowRoute = low[i] + payouts[i-1];
			if (highRoute>lowRoute) {
				payouts[i] = highRoute;
			} else {
				payouts[i] = lowRoute;
			}
		}
		System.out.println(payouts[n]);
	}
}
