import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//
//The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
//
//Example 1:
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
//Output: [-1,3,-1]
//Explanation:
//    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
//    For number 1 in the first array, the next greater number for it in the second array is 3.
//    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

public class Next_Greater_Element_1 {
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = nums2.length - 1; i >= 0; i--){
            
            while(!stack.isEmpty() && stack.peek() < nums2[i])
                stack.pop();
            if(stack.isEmpty())
                map.put(nums2[i], -1);
            else 
                map.put(nums2[i], stack.peek());
            stack.add(nums2[i]);
        }
        int res[] = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
