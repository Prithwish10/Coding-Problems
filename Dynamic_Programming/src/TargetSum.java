import java.util.Scanner;

//In this problem given an array and a value.
//We can either add a +ve sign or a -ve sign beside each element in the array
//By doing these we need to return the count of total number of ways that we are getting the target value. 
public class TargetSum {

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
		
		//System.out.println(count(set, sum, n, 0));
		
		int cache[][] = new int[n + 1][sum + 1];
		
		for(int i = 0; i <= n; i++) {
			
			for(int j = 0; j <= sum; j ++) {
				cache[i][j] = -1;
			}
		}

		System.out.println(count1(set, cache, sum, n, 0));
	}
	public static int count(int set[], int sum, int n, int target) {
		
		if(n == 0 && target == sum)
			return 1;
		
		if(sum == 0)
			return 1;
		
		if(n == 0 && sum != 0)
			return 0;
		
		return count(set, sum, n - 1, target + set[n - 1]) + count(set, sum, n - 1, target - set[n - 1]);
	}
	
	public static int count1(int set[], int cache[][], int sum, int n, int target) {
		
		if(n == 0 && target == sum)
			return cache[n][sum] = 1;
		
		if(sum == 0)
			return cache[n][sum] = 1;
		
		if(n == 0 && sum != 0)
			return cache[n][sum] = 0;
		
		if(cache[n][sum] != -1)
			return cache[n][sum];
		
		return cache[n][sum] =  count1(set, cache, sum, n - 1, target + set[n - 1]) + 
				count1(set, cache, sum, n - 1, target - set[n - 1]);
	}
}
