import java.util.Scanner;

public class Unique_Number_II {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Ente the numbers :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		findUniqueNumber(ar, n);
	}
	public static void findUniqueNumber(int ar[], int n) {
		
		// XOR all numbers
		int res = ar[0];
		
		for(int i = 1; i < n; i++) {
			res = res ^ ar[i];
		}
		
		//Find the right most set bit in the res
		int i = 0;
		int temp = res;
		
		while(temp > 0) {
			
			if((temp & 1) == 1)
				break;
			temp = temp >> 1;
			i ++;
		}
		int mask = 1 << i;
		temp = 0;
		for(i = 0; i < n; i++) {
			if((ar[i] & mask) == 0)
				temp = temp ^ ar[i];
		}
		System.out.println(temp);
		
		temp = temp ^ res;
		System.out.println(temp);
	}
}
