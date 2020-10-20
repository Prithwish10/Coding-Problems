
public class N_th_Tribonacci_Number {

	public int tribonacci(int n) {
        
        int dp[] = new int[n + 1];
        return tribonacci(dp, n);
    }
    private int tribonacci(int dp[], int n){
        
        if(n <= 1){
            return dp[n] = n;
        }
        if(n == 2){
            return dp[n] = 1;
        }
        
        if(dp[n] != 0)
            return dp[n];
        
        return dp[n] = tribonacci(dp, n - 1) + tribonacci(dp, n - 2) + tribonacci(dp, n - 3);
    }
}
