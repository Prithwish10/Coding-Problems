//Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
//
//A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
//
//Return the maximum length of a subarray with positive product.
//
// 
//
//Example 1:
//
//Input: nums = [1,-2,-3,4]
//Output: 4
//Explanation: The array nums already has a positive product of 24.
//Example 2:
//
//Input: nums = [0,1,-2,-3,-4]
//Output: 3
//Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
//Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.
//Example 3:
//
//Input: nums = [-1,-2,-3,0,1]
//Output: 2
//Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].

public class Maximum_Length_of_Subarray_With_Positive_Product {

	public int getMaxLen(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = 0, end = 0, start = 0, n = nums.length;
        
        while(end < n){
            
            while(end < n && nums[end] == 0)
                end ++;
            
            start = end;
            
            int fn = -1, ln = -1, neg = 0;
            boolean first_neg = false;
            
            while(end < n && nums[end] != 0){
                
                if(nums[end] < 0 && !first_neg){
                    fn = end;
                    first_neg = true;
                }
                if(nums[end] < 0){
                    ln = end;
                    neg ++;
                }
                end ++;
            }
            
            if(neg % 2 == 0)
                max = Math.max(max, end - start);
            else
                max = Math.max(max, Math.max(end - fn - 1, ln - start));
        }
        return max;
    }
}
