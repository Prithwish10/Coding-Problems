//Given an array of n positive integers and a positive integer s, 
//find the minimal length of a contiguous subarray of which the sum >= s. 
//If there isnt one, return 0 instead.
//
//Example: 
//
//Input: s = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: the subarray [4,3] has the minimal length under the problem constraint.
public class Maximum_Size_Subarray_Sum {

	public int minSubArrayLen(int s, int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int l = 0, r = 0, start = -1, end = -1, sum = 0, min = Integer.MAX_VALUE;
        
        while(r < nums.length){
            
            sum += nums[r];
            
            if(sum >= s){
                min = Math.min(min, r - l + 1);
                while(l < r && sum >= s){
                    min = Math.min(min, r - l + 1);
                    sum -= nums[l];
                    l ++;
                }
                
            }
            
             if(sum == s){
                
                 min = Math.min(min, r - l + 1);
             }
            
            r++;
        }
        
        while(l < r && sum >= s){
            min = Math.min(min, r - l + 1);
            sum -= nums[l];
            l ++;
        }
        
            
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
