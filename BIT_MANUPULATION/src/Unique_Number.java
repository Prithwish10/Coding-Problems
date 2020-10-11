//Given a list of integers where every numbers occur twice except one number.
//Find that unique number.

import java.util.Scanner;

public class Unique_Number {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Ente the numbers :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println(findUniqueNumber(ar, n));
	}
	public static int findUniqueNumber(int ar[], int n) {
		
		if(ar == null || ar.length == 0)
			return -1;
		
		int res = ar[0];
		
		for(int i = 1; i < n; i++) {
			res = res ^ ar[i];
		}
		return res;
	}
}
