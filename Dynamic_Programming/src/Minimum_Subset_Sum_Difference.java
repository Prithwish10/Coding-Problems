import java.util.Scanner;
public class Minimum_Subset_Sum_Difference {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many elements do u want to enter :");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements :");
		int set[] = new int[n];
		
		for(int i = 0; i < n; i++)
			set[i] = sc.nextInt();
		
		//System.out.println(subSetSumDiff(set, n));
		
		
		System.out.println(subSetSumDiff(set, n));
	}
	public static int subSetSumDiff(int set[], int n) {
		
		int sum = 0;
		
		for(int i = 0; i < n; i++)
			sum += set[i];
		
		//return minDiff(set, n, 0, sum);
		
		int cache[][] = new int[n + 1][sum + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= sum; j++)
				cache[i][j] = -1;
		}
		return minDiff_memo(set, cache, n, 0, sum);
	}
	public static int minDiff(int set[], int n, int firstSet, int secondSet) {
		
		//When we reach the end of the set array then we see what is the difference between the sum in first set 
		//and the sum in second set, and we simply return the absolute difference.
		
		//second set sum can easily be calculated by subtracting the firstset sum by the total sum of the set 
		//i.e., secondSet sum = totalsum - firstSet sum
		if(n == 0)
			return Math.abs(firstSet - (secondSet - firstSet));
		
		// for every item in the set array we have two choices 
		//i.e., either include the nth element to the first set or not include it
		//If we include the nth item to the first set then we increase the sum in the firstSet by ar[n - 1]
		return Math.min(minDiff(set, n - 1, firstSet + set[n - 1], secondSet), 
				minDiff(set, n - 1, firstSet, secondSet));
	}
	
	public static int minDiff_memo(int set[], int cache[][], int n, int firstSet, int secondSet) {
		
		if(n == 0)
			return cache[n][firstSet] = Math.abs(firstSet - (secondSet - firstSet));
		
		if(cache[n][firstSet] != -1)
			return cache[n][firstSet];
		
		return cache[n][firstSet] = Math.min(minDiff_memo(set, cache, n - 1, firstSet + set[n - 1], secondSet), 
				minDiff_memo(set, cache, n - 1, firstSet, secondSet));
	}
}
