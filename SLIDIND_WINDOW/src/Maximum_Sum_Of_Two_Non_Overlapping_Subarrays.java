
public class Maximum_Sum_Of_Two_Non_Overlapping_Subarrays {

	public int maxSumTwoNoOverlap(int[] A, int L, int R) {
        
        return Math.max(maxSum(A, L, R), maxSum(A, R, L));
    }
    private int maxSum(int A[], int L, int R){
        
        int sumL = 0, sumR = 0, i = 0;
        
        for(i = 0; i < L; i++)
            sumL += A[i];
        
        for(; i < L + R; i++)
            sumR += A[i];
        
        int maxL = sumL, res = sumL + sumR;
        
        for(; i < A.length; i++){
            
            sumL -= A[i - L - R];
            sumL += A[i - R];
            
            sumR -= A[i - R];
            sumR += A[i];
            
            maxL = Math.max(maxL, sumL);
            //maxR = Math.max(maxR, sumR);
            
            res = Math.max(res, maxL + sumR);
        }
        return res;
    }
}
