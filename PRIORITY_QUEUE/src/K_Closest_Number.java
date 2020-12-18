import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;;
public class K_Closest_Number {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the numbers :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter the number whose closest you need to find :");
		int cn = sc.nextInt();
		
		System.out.println("Enter k :");
		int k = sc.nextInt();
		
		Object1 temp[] = new Object1[n];
		
		for(int i = 0; i < n; i++) {
			temp[i] = new Object1(ar[i], Math.abs(ar[i] - cn));
		}
		
		//findKClosest1(temp, n, k);
		findKClosest2(ar, n, k, cn);
	}
	//Approach 1
	//Time- O(n log n)
	//Space - O(n)
	
	public static void findKClosest(Object1 temp[], int n, int k) {
		
		Arrays.sort(temp, new Comparator<Object1>(){
			
			public int compare(Object1 o1, Object1 o2) {
				
				return o1.diff - o2.diff;
			}
		});
		
		for(int i = 0; i < k; i++)
			System.out.print(temp[i].ele+" ");
	}
	//Approach 2
	//Time - O(n log K)
	//Space - O(n)
	public static void findKClosest1(Object1 temp[], int n, int k) {
		
		PriorityQueue<Object1> maxHeap = new PriorityQueue<Object1>(
				(n1, n2) -> n2.diff - n1.diff);
		
		for(int i = 0; i < n; i++) {
			
			if(maxHeap.size() < k)
				maxHeap.add(temp[i]);
			else {
				if(maxHeap.peek().diff > temp[i].diff) {
					maxHeap.poll();
					maxHeap.add(temp[i]);
				}
			}
		}
		while(!maxHeap.isEmpty())
			System.out.print(maxHeap.poll().ele+" ");
	}
	//Approach 3
	//Time - O(n log K)
	//Space - O(n)
	// For Duplicate elements in the array this approach will give different answer
	public static void findKClosest2(int ar[], int n, int k, int cn) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i= 0; i < n; i++)
			map.put(ar[i], Math.abs(ar[i] - cn));
		
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(n1, n2) -> n2.getValue() - n1.getValue());
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			if(maxHeap.size() < k)
				maxHeap.add(entry);
			else {
				if(entry.getValue() < maxHeap.peek().getValue()) {
					maxHeap.poll();
					maxHeap.add(entry);
				}
			}
		}
		while(!maxHeap.isEmpty())
			System.out.print(maxHeap.poll().getKey()+" ");
	}
}
class Object1{
	
	int ele;
	int diff;
	
	Object1(int ele, int diff){
		this.ele = ele;
		this.diff = diff;
	}
}