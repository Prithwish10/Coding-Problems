//Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
//which has the largest product.

//Example 1:
//
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
//Example 2:
//
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

import java.util.Scanner;
public class Maximumm_SubArray_Product {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements you want to enetr :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		System.out.println("Enter the elements into the array :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println(maxProduct(ar, n));
	}
	public static int maxProduct(int ar[], int n) {
		
		if(n == 0)
			return -1;
		int cur_max = ar[0];
		int cur_min = ar[0];
		int prev_max = ar[0];
		int prev_min = ar[0];
		int result  = ar[0];
		
		for(int i = 1; i < n; i++) {
			
			cur_max = Math.max(prev_max * ar[i], Math.max(prev_min * ar[i], ar[i]));
			cur_min = Math.min(prev_max * ar[i], Math.min(prev_min * ar[i], ar[i]));
			result = Math.max(result,  cur_max);
			prev_max = cur_max;
			prev_min = cur_min;
		}
		return result;
	}
}
