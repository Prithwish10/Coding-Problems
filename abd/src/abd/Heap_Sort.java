package abd;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Heap_Sort {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no of elemenst into the array :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the elements into the array :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		sort(ar);
	}
	public static void sort(int ar[]) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i = 0; i < ar.length; i++)
			minHeap.add(ar[i]);
		int i = 0;
		while(!minHeap.isEmpty()) {
			ar[i] = minHeap.poll();
			i++;
		}
		for(int j : ar)
			System.out.print(j+" ");
	}
}
