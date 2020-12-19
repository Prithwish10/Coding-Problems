import java.util.Arrays;

public class Merge_Two_Sorted_Array {

	
    public static void merge(int arr1[], int arr2[], int n, int m) 
    {
        int end = n - 1;
        int start = 0;
        
        while(end >= 0 && start < m){
            
            if(arr1[end] > arr2[start]){
                int temp = arr1[end];
                arr1[end] = arr2[start];
                arr2[start] = temp;
                
                end --;
                start ++;
            }
            else
                break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
	
}
