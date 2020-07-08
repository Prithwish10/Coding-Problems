
class Minimum_In_Rotated_SortedArray {
    public static int findMin(int[] ar) {
        
        int n = ar.length;

		if(ar == null || n == 0)
			return -1;
	
		// First we need to find the pivot(the element in the array from where the order                has changed)
		
		int L = 0;
		int H = n - 1;
		
        
		while(L < H) {
			
			int mid = L + (H - L)/2;
			
            if(ar[mid] > ar[H])
                L = mid + 1;
            else
                H = mid;
        }
        
        return ar[L];	
	}
    public static void main(String args[]) {
    	
    	int ar[] = {11, 12, 13, 14, 2, 7, 9};
    	
    	System.out.println(findMin(ar));
    }
}