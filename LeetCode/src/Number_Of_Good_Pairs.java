import java.util.HashMap;
import java.util.Map;

public class Number_Of_Good_Pairs {

public int numIdenticalPairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        /*for(int i = 0; i < nums.length; i++){
            
            for(int j = i + 1; j < nums.length; j ++){
                
                if(nums[i] == nums[j])
                    counter ++;
            }
        }*/
        
        for(int i = 0; i < nums.length; i++){
            
            if(map.containsKey(nums[i])){
            
                if(map.get(nums[i]) == 1)
                    counter += 1;
            
                else
                    counter += map.get(nums[i]);
                
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else
                map.put(nums[i], 1);
            
        }
        return counter;
    }
}
