import java.util.Scanner;

public class Ugly_Number {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter n :");
		int n = sc.nextInt();
		
		System.out.println(find(n));
		isUgly1(n);
	}
	//Brute force
	
	public static int find(int n) {
		
		int i = 2;
		int c = 1;
		
		if(n == 1)
			return i;
		
		while(true) {
			
			if(isUgly(i)) {
				c ++;
				//System.out.println(i);
			}
			if(c == n)
				return i;
			
			i ++;
		}
	}
	public static boolean isUgly(int n) {
	
		while(n % 2 == 0 && n != 0) 
			n /= 2;
	
		while(n % 3 == 0 && n != 0)
			n /= 3;
	
		while(n % 5 == 0 && n != 0)
			n /= 5;
		
		if(n == 1)
			return true;
		return false;
	}
	//Dp 
	public static void isUgly1(int n) {
		
		int ar[] = new int[n];
		
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		ar[0] = 1;
		
		int nm2 = ar[i2] * 2;;
		int nm3 = ar[i3] * 3;
		int nm5 = ar[i5] * 5;
		
		for(int i = 1; i < n; i++) {
			
			int min = Math.min(nm2, Math.min(nm3, nm5));
			ar[i] = min;
			
			if(nm2 == min) {
				
				i2 = i2 + 1;
				nm2 = ar[i2] * 2;
			}
			if(nm3 == min) {
				
				i3 = i3 + 1;
				nm3 = ar[i3] * 3;
			}
			if(nm5 == min) {
				
				i5 = i5 + 1;
				nm5 = ar[i5] * 5;
			}
		}
		System.out.println(ar[n - 1]);
	}
}
