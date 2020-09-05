import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class How_Many_Numbers_Are_Smaller_Than_Current {

	public int[] smallerNumbersThanCurrent(int[] nums) {
        
        //Time : O(n)
        
        /*int count[] = new int[101];
        
        for(int i : nums)
            count[i] ++;
        
        
        for(int i = 1; i <= 100; i++){
            count[i] += count[i - 1];
        }
        
        int res[] = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }
        return res;*/
        
        // Time : O(n log n)
        
        int temp[] = Arrays.copyOf(nums, nums.length);
        
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        map.put(temp[0], 0);
        
        for(int i = 1; i < temp.length; i++){
            
            count ++;
            
            if(temp[i] != temp[i - 1])
                map.put(temp[i], count);
        }
        
        int res[] = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            
            res[i] = map.get(nums[i]);
        }
        
        return res;
    }
}
