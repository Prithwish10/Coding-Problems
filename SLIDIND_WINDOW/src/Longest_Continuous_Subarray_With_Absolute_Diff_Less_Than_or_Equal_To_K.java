//Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray 
//such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 

import java.util.*;
public class Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_To_K {

	public int longestSubarray(int[] nums, int limit) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(nums[0]);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        maxHeap.add(nums[0]);
        
        int count = 1;
        int start = 0;
        
        for(int i = 1; i < nums.length; i++){
            
            minHeap.add(nums[i]);
            maxHeap.add(nums[i]);
            
            if(maxHeap.peek() - minHeap.peek() <= limit)
                count = Math.max(i - start + 1, count);
            
            else{
                while(maxHeap.peek() - minHeap.peek() > limit){
                    
                    minHeap.remove(nums[start]);
                    maxHeap.remove(nums[start]);
                    start ++;
                }
            }
        }
        return count;
    }
}
