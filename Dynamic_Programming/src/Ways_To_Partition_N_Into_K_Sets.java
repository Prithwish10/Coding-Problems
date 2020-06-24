//Problem : In how many number of ways can you partition n elements into 
//K number of subsets
public class Ways_To_Partition_N_Into_K_Sets {

	public static void main(String args[]) {
		
		int n = 4, k = 2;
		
		int res = partitionWays(n, k);
		System.out.println(res);
		
		int cache[][] = new int[n + 1][k + 1];
		int res2 = partitionWays1(n, k, cache);
		System.out.println(res2);
		
		partitionWays2(n, k);
	}
	
	public static int partitionWays(int n, int k) {
		
		if(n <= 0 || k <= 0)
			return 0;
		
		if(k == 1 || n == k)
			return 1;
		else
			return k * partitionWays(n - 1, k) + partitionWays(n - 1, k - 1);
	}
	
	public static int partitionWays1(int n, int k, int cache[][]) {
		
		if(n <= 0 || k <= 0)
			return 0;
		
		if(k == 1 || n == k)
			return cache[n][k] = 1;
		
		if(cache[n][k] != 0)
			return cache[n][k];
		
		else
			return cache[n][k] = k * partitionWays1(n - 1, k, cache) + 
									partitionWays1(n - 1, k - 1, cache);
	}
	// Tabular Approach
	public static void partitionWays2(int n, int k) {
		
		int cache[][] = new int[n + 1][k + 1];
		
		for(int i = 0; i <= n; i++)
			cache[i][0] = 0;
		
		for(int j = 0; j <= k; j++)
			cache[0][j] = 0;
		
		for(int i = 1; i <= n; i++) {
			
			for(int j = 1; j <= k; j++) {
				
				if(j > n)
					cache[i][j] = 0;
				else if(j == 1 || i == j)
					cache[i][j] = 1;
				else
					cache[i][j] = j * cache[i - 1][j] + cache[i - 1][j - 1];
			}
		}
		System.out.println(cache[n][k]);
	}
}
