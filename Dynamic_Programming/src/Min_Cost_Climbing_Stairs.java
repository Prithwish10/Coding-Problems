import java.util.Arrays;
import java.util.Scanner;

class Min_Cost_Climbing_Stairs {
    public static int minCostClimbingStairs(int[] cost) {
        
        if(cost == null || cost.length == 0)
            return -1;
        
        if(cost.length == 1)
            return cost[0];
        
        int res = Integer.MAX_VALUE;
        
        int dp[] = new int[cost.length + 1];
        
        Arrays.fill(dp, -1);
        
        return Math.min(helper(cost, cost.length, 0, dp), helper(cost, cost.length, 1, dp));
    }
    public static int helper(int cost[], int n, int i, int dp[]){
        
        if(i >= n)
            return 0;
        
       if(dp[i] != -1)
           return dp[i];
        
        return dp[i] = cost[i] + Math.min(helper(cost, n, i + 1, dp),                                                   helper(cost, n , i + 2, dp));
    }
    public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter n :");
    	int n = sc.nextInt();
    	
    	System.out.println("Enter the cost array :");
    	int cost[] = new int[n];
    	
    	for(int i = 0; i < n; i++)
    		cost[i] = sc.nextInt();
    	
    	int res = minCostClimbingStairs(cost);
    	System.out.println(res);
    }
}