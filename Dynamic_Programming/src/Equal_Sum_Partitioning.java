import java.util.Scanner;
public class Equal_Sum_Partitioning {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many elements do u want to enter :");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements :");
		int set[] = new int[n];
		
		for(int i = 0; i < n; i++)
			set[i] = sc.nextInt();
		
		System.out.println(isPresent(set, n));
		
		//System.out.println(isPresent(set, cache, sum, n));
	}
	public static boolean isPresent(int set[], int n) {
		
		// First check if the sum of elements is even or not. 
		int sum = 0;
		for(int i : set)
			sum += i;
		//If its odd then its sure that equal sum partitioning cannot be done
		if(sum % 2 != 0)
			return false;
		
		boolean cache[][] = new boolean[n + 1][sum + 1];
		
		//Else check if sum/2 is present in the set or not. If present return true else return false.
		//Ex: set[] = {1, 5, 11, 5}
		// 1 + 5 + 11 + 5 = 22(Even) So there is a possibility that it can be partitioned in such a way that both partitions have equal sum
		//i.e., 22/2 = 11. So find 11 in the set.
		//return isSubset(set, sum/2, n);
		
		
		return isSubset(set, cache, sum/2, n);
	}
	//Recursion
	public static boolean isSubset(int set[], int sum, int n) {
		
		if(sum == 0)
			return true;
		
		if(n == 0 && sum != 0)
			return false;
		
		if(set[n - 1] > sum)
			return isSubset(set, sum, n - 1);
		
		return isSubset(set, sum - set[n - 1], n - 1) || isSubset(set, sum, n - 1);
	}
	//Memoization
	public static boolean isSubset(int set[], boolean cache[][], int sum, int n) {
		
		if(sum == 0)
			return cache[n][sum] = true;
		
		if(n == 0 && sum != 0)
			return false;
		
		if(cache[n][sum] != false)
			return cache[n][sum];
		
		if(set[n - 1] > sum)
			return cache[n][sum] = isSubset(set, sum, n - 1);
		
		return cache[n][sum] = isSubset(set, sum - set[n - 1], n - 1) || isSubset(set, sum, n - 1);
	}
}
