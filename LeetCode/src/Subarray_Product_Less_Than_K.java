import java.util.Scanner;

public class Subarray_Product_Less_Than_K {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements you want to enetr :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		System.out.println("Enter the elements into the array :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter k :");
		int k = sc.nextInt();
		
		System.out.println(countSubarray(ar, k, n));
	}
	public static int countSubarray(int ar[], int k, int n) {
		
		int mul = 1;
		int res = 0;
		int left = 0;
		if(k <= 1)
            return res;
		for(int right = 0; right < n; right ++) {
			
			mul *= ar[right];
			
			while(mul >= k) {
				
				mul /= ar[left];
				left ++;
			}
			res += (right - left + 1);
		}
		return res;
	}
}
