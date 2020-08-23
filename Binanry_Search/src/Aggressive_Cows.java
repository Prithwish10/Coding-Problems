import java.util.Arrays;
import java.util.Scanner;
public class Aggressive_Cows {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int stols[] = new int[n];
		System.out.println("Enter the numbers into the array :");
		
		for(int i = 0; i < n; i++)
			stols[i] = sc.nextInt();
		
		System.out.println("Enter the number of cows :");
		int cows = sc.nextInt();
		
		int minDis = findMinimumDistance(stols, n, cows);
		System.out.println(minDis);
	}
	public static int findMinimumDistance(int stols[], int n, int cows) {
		
		Arrays.sort(stols);
		int L = 0;
		int H = stols[n - 1] - stols[0];
		int minDis = -1;
		while(L <= H) {
			
			int mid = L + (H - L)/2;
			
			if(check(stols, mid, cows)) {
				minDis = mid;
				L = mid + 1;
			}
			else {
				H = mid - 1;
			}
		}
		return minDis;
	}
	private static boolean check(int stols[], int dis, int cows) {
		
		int count = 1;
		int start = 0;
		for(int i = 1; i < stols.length; i++) {
			
			if(stols[i] - stols[start] >= dis) {
				
				count ++;
				start = i;
				
				if(count == cows)
					break;
			}
		}
		if(count == cows)
			return true;
		return false;
	}
}
