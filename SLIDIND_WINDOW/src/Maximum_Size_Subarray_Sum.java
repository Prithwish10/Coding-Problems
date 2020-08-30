
public class Maximum_Size_Subarray_Sum {

	public int minSubArrayLen(int s, int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int l = 0, r = 0, start = -1, end = -1, sum = 0, min = Integer.MAX_VALUE;
        
        while(r < nums.length){
            
            sum += nums[r];
            
            if(sum >= s){
                min = Math.min(min, r - l + 1);
                while(l < r && sum >= s){
                    min = Math.min(min, r - l + 1);
                    sum -= nums[l];
                    l ++;
                }
                
            }
            
             if(sum == s){
                
                 min = Math.min(min, r - l + 1);
             }
            
            r++;
        }
        
        while(l < r && sum >= s){
            min = Math.min(min, r - l + 1);
            sum -= nums[l];
            l ++;
        }
        
            
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
