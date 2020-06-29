
public class Knapsack_0_1 {

	public static void main(String args[]) {
		
		int weight[] = {50};
		int profit[] = {50};
		
		int capacity = 50;
		
		System.out.println(knapsack(weight, profit, capacity, weight.length));
		int cache[][] = new int[weight.length + 1][capacity + 1];
		System.out.println(knapsack(weight, profit, cache, capacity, weight.length));
	}
	
	public static int knapsack(int weight[], int profit[], int capacity, int n) {
		
		if(capacity == 0 || n == 0)
			return 0;
		
		if(weight[n - 1] > capacity)
			return knapsack(weight, profit, capacity, n - 1);
		
		return Math.max(profit[n - 1] + knapsack(weight, profit, capacity - weight[n - 1], n - 1), 
					knapsack(weight, profit, capacity, n - 1));
	}
	
	public static int knapsack(int weight[], int profit[], int cache[][], int capacity, int n) {
		
		if(capacity == 0 || n == 0)
			return 0;
		
		if(cache[n][capacity] != 0)
			return cache[n][capacity];
		
		if(weight[n - 1] > capacity)
			return cache[n][capacity] = knapsack(weight, profit, capacity, n - 1);
		
		return cache[n][capacity] = Math.max(profit[n - 1] + knapsack(weight, profit, capacity - weight[n - 1], n - 1), 
					knapsack(weight, profit, capacity, n - 1));
	}
}
