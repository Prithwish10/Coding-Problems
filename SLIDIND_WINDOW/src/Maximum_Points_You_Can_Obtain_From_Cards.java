
public class Maximum_Points_You_Can_Obtain_From_Cards {

	public int maxScore(int[] nums, int k) {
        
        if(nums == null || nums.length == 0 || k > nums.length)
            return 0;
        
        int leftSum = 0, rightSum = 0, n = nums.length;
        
        for(int i = n - k; i < n; i++){
            
            rightSum += nums[i];
        }
        
        int max = rightSum;
        
        for(int i = n - k, j = 0; i < n; i++, j++){
            
            leftSum += nums[j];
            rightSum -= nums[i];
            
            max = Math.max(max, leftSum + rightSum);
        }
        return max;
    }
}
