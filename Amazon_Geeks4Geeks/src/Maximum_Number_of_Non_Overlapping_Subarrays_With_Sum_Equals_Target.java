import java.util.HashSet;
import java.util.Set;

public class Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target {

	public int maxNonOverlapping(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        int sum = 0, count = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            sum += nums[i];
            
            if(set.contains(sum - k)){
                
                count ++;
                set.clear();
            }
            
            set.add(sum);
        }
        return count;
    }
}
