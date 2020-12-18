//Given an array of n elements, where each element is at most k away from its target position, 
//devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, 
//an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
//
//Examples:
//
//Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
//            k = 3 
//Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
//
//Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
//         k = 4
//Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
import java.util.PriorityQueue;
import java.util.Scanner;
public class Sort_Nearly_SortedArray {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in the array :");
		
		int n = sc.nextInt();
		
		System.out.println("Enter the elements into the array :");
		
		int ar[] = new int[n];
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter k :");
		int k = sc.nextInt();
		
		int res[] = sort(ar, n, k);
		
		for(int i : res)
			System.out.print(i +" ");
	}
	
	//Time Complexity : O(k) + O((n-k)log k) = O(n log k)
	//Space complexity : O(n) for the heap
	
	public static int[] sort(int ar[], int n, int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int index = 0;
		
		for(int i : ar) {
			
			if(minHeap.size() < k + 1)
				minHeap.add(i);
			else {
				
				ar[index ++] = minHeap.poll();
				minHeap.add(i);
			}
		}
		while(!minHeap.isEmpty())
			ar[index ++] = minHeap.poll();
		
		return ar;
	}
}
