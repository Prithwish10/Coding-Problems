
public class Next_Permutation {

	public void nextPermutation(int[] nums) {
        
        if(nums == null) return;
        
        int k = -1, i = 0;
        for(i = nums.length - 2; i >= 0; i --){
            if(nums[i] < nums[i + 1]){
                k = i;
                break;
            }
        }
        
        if(i == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        for(i = nums.length - 1; i > k; i --){
            if(nums[i] > nums[k])
                break;
        }
        
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
        
        reverse(nums, k + 1, nums.length - 1);
    }
    public void reverse(int nums[], int i, int j){
        
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
    }
}
