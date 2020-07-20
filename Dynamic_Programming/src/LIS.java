import java.util.Arrays;
import java.util.Scanner;

class LIS {
    public static int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int dp[] = new int[nums.length];
        
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < nums.length; i ++){
            
            for(int j = 0; j < i; j ++){
                
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++)
            if(dp[i] > max)
                max = dp[i];
        
        return max;
    }
public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		System.out.println("Enter the elements :");
		for(int i = 0; i < n; i ++)
			ar[i] = sc.nextInt();
		
		int res = lengthOfLIS(ar);
		
		System.out.println(res);
	}
}

