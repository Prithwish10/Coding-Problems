//Given a binary array nums, you should delete one element from it.
//
//Return the size of the longest non-empty subarray containing only 1's in the resulting array.
//
//Return 0 if there is no such subarray.
//
// 
//
//Example 1:
//
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
//Example 2:
//
//Input: nums = [0,1,1,1,0,1,1,0,1]
//Output: 5
//Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
//Example 3:
//
//Input: nums = [1,1,1]
//Output: 2
//Explanation: You must delete one element.
//Example 4:
//
//Input: nums = [1,1,0,0,1,1,1,0,1]
//Output: 4
public class Longest_Subarray_Of_1s_After_Deleating_1Element {

	public int longestSubarray(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int start = 0; 
        int end = 0;
        int zeroCount = 0;
        int max = 0;
        
        for(end = 0; end < nums.length && zeroCount < 2; end ++){
            if(nums[end] == 0)
                zeroCount ++;
        }
        
        max = Math.max(max, end - start - 1);
        
        for(; end < nums.length; end ++){
            
            max = Math.max(max, end - start - 1);
            
            while(start < end && zeroCount > 1){
                if(nums[start] == 0)
                    zeroCount --;
                start ++;
            }
            if(nums[end] == 0)
                zeroCount ++;
        }
        
        if(zeroCount > 1){
            max = Math.max(max, end - start - 1);
        }
        else
            max = Math.max(max, end - start);
        
        return max - 1;
    }
}
