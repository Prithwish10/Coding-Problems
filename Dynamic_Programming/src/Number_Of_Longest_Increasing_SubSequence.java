import java.util.Arrays;

//Given an unsorted array of integers, find the number of longest increasing subsequence.
//
//Example 1:
//Input: [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
//Example 2:
//Input: [2,2,2,2,2]
//Output: 5
//Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, 
//so output 5.
public class Number_Of_Longest_Increasing_SubSequence {

	public int findNumberOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        
        int dp[] = new int[n];
        int cp[] = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(cp, 1);
        int max = 1;
        int index = -1;
        
        for(int i = 1; i < n; i++){
            
            for(int j = 0; j < i; j++){
                
                if(nums[i] > nums[j]){
                    
                    if(dp[j] + 1 > dp[i]){
                        
                        dp[i] = dp[j] + 1;
                        cp[i] = cp[j];
                    }
                    else if(dp[j] + 1 == dp[i]){
                        
                        cp[i] += cp[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            if(dp[i] == max)
                ans += cp[i];
        }
        return ans;
    }
}
