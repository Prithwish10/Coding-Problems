import java.util.HashMap;
import java.util.Map;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//Your algorithm should run in O(n) complexity.
//
//Example:
//
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

public class Longest_Consecutive_Sequence {

	public int longestConsecutive(int[] nums) {
        
        Map<Integer, Boolean> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            
            if(map.containsKey(nums[i]))
                continue;
            else
                map.put(nums[i], true);
        }
        
        int prev = 0;
        int next = 0;
        int count = 1;
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            count = 1;
            next = nums[i];
            prev = nums[i];
            
            while(map.containsKey(++next) && map.get(next) == true){
                
                count ++;
                map.put(next, false);
            }
            
            while(map.containsKey(--prev) && map.get(prev) == true){
                
                count ++;
                map.put(prev, false);
            }
            
            max = Math.max(max, count);
        }
        return max;
    }
}
