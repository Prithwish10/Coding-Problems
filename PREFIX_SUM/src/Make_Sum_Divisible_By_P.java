//Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.
//
//Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
//
//A subarray is defined as a contiguous block of elements in the array.
//
// 
//
//Example 1:
//
//Input: nums = [3,1,4,2], p = 6
//Output: 1
//Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
//Example 2:
//
//Input: nums = [6,3,5,2], p = 9
//Output: 2
//Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
//Example 3:
//
//Input: nums = [1,2,3], p = 3
//Output: 0
//Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.
//Example 4:
//
//Input: nums = [1,2,3], p = 7
//Output: -1
//Explanation: There is no way to remove a subarray in order to get a sum divisible by 7.
//Example 5:
//
//Input: nums = [1000000000,1000000000,1000000000], p = 3
//Output: 0

import java.util.HashMap;
import java.util.Map;

public class Make_Sum_Divisible_By_P {

	public int minSubarray(int[] nums, int p) {
        
        if(nums == null || nums.length == 0) return -1;
            
        int rem = 0, n = nums.length;
        
        for(int i = 0; i < n; i++)
            rem = (rem +nums[i]) % p;
        
        if(rem == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        
        int cur = 0, temp = 0, res = n;
        
        for(int i = 0; i < n; i++){
            
            cur = (cur + nums[i]) % p;
            
            temp = (cur - rem) % p;
            
            if(temp < 0)
                temp += p;
            
            if(map.containsKey(temp))
                res = Math.min(res, i - map.get(temp));
            
            map.put(cur, i);
        }
        
        return res == n ? -1 : res;
    }
}
