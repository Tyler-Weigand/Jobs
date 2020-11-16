
public class HiLoStress {
	public static void main(String[] args) {
		final String FILENAME = "jobs.txt";
		
		
		int size = 5;
		int[] low = new int[size];
		int[] high = new int[size];
		int[] payouts = new int[size+1];
		
		payouts[0] = high[0];
		payouts[1] = low[0]+high[1];
		for(int i = 2; i < size; i++) {
			int highRoute = high[i]+low[i-1]+payouts[i-2];
			int lowRoute = low[i]+payouts[i-1];
			if(highRoute>lowRoute) {
				payouts[i] = highRoute;
			}
			else {
				payouts[i] = lowRoute;
			}
		}
		System.out.println(payouts[size-1]);
	}
}
