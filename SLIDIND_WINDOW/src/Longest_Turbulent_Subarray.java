//A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
//
//For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
//OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
//That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
//
//Return the length of a maximum size turbulent subarray of A.
//
// 
//
//Example 1:
//
//Input: [9,4,2,10,7,8,8,1,9]
//Output: 5
//Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])

public class Longest_Turbulent_Subarray {

	public int maxTurbulenceSize(int[] A) {
        
        int max_sofar = 0;
        int global_max = 0;
        
        for(int i = 0; i < A.length - 1; i++){
            
            if(i % 2 == 1 && A[i] > A[i + 1])
                max_sofar ++;
            else if(i % 2 == 0 && A[i] < A[i + 1])
                max_sofar ++;
            else
                max_sofar = 0;
            global_max = Math.max(global_max, max_sofar);
        }
        max_sofar = 0;
        
        for(int i = 0; i < A.length - 1; i++){
            
            if(i % 2 == 0 && A[i] > A[i + 1])
                max_sofar ++;
            else if(i % 2 == 1 && A[i] < A[i + 1])
                max_sofar ++;
            else
                max_sofar = 0;
            global_max = Math.max(global_max, max_sofar);
        }
        return global_max + 1;
    }
}
