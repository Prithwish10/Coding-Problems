//Given an array of integers nums and an integer target.
//
//Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal than target.
//
//Since the answer may be too large, return it modulo 10^9 + 7.
//
// 
//
//Example 1:
//
//Input: nums = [3,5,6,7], target = 9
//Output: 4
//Explanation: There are 4 subsequences that satisfy the condition.
//[3] -> Min value + max value <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
//Example 2:
//
//Input: nums = [3,3,6,8], target = 10
//Output: 6
//Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
//Example 3:
//
//Input: nums = [2,3,3,4,6,7], target = 12
//Output: 61
//Explanation: There are 63 non-empty subsequences, two of them don't satisfy the condition ([6,7], [7]).
//Number of valid subsequences (63 - 2 = 61).

import java.util.Arrays;

public class Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {

int mod = 1000000007;
    
    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int i = 0, j = nums.length - 1;
        int ans = 0;
        
        while(i <= j){
            
            if(nums[i] + nums[j] <= target){
                ans += pow(2, j - i);
                ans %= mod;
                i ++;
            }
            else
                j --;
        }
        return ans;
    }
    private long pow(int a, int b){
        
        if(b == 0)
            return 1;
        if(b == 1)
            return a;
        
        long d = 1;
        
        if(b % 2 == 0){
            d = pow(a, b/2);
            d = d * d;
        }
        else{
            d = a * pow(a, b - 1);
        }
        return d % mod;
    }
}
