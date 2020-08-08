import java.util.Stack;

public class Next_Greater_In_Circular_Array {

public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int res[] = new int[nums.length];
        
        if(nums == null || nums.length == 0)
            return res;
        
        for(int i = nums.length - 1; i >= 0; i--){
            
            while(!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            
            if(stack.isEmpty()){
                
                int num = nums[i];
                res[i] = -1;
                for(int j = 0; j < i; j++){
                    if(nums[j] > num){
                        res[i] = nums[j];
                        break;
                    }
                }
            }
                
            else
                res[i] = stack.peek();
            stack.add(nums[i]);
        }
        return res;
    }
}
