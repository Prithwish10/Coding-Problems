
public class Shortest_Unsorted_Continuous_Subarray {

public int findUnsortedSubarray(int[] nums) {
        
        if(nums == null || nums.length == 0 || nums.length == 1) return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1] && nums[i] < min)
                min = nums[i];
        }
        
        if(min == Integer.MAX_VALUE)
            return 0;
        
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i + 1] && nums[i] > max)
                max = nums[i] ;    
        }
        
        int minIndex = 0;
        int maxIndex = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] > min){
                minIndex = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; i --){
            if(nums[i] < max){
                maxIndex = i;
                break;
            }
        }
     
        return maxIndex - minIndex + 1;
    }
}
