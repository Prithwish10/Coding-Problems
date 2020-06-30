import java.util.Arrays;
import java.util.Scanner;
public class Count_Subset_Sum_With_GivenSum {

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
		
		System.out.println(countSubset(set, sum, n));
		
		int cache[][] = new int[n + 1][sum + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= sum; j++)
				cache[i][j] = -1;
		}
		System.out.println(countSubset(set, cache, sum, n));
	}
	
	public static int countSubset(int set[], int sum, int n) {
		// If the sum is 0 then we can only make 1 subset i.e., {}
		if(sum == 0)
			return 1;
		if(n == 0 && sum !=0)
			return 0;
		
		if(set[n - 1] > sum)
			return countSubset(set, sum, n - 1);
		
		return countSubset(set, sum - set[n - 1], n - 1) + countSubset(set, sum, n - 1);
	}
	public static int countSubset(int set[], int cache[][], int sum, int n) {
		// If the sum is 0 then we can only make 1 subset i.e., {}
		if(sum == 0)
			return cache[n][sum] = 1;
		if(n == 0 && sum !=0)
			return cache[n][sum] = 0;
		
		if(cache[n][sum] != -1)
			return cache[n][sum];
		
		if(set[n - 1] > sum)
			return cache[n][sum] = countSubset(set, cache, sum, n - 1);
		
		return cache[n][sum] = countSubset(set, cache, sum - set[n - 1], n - 1) + countSubset(set, cache, sum, n - 1);
	}
}
