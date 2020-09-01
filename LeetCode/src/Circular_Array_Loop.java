//You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.
//
//Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.
//
// 
//
//Example 1:
//
//Input: [2,-1,1,2,2]
//Output: true
//Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
import java.util.HashSet;
import java.util.Set;

public class Circular_Array_Loop {

	public boolean circularArrayLoop(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return false;
        
        int n = nums.length;
        boolean flag = false;
        
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] > 0)
                flag = true;
            
            if(helper(nums, n, i, nums[i], flag))
                return true;
        }
        return false;
    }
    private boolean helper(int nums[], int n, int index, int num, boolean flag){
        
        Set<Integer> set = new HashSet<>();
        int i = index, start = index;
        
        while(true){
            
            if((flag == true && nums[i] < 0) || (flag == false && nums[i] > 0))
                return false;
            
            if(set.contains(i)){
                if(i == start && set.size() > 1)
                    return true;
                else
                    return false;
            }
            
            set.add(i);
            
            int temp = Math.abs(nums[i]);
            
            if(nums[i] > 0){
                
                while(temp > 0){
                    
                    if(i == n)
                        i = 0;
                    i ++;
                    temp --;
                }
                
                if(i == n)
                    i = 0;  
            }

            else{
                
                while(temp > 0){
                    
                    if(i == -1)
                        i = 0;
                    i --;
                    temp --;
                }
                
                if(i == -1)
                    i = n - 1;
                
            }

        }
    }
}
