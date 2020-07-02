import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Top_K_Frequent_Number {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the numbers :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter k :");
		int k = sc.nextInt();
		
		topKFrequent(ar, n, k);
	}
	public static void topKFrequent(int ar[], int n, int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i : ar)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
				(n1,n2) -> n1.getValue() - n2.getValue());
		//1 2 3 1 4 1 3 3
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			if(minHeap.size() < k)
				minHeap.add(entry);
			else {
				if(minHeap.peek().getValue() < entry.getValue()) {
					minHeap.poll();
					minHeap.add(entry);
				}
			}
		}
		while(!minHeap.isEmpty())
			System.out.print(minHeap.poll().getKey()+" ");
	}
}
