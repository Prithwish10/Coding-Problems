import java.util.Scanner;
public class SubSet_Sum {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many elements do u want to enter :");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements :");
		int set[] = new int[n];
		
		for(int i = 0; i < n; i++)
			set[i] = sc.nextInt();
		
		System.out.println("Enter the sum :");
		int sum = sc.nextInt();
		
		System.out.println(isPresent(set, sum, n));
		
		boolean cache[][] = new boolean[n + 1][sum + 1];
		System.out.println(isPresent1(set, cache, sum, n));
	}
	public static boolean isPresent(int set[], int sum, int n) {
		// if the sum is 0 then we should return true
		if(sum == 0)
			return true;
		// If there are no elements in the set then we cannot get the sum, unless the sum is 0. So return false
		if(n == 0)
			return false;
		// If the nth items weight/value is greater than the sum itself than we should neglect it and recur for n - 1
		if(set[n - 1] > sum)
			return isPresent(set, sum, n - 1);
		// return the result either by including the nth item or not including the nth item.And return the || result
		return isPresent(set, sum - set[n - 1], n - 1) || isPresent(set, sum, n - 1);
	}
	public static boolean isPresent1(int set[], boolean cache[][], int sum, int n) {
		
		if(sum == 0)
			return cache[n][sum] = true;
		
		if(n == 0)
			return cache[n][sum] = false;
		
		if(set[n - 1] > sum)
			return cache[n][sum] = isPresent1(set, cache, sum, n - 1);
		
		return cache[n][sum] = isPresent1(set, cache, sum - set[n - 1], n - 1) || isPresent(set, sum, n - 1);
	}
}
