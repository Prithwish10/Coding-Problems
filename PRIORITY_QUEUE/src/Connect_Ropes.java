//Connect Ropes to minimize cost
import java.util.PriorityQueue;
import java.util.Scanner;
public class Connect_Ropes {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the length of each rope :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the numbers :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		int res = findMinCost(ar, n);
		System.out.println(res);
	}
	public static int findMinCost(int ar[], int n) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(
				(n1, n2) -> n1.compareTo(n2));
		
		for(int i : ar)
			minHeap.add(i);
		
		if(minHeap.size() == 0)
			return 0;
		
		int res = 0;
		
		while(minHeap.size() != 1) {
			
			int a = minHeap.poll();
			int b = minHeap.poll();
			
			int c = a + b;
			res += a + b;
			
			minHeap.add(c);
		}
		return res == 0 ? minHeap.poll() : res;
	}
}
