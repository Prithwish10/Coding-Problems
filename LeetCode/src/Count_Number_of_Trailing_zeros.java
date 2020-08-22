import java.util.Scanner;

public class Count_Number_of_Trailing_zeros {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number :");
		int num = sc.nextInt();
		
		findTrailingZeros(num);
	}
	public static void findTrailingZeros(int num) {
		
		String a = "";
		
		while(num > 0) {
			
			int rem = num % 2;
			a = rem + a;
			num = num / 2;
		}
		int zeros = 0;
		for(int i = a.length() - 1; i >= 0; i --)
		{
			if(a.charAt(i) == '0') {
				zeros ++;
			}
			else
				break;
		}
		System.out.println(zeros);
		
	}
}
