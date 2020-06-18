import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Least_Number_Of_Uniqueue_Integers_Afterremoving_K {

	public static void main(String args[]) {
		
		int ar[] = {1,1,2,2,3,3};
		findLeastNumOfUniqueInts(ar, 3);
	}
	public static void findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
       PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                                        (n1, n2) -> n1.getValue() - n2.getValue());
        
       minHeap.addAll(map.entrySet());
       
        while(k != 0) {
        	
        	Map.Entry<Integer, Integer> p = minHeap.poll();
        	int key = p.getKey();
        	int value = p.getValue();
        	
        	if(value > k) {
        		map.put(key, value - k);
        		break;
        	}
        	k = k - value;
        	map.remove(key);
        }
        System.out.println(map.size());
    }
}
