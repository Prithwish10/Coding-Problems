import java.util.Scanner;
public class Number_of_Trailing_Zeros {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter n :");
		int n = sc.nextInt();
		
		int res = countTrailingZeros(n);
		System.out.println(res);
	}
	//Time : O(no of trailing zeros)
	private static int countTrailingZeros(int n) {
		
		int count = 0;
		
		while(true) {
			
			int res = n & 1;
			
			if(res == 0)
				count ++;
			else
				break;
			
			n = n >> 1;
		}
		return count;
	}
	
}
