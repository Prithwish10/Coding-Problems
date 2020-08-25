
public class Longest_Continuous_Increasing_SubSequence {

	public int findLengthOfLCIS(int[] nums) {
        
        /*if(nums.length == 0)
            return 0;
        
        int len;
        int max = 1;
        
        for(int i = 0; i < nums.length; i++){
            
            len = 1;
            
            for(int j = i + 1; j < nums.length; j++){
                
                if(nums[j] > nums[j - 1])
                    len++;
                else 
                    break;
            }
            max = Math.max(max, len);
        }
        return max;
        */
        if(nums == null || nums.length ==0) return 0;
        
        int maxLen = 1, currLen = 1;
        
        for(int i = 1; i < nums.length; i++){
            
            if(nums[i] > nums[i - 1]){
                
                currLen ++;
            }
            else{
                
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
        }
        return Math.max(maxLen, currLen);
    }
}
