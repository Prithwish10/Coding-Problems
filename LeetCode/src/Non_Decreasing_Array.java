
public class Non_Decreasing_Array {

	public boolean checkPossibility(int[] nums) {
        
        if(nums == null)
            return false;
        if(nums.length <= 2)
        	return true;
        
        int count = 0;
        
        for(int i = 0 ; i < nums.length - 1; i++){
            
            if(nums[i] > nums[i + 1]){
                
                count ++;
                
                if(count == 2)
                    return false;
                
                if(i != 0){
                
                    if(nums[i - 1] <= nums[i + 1])
                        nums[i] = nums[i - 1];
               
                    else 
                        nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
