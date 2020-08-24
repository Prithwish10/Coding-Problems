import java.util.Scanner;
public class Minimum_Bits_To_Change_To_Convert_a_To_b {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a and b :");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int res = findMinBitsToChange(a, b);
		System.out.println(res);
		System.out.print((11&1));
	}
	private static int findMinBitsToChange(int a, int b) {
		
		int xor = a ^ b;
		return countsetbits_fast(xor);
	}
	//Time : O(number of bits)
	private static int countsetbits(int n) {
		
		int count = 0;
		
		while(n > 0) {
			
			count += (n & 1);
			n = n >> 1;
		}
		return count;
	}
	// Time : O(no of set bits)
	private static int countsetbits_fast(int n) {
		
		int count = 0;
        
        while(n > 0){
            
            n = n & (n - 1);
            count ++;
        }
        return count;
	}
}
