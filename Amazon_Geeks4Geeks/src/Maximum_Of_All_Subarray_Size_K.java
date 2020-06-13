import java.util.Collections;
import java.util.PriorityQueue;

public class Maximum_Of_All_Subarray_Size_K {

	public static void main(String args[]) {
		
		int ar[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		
		find(ar, 4);
	}
	//Using a maximum Heap
	//Time Complexity : O(N log k)
	//Space Complexity : O(k)
	public static void find(int ar[], int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i : ar) {
			
			if(maxHeap.size() < k) {
				
				maxHeap.add(i);
			}
			
			else {
				
				System.out.print(maxHeap.peek()+" ");
				if(i > maxHeap.peek()) {
					maxHeap.poll();
					maxHeap.add(i);
				}
			}
		}
		System.out.print(maxHeap.peek());
	}
}
