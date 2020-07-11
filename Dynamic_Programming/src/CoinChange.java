import java.util.Arrays;
import java.util.Scanner;
public class CoinChange {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of coins that are available :");
		int n = sc.nextInt();
		 
		System.out.println("Enter the coins :");
		int coins[] = new int[n];
		
		for(int i = 0; i < n; i++)
			coins[i] = sc.nextInt();
		
		System.out.println("Enter the sum :");
		int sum = sc.nextInt();
		
		int res = findWaysToChangeCoins(coins, sum, n);
		
		System.out.println(res);
		
		int cache[][] = new int[n + 1][sum + 1];
		
		for(int i[] : cache)
			Arrays.fill(i, -1);
		
		System.out.println(findWaysToChangeCoins_Memo(coins, cache, sum, n));
	}
	public static int findWaysToChangeCoins(int coins[], int sum, int n) {
		
		if(sum == 0)
			return 1;
		
		if(n == 0 )
			return 0;
		if(coins[n - 1] > sum)
			return findWaysToChangeCoins(coins, sum, n - 1);
		
		return findWaysToChangeCoins(coins, sum - coins[n - 1], n) + findWaysToChangeCoins(coins, sum, n - 1);
	}
	
	public static int findWaysToChangeCoins_Memo(int coins[], int cache[][], int sum, int n) {
		
		if(sum == 0)
			return cache[n][sum] = 1;
		
		if(n == 0 )
			return cache[n][sum] = 0;
		
		if(cache[n][sum] != -1)
			return cache[n][sum];
		
		if(coins[n - 1] > sum)
			return cache[n][sum] = findWaysToChangeCoins_Memo(coins, cache, sum, n - 1);
		
		return cache[n][sum] = findWaysToChangeCoins_Memo(coins, cache, sum - coins[n - 1], n) + 
				findWaysToChangeCoins_Memo(coins, cache, sum, n - 1);
	}
}
