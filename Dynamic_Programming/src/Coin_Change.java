import java.util.ArrayList;

//Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
//valued coins, how many ways can we make the change? The order of coins doesn’t matter.
//For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
//So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, 
//{2,3,5} and {5,5}. So the output should be 5.

public class Coin_Change {

	public static void main(String args[]) {
		
		int ar[] = {6, 2, 5};
		int N = 11;
		ArrayList<Integer> list = new ArrayList<Integer>();
		changeRecur(ar, N, 0, 0, list);
		
		//System.out.println("The number of ways to make N changes :"+changeRecur_Ways(ar, N, 0, 0, list));
		
		int cache[][] = new int[ar.length + 1][N + 1];
		
		System.out.println(change_Memo_Ways(ar, cache, N, 0, 0));
		
		tabular_CoinChange(ar, N);
	}
	// Recursive Approach to print the changes in the coin
	public static void changeRecur(int ar[], int n, int sum, int pos, ArrayList<Integer> list) {
		
		if(pos >= ar.length || sum > n)
			return;
		
		if(sum == n) {
			System.out.println(list);
			return;
		}
		list.add(ar[pos]);
		changeRecur(ar, n, sum + ar[pos], pos, list);
		
		list.remove(list.size() - 1);
		
		changeRecur(ar, n, sum, pos + 1, list);
	}
	//Using Recursion
	public static int changeRecur_Ways(int ar[], int n, int sum, int pos, ArrayList<Integer> list) {
		
		if(pos >= ar.length || sum > n)
			return 0;
		
		if(sum == n) {
			return 1;
		}
		int include = changeRecur_Ways(ar, n, sum + ar[pos], pos, list);
	
		
		int not_include = changeRecur_Ways(ar, n, sum, pos + 1, list);
		
		return include + not_include;
	}
	//Memoization
	public static int change_Memo_Ways(int ar[], int cache[][], int n, int sum, int pos) {
		
		if(pos >= ar.length || sum > n)
			return 0;
		
		if(sum == n) {
			return cache[pos][sum] = 1;
		}
		if(cache[pos][sum] != 0)
			return cache[pos][sum];
		
		int include = change_Memo_Ways(ar, cache, n, sum + ar[pos], pos);
	
		
		int not_include = change_Memo_Ways(ar, cache, n, sum, pos + 1);
		
		return cache[pos][sum] = include + not_include;
	}
	
	//Tabular Approach
	public static void tabular_CoinChange(int coin[], int amount) {
		
		int cache[][] = new int[coin.length + 1][amount + 1];
		
		cache[0][0] = 1;
		
		for(int i = 1; i <= amount; i++)
			cache[0][i] = 0;
		
		for(int i = 1; i < coin.length; i++)
			cache[i][0] = 1;
		
		for(int i = 1; i <= coin.length; i++) {
			
			for(int j = 1; j <= amount; j++) {
				
				if(coin[i - 1] > j)
					cache[i][j] = cache[i - 1][j];
				else {
					cache[i][j] = cache[i - 1][j] + cache[i][j - coin[i - 1]];
				}
			}
		}
		System.out.println(cache[coin.length][amount]);
	}
}
