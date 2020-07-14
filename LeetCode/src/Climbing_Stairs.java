import java.util.Arrays;
import java.util.Scanner;

class Climbing_Stairs {
    public static int climbStairs(int n) {
        
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairs(n, dp);
    }
    public static int climbStairs(int n, int dp[]){
        
        if(n == 0)
            return dp[n] = 1;
        if(n < 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
    }
    public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter n :");
    	int n = sc.nextInt();
    	
    	int res = climbStairs(n);
    	System.out.println(res);
    }
}
