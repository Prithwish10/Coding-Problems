//Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

//Return the length of the longest (contiguous) subarray that contains only 1s. 

//Example 1:

//Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//Output: 6
//Explanation: 
//[1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
//Example 2:

//Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//Output: 10
//Explanation: 
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
class Max_Consequitive1_III {
    public int longestOnes(int[] A, int k) {
        
        if(A == null || A.length == 0)
            return 0;
        
        int ones = 0;
        int zeros = 0;
        int max = 0;
        
        int i = 0, j = 0;
        
        while(j < A.length){
            
            if(A[j] == 1)
                ones ++;
            
            if(A[j] == 0)
                zeros ++;
            
            if(zeros <= k)
                max = Math.max(max, j - i + 1);
            
            if(zeros > k){
                
                if(A[i] == 1)
                    ones --;
                else if(A[i] == 0)
                    zeros --;
                
                i ++;
            }   
            j ++;
        }
        return max;
    }
}
