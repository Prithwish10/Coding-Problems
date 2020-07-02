//Given a big file or an array, find out the K-th largest element
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Kth_LargestElement {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements :");
		int n = sc.nextInt();
		 
		System.out.println("Enter the eleemnts into the array :");
		int ar[] = new int[n];
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter k :");
		int k = sc.nextInt();
		
		int arr[] = Arrays.copyOf(ar, ar.length);
		System.out.println("Using max Heap :");
		find(ar, k);
		
		System.out.println("Using min Heap :");
		find1(arr, k);
		
		int cpy[] = Arrays.copyOf(ar, ar.length);
		System.out.println("Top k largest elements in descending order are :");
		K_largest(cpy, k);
	}
	//Using the max Heap
	//Complexity : O(N) + O(N log N) + O(k log N) 
	public static void find(int ar[], int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0;i < ar.length; i++)
			maxHeap.add(ar[i]);
		
		for(int i = 0; i < k - 1; i++)
			maxHeap.poll();
		System.out.println(maxHeap.poll());
	}
	//Using min Heap
	//Complexity: N log k
	public static void find1(int ar[], int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i : ar) {
			
			if(minHeap.size() < k)
				minHeap.add(i);
			
			else {
				
				if(i > minHeap.peek()) {
					minHeap.poll();
					minHeap.add(i);
				}
			}
		}
		System.out.println(minHeap.peek());
	}
	public static void K_largest(int ar[], int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i : ar) {
			
			if(minHeap.size() < k)
				minHeap.add(i);
			
			else {
				
				if(i > minHeap.peek()) {
					minHeap.poll();
					minHeap.add(i);
				}
			}
		}
		while(!minHeap.isEmpty())
			System.out.println(minHeap.poll());
	}
}
