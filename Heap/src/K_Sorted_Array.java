import java.util.PriorityQueue;
import java.util.Scanner;
public class K_Sorted_Array {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the elements into the array :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter k :");
		int k = sc.nextInt();
		
		findKClosest(ar,n, k);
	}
	public static void findKClosest(int ar[], int n, int k) {
		
		int j = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i = 0; i < n; i++) {
			
			if(minHeap.size() < k)
				minHeap.add(ar[i]);
			else {
				
				minHeap.add(ar[i]);
				ar[j] = minHeap.poll();
				j ++;
			}
		}
		while(!minHeap.isEmpty()) {
			
			ar[j] = minHeap.poll();
			j++;
		}
		
		for(int i : ar)
			System.out.print(i+" ");
	}
}
