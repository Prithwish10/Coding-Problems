import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class All_Distinct_Subsequences {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number do u want to enter :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		System.out.println("Enter the elements :");
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		distinctSubsequence(ar, 0, list);
		System.out.println(res);
		
	}
	static List<List<Integer>> res = new LinkedList<>();
	public static void distinctSubsequence(int ar[], int p, LinkedList<Integer> list) {
		
		if(p >= ar.length) {
			if(list.size() == 2)
			{
				//System.out.println(list);
				res.add(new LinkedList<>(list));
			}
			return;
		}
		
		list.add(ar[p]);
		distinctSubsequence(ar, p + 1, list);
		
		list.removeLast();
		
		distinctSubsequence(ar, p + 1, list);
	}
}
