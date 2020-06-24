
public class Catalan_Number {

	public static void main(String args[]) {
		
		System.out.println(catalan(4));
		System.out.println(catalan1(4, new int[4 + 2]));
		catalan2(4);
	}
	//Using Recursion
	public static int catalan(int n) {
		
		int res = 0;
		if(n <= 1)
			return 1;
		for(int i = 0; i < n; i++)
			res += catalan(i) * catalan(n - i - 1);
		
		return res;
	}
	// Using Memoization
	public static int catalan1(int n, int cache[]) {
		
		int res = 0;
		
		if(n <= 1)
			return cache[n] = 1;
		
		if(cache[n] != 0)
			return cache[n];
		
		for(int i = 0; i < n; i++) {
			res += catalan(i) * catalan(n - i - 1);
			cache[n] = res;
		}
		
		return cache[n];
	}
	//Tabular method
	public static void catalan2(int n) {
		
		int cache[] = new int[n + 2];
		
		cache[0] = 1;
		cache[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			
			cache[i] = 0;
			for(int j = 0; j < i; j ++) {
				
				cache[i] += cache[j] * cache[i - j - 1];
			}
		}
		System.out.println(cache[n]);
	}
}
