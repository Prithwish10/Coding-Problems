//Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.
//
//Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
//
// 
//
//Example 1:
//
//Input: [6,0,8,2,1,5]
//Output: 4
//Explanation: 
//The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
//Example 2:
//
//Input: [9,8,1,0,1,9,4,0,4,1]
//Output: 7
//Explanation: 
//The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.

import java.util.Stack;

public class Maximum_Width_Ramp {

	public int maxWidthRamp(int[] A) {
        
        /*int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < A.length - 1; i++){
            
            for(int j = A.length - 1; j > i; j--){
                
                if(A[j] >= A[i]){
                    max = Math.max(max, j - i);
                    break;
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;*/
        
        int n = A.length, max = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        stack.add(n - 1);
        
        for(int i = n - 2; i >= 0; i--){
            
            if(A[i] > A[stack.peek()])
                stack.add(i);
        }
        
        for(int i = 0; i < n && !stack.isEmpty(); i++){
            
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                max = Math.max(max, stack.peek() - i);
                stack.pop();
            }
        }
        return max;
    }
}
