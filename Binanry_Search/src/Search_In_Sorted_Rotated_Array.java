import java.util.Scanner;
public class Search_In_Sorted_Rotated_Array {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements you want to enter :");
		
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the elements into the array :");
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter the element to be searched :");
		int key = sc.nextInt();
		
		int res = search(ar, n, key);
		
		System.out.println(res);
	}
	public static int search(int ar[], int n, int key) {
		
		if(ar == null || n == 0 || (n == 1 && key != ar[0]))
			return -1;
		if(n == 1 && key == ar[0])
			return 0;
		
		int L = 0;
		int H = n - 1;
		// First we need to find the pivot(the element in the array from where the order has changed)    
		while(L < H) {
			//If the mid element is greater than the last element then the pivot must lie in the right part
			//and we set L = mid + 1
			
			//Else(if the mid element is <= the H that means the right part is sorted) so we focus on the left part
			//so we set H = mid (Not mid - 1, because the mid element may be the pivot element)
			int mid = L + (H - L)/2;
			
            if(ar[mid] > ar[H])
                L = mid + 1;
            else
                H = mid;
        }
        //Once the loop overs then the L will be pointed at the pivot
		//so now we just check that in which half the target element lies
		//And accordingly we search for the target using the helper method
        if(key >= ar[L] && key <= ar[ar.length - 1])
            return helper(ar, L, ar.length - 1, key);
        else
            return helper(ar, 0, L - 1, key);
			
	}
	public static int helper(int ar[], int start, int end, int key) {
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(ar[mid] == key)
				return mid;
			else if(key < ar[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}
}
