
public class Fibonacci_Number {

	public static void main(String args[]) {
		
		int n = 4;
		System.out.println(fibo_recursive(n));
		
		int cache[] = new int[n + 1];
		System.out.println(fibo_Memoize(cache, n));
		
		fibo_tabular(n);
	}
	public static int fibo_recursive(int n) {
		
		if(n <= 1)
			return n;
		
		return fibo_recursive(n- 1) + fibo_recursive(n - 2);
	}
	public static int fibo_Memoize(int cache[], int n) {
		
		if(n <= 1)
			return cache[n] = n;
		
		if(cache[n] != 0)
			return cache[n];
		
		return cache[n] = fibo_Memoize(cache,  n - 1) + fibo_Memoize(cache, n - 2);
	}
	public static void fibo_tabular(int n) {
		
		int cache[] = new int[n + 2];
		
		cache[0] = 0;
		cache[1] = 1;
		
		for(int i = 2; i <= n; i++)
			cache[i] = cache[i - 1] + cache[i - 2];
		
		System.out.println(cache[n]);
	}
}
