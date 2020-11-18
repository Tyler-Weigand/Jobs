
import java.util.*;
import java.io.*;

public class HiLoStress {
	public static void main(String[] args) throws IOException {
		final String FILENAME = "jobs 2.txt";
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
		String i1 = "";
		String i2 = "";
		//first two days
		payouts[1] = low[1];
		i2 = "l";
		if (high[2] > low[1] + low[2]) {
			payouts[2] = high[2];
			i1 = "_h";
		} else {
			payouts[2] = low[1] + low[2];
			i1 = "ll";
		}
		String temp = "";
		for (int i=3; i<=n; i++) {
			temp = i1;
			int highRoute = high[i] + payouts[i-2];
			int lowRoute = low[i] + payouts[i-1];
			if (highRoute>lowRoute) {
				payouts[i] = highRoute;
				i1 = i2 + "_h";
			} else {
				payouts[i] = lowRoute;
				i1 += "l";
			}
			i2 = temp;
		}
		System.out.println(payouts[n]);
		System.out.println(i1);
	}
}
