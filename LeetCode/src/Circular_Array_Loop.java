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
