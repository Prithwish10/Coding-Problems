import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class Maximum_Sum_Window {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		
		int n = sc.nextInt();
		int ar[] = new int[n];
		System.out.println("Enter the elements into the window :");
		
		for(int i = 0; i < n; i ++)
			ar[i] = sc.nextInt();
		
		findMaxWindow(ar, n, 3);
	}
	
	public static void findMaxWindow(int ar[], int n, int k) {
		
		Deque<Integer> queue = new LinkedList<Integer>();
		
		int i = 0;
		
		for(i = 0; i < k; i++) {
			
			while(!queue.isEmpty() && ar[queue.peekLast()] <= ar[i])
				queue.removeLast();
			
			queue.add(i);
		}
		
		for(;i < n; i++) {
			
			System.out.print(ar[queue.peek()]+" ");
			
			while(!queue.isEmpty() && queue.peek() <= i - k)
				queue.removeFirst();
			
			while(!queue.isEmpty() && ar[queue.peekLast()] <= ar[i])
				queue.removeLast();
			
			queue.add(i);
		}
		System.out.print(ar[queue.peek()]);
	}
}
