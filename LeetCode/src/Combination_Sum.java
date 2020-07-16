import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Combination_Sum {

	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of marks :");
		int n = sc.nextInt();
		
		int marks[] = new int[n];
		
		System.out.println("Enter the marks :");
		for(int i = 0; i < n; i++)
			marks[i] = sc.nextInt();
		
		System.out.println("Enter the target sum :");
		int target = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		
		combinationSum(marks, target, n, list);
		System.out.println(res);
	}
	
	public static void combinationSum(int marks[], int target, int n, List<Integer> list) {
		
		if(target == 0) {	
			res.add(new ArrayList<Integer>(list));
			return;
		}
		if(n == 0 || target < 0)
			return;
		
//		if(marks[n] > target)
//			combinationSum(marks, target, n - 1, list);
		
		list.add(marks[n - 1]);
		
		combinationSum(marks, target - marks[n - 1], n, list);
		
		list.remove(list.size() - 1);
		
		combinationSum(marks, target, n - 1, list);
		
	}
	
}
