import java.util.PriorityQueue;

public class First_Largest_K_Element {

	public static void main(String args[]) {
		
		int ar[] = {3, 7, 1, 5, 9, 11, 6, -2, 0, 14, 10};
		
		find(ar, ar.length, 3);
	}
	public static void find(int ar[], int n, int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i: ar) {
			
			if(minHeap.size() < k) {
				minHeap.add(i);
			}
			else {
				if(minHeap.peek() < i) {
					minHeap.poll();
					minHeap.add(i);
				}
			}
		}
		int sum = 0;
		
		System.out.println("The first k largest elements are :");
		
		while(!minHeap.isEmpty()) {
			n = minHeap.poll();
			sum += n;
			System.out.print(n+" ");
		}
		System.out.println("\nThe sum of the elements are :"+sum);
		
	}
}
