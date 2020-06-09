package abd;
// Sort the elements according to the frequency
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Frequency_Sort {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the elemenst into the array :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		List<Integer> list = sortByFrequency(ar);
		
		for(int i : list)
			System.out.print(i+" ");
	}
	public static List<Integer> sortByFrequency(int ar[]) {
		
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		for(int i : ar)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		//This will Sort the elements in the descending order of there frequency
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer,Integer>>(
				(n1, n2) -> n2.getValue() - n1.getValue());
		
		maxHeap.addAll(map.entrySet());
		
		List<Integer> list = new ArrayList<Integer>();
		
		while(!maxHeap.isEmpty()) {
			list.add(maxHeap.poll().getKey());
		}
		return list;
	}
}
