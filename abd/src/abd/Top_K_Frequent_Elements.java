package abd;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Top_K_Frequent_Elements {

	public static void main(String args[]) {
		
		int ar[] = {1, 2, 10, 1, 13, 11, 1, 10, 13, 7, 9, 13, 1};
		
		int k = 3;
		
		List<Integer> res = find(ar, k);
		
		for(int i : res)
			System.out.print(i+" ");
	}
	public static List<Integer> find(int ar[], int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i : ar)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
				(n1, n2) -> n1.getValue() - n2.getValue());
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			if(minHeap.size() < k) {
				minHeap.add(entry);
			}
			else {
				if(entry.getValue() > minHeap.peek().getValue()) {
					minHeap.poll();
					minHeap.add(entry);
				}
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		
		while(!minHeap.isEmpty()) {
			list.add(minHeap.poll().getKey());
		}
		return list;
	}
}
