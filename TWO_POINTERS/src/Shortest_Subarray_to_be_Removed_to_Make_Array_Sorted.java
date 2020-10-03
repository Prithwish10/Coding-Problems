
public class Shortest_Subarray_to_be_Removed_to_Make_Array_Sorted {

	public int findLengthOfShortestSubarray(int[] arr) {
        
        if(arr == null) return -1;
        
        int n = arr.length;
        
        if(arr.length == 0 || arr.length == 1)
            return 0;
        
        int i = 0, s = 0, min = Integer.MAX_VALUE;
        
        while(i < n - 1){
            
            if(arr[i] <= arr[i + 1])
                i ++;
            else
                break;
        }
        s = i;
        
        int j = n - 1;
        
        while(j > 0){
            
            if(arr[j] >= arr[j - 1])
                j --;
            else
                break;
        }
        
        min = Math.min(n - (s + 1), n - (n - j));
        
        if(min == 0)
            return 0;
        
        i = 0;
        
        while(i <= s && j < n){
            
            if(arr[j] >= arr[i]){
                min = Math.min(min, j - i - 1);
                i ++;
            }
            else{
                j ++;
            }
        }
        return min;              
    }
}
