import java.util.Arrays;
import java.util.Scanner;
public class CoinChange_MinimumWays {

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
			
			int res = findWaysToChangeCoins(coins, sum, n, 0);
			
			System.out.println(res);
			
			int cache[][] = new int[n + 1][sum + 1];
			
			for(int i[] : cache)
				Arrays.fill(i, -1);
			//Arrays.sort(coins);
			//System.out.println(findWaysToChangeCoins_Memo(coins, cache, sum, n, 0));
			
			fewestCoin(coins, n, sum);
			fewestCoin_SpaceOPT(coins, n, sum);
	}
	public static int findWaysToChangeCoins(int coins[], int sum, int n, int i) {
			
			if(sum == 0)
				return i;
			
			if(n == 0)
				return Integer.MAX_VALUE;
			
			if(coins[n - 1] > sum)
				return findWaysToChangeCoins(coins, sum, n - 1, i);
			
			return Math.min(findWaysToChangeCoins(coins, sum - coins[n - 1], n, i + 1), 
					findWaysToChangeCoins(coins, sum, n - 1, i));
		}
		
	public static int findWaysToChangeCoins_Memo(int coins[], int cache[][], int sum, int n, int i) {
			
			if(sum == 0)
				return cache[n][sum] = i;
			
			if(n == 0 )
				return cache[n][sum] = Integer.MAX_VALUE;
			
			if(cache[n][sum] != -1 && cache[n][sum] != Integer.MAX_VALUE)
				return cache[n][sum];
			
			if(coins[n - 1] > sum)
				return cache[n][sum] = findWaysToChangeCoins_Memo(coins, cache, sum, n - 1, i);
			
			return cache[n][sum] = Math.min(findWaysToChangeCoins_Memo(coins, cache, sum - coins[n - 1], n, i + 1) , 
					findWaysToChangeCoins_Memo(coins, cache, sum, n - 1, i));
	}
	public static void fewestCoin(int coins[], int n, int sum) {
		
		int dp[][] = new int[n + 1][sum + 1];
		
		for(int i = 0; i < n + 1; i ++)
			dp[i][0] = 0;
		
		for(int j = 1; j < sum + 1; j ++)
			dp[0][j] = Integer.MAX_VALUE - 1;
		
		for(int j = 1; j < sum + 1; j++) {
			
			if(j % coins[0] == 0)
				dp[1][j] = j / coins[0];
			else
				dp[1][j] = Integer.MAX_VALUE - 1;
		}
		
		for(int i = 2; i < n + 1; i ++) {
			
			for(int j = 1; j < sum + 1; j ++) {
				
				if(j < coins[i - 1])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
			}
		}
		System.out.println(dp[n][sum]);
	}
	
	public static void fewestCoin_SpaceOPT(int coins[], int n, int sum) {
		
		int dp[] = new int[sum + 1];
		
		for(int i = 0; i < n + 1; i ++)
			dp[i] = Integer.MAX_VALUE;
		
		
		for(int j = 1; j < sum + 1; j++) {
			
			if(j % coins[0] == 0)
				dp[j] = j / coins[0];
			else
				dp[j] = Integer.MAX_VALUE - 1;
		}
		
		for(int i = 2; i < n + 1; i ++) {
			
			int newDp[] = new int[sum + 1];
			
			for(int j = 1; j < sum + 1; j ++) {
				
				if(j < coins[i - 1])
					newDp[j] = dp[j];
				else
					newDp[j] = Math.min(dp[j], 1 + newDp[j - coins[i - 1]]);
			}
			dp = newDp;
		}
		for(int i : dp)
			System.out.print(i);
		System.out.println();
		System.out.println(dp[sum]);
	}
}

