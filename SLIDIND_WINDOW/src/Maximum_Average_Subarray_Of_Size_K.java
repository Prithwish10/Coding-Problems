
public class Maximum_Average_Subarray_Of_Size_K {

public double findMaxAverage(int[] nums, int k) {
        
        if(nums == null || nums.length == 0)
            return 0.0;
        
        double maxAvg = 0.0;
        
        double sum = 0;
        int i = 0;
        
        for(i = 0; i < k; i++)
            sum += nums[i];
        
        maxAvg = sum/k;
        
        for(; i < nums.length; i++){
            
            sum -= nums[i - k];
            sum += nums[i];
            
            double avg = sum / k;
            
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }
}
