import java.util.Arrays;
import java.util.Scanner;
public class Rod_Cutting {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the length of the rod :");
		int n = sc.nextInt();
		
		int prices[] = new int[n];
		
		System.out.println("Enter the prices :");
		for(int i = 0; i < n; i++)
			prices[i] = sc.nextInt();
		
		int length[] = new int[n];
		
		for(int i = 0; i < n; i++)
			length[i] = i + 1;
		
		int res = findMaxPrice(prices, length, n, n);
		System.out.println(res);
		
		int cache[][] = new int[n + 1][n + 1];
		
		for(int[] i : cache)
			Arrays.fill(i, -1);
		
		int res1 = findMaxPrice1(prices, cache, length, n, n);
		System.out.println(res1);
	}
	public static int findMaxPrice(int prices[], int length[], int N, int n) {
		
		//If there is no rod then price will be 0
		if(N <= 0 || n == 0)
			return 0;
		//If the length of the price is greater then N (total length) then do not include that piece 
		//and recur for next n - 1 pieces
		if(length[n - 1] > N)
			return findMaxPrice(prices, length, N, n - 1);
		
		return Math.max(prices[n - 1] + findMaxPrice(prices, length, N - length[n - 1], n), 
				findMaxPrice(prices, length, N, n - 1));
		
	}
	
	public static int findMaxPrice1(int prices[], int cache[][], int length[], int N, int n) {
		
		//If there is no rod then price will be 0
		if(N <= 0 || n == 0)
			return cache[n][N] = 0;
		
		if(cache[N][n] != -1)
			return cache[n][N];
		//If the length of the price is greater then N (total length) then do not include that piece 
		//and recur for next n - 1 pieces
		if(length[n - 1] > N)
			return cache[n][N] = findMaxPrice1(prices, cache, length, N, n - 1);
		
		return cache[n][N] = Math.max(prices[n - 1] + findMaxPrice1(prices, cache, length, N - length[n - 1], n), 
				findMaxPrice1(prices, cache, length, N, n - 1));
		
	}
}
