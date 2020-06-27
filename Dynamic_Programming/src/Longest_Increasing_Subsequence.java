import java.util.Arrays;

public class Longest_Increasing_Subsequence {

	public static void main(String args[]) {
		
		int ar[] = {1, 2, 3, 9};
		
		System.out.println(lis(ar, 0, Integer.MIN_VALUE));
		
		int cache[] = new int[ar.length];
		System.out.println(lis_Memo(ar, cache, 0, Integer.MIN_VALUE));
		
		lis_Tabular(ar, ar.length);
	}
	
	//Recursive Approach
	//Time : O(2 ^ n)
	//Space : O(1)
	public static int lis(int ar[], int cur, int prev) {
		
		if(cur >= ar.length) {
			return 0;
		}
		
		int include = 0;
		int not_include = 0;
		
		if(ar[cur] > prev)
			include = 1 + lis(ar, cur + 1, ar[cur]);
		
		not_include = lis(ar, cur + 1, prev);
		
		return Math.max(include, not_include);
	}
	
	//DP - Memoization
	//Time :
	//Space : O(n) for taking the auxiliary cache to store the function results
	public static int lis_Memo(int ar[], int cache[], int cur, int prev) {
		
		if(cur >= ar.length) {
			return cache[cur] = 0;
		}
		
		if(cache[cur] != 0)
			return cache[cur];
		
		int include = 0;
		int not_include = 0;
		
		if(ar[cur] > prev)
			include = 1 + lis(ar, cur + 1, ar[cur]);
		
		not_include = lis(ar, cur + 1, prev);
		
		return cache[cur] = Math.max(include, not_include);
	}
	
	//DP - Tabular Approach
	//Time : O(n^2)
	//Space : O(n)
	public static void lis_Tabular(int ar[], int n) {
		
		int cache[] = new int[n];
		
		Arrays.fill(cache, 1);
		
		for(int i = 1; i < n; i++) {
			
			for(int j = 0; j < i; j++) {
				
				if(ar[i] > ar[j]) {
					
					cache[i] = Math.max(cache[j] + 1, cache[i]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++)
			if(cache[i] > max)
				max = cache[i];
		
		System.out.println(max);
	}
}
