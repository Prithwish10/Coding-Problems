import java.util.Scanner;

class Solution {
    public int[] plusOne(int[] digits) {
        
        int i = digits.length - 1;
        int carry = 1;
        
        do{
            
            if(digits[i] == 9){
                digits[i] = (digits[i] + carry) % 10;
                carry = 1;
            }
            else{
                digits[i]= digits[i]+carry;
                carry = 0;
                
            }
            i--;
        }while(i >= 0 && carry != 0);
        
        if(carry == 1){
            
            int res[] = new int[digits.length+1];
            
            res[0] = carry;
            
            for(int j = 0; j < digits.length; j++)
                res[j+1] = digits[j];
            return res;
        }
        
        return digits;
    }
}
public class Plus_One {

	public static void main(String args[]) {
		Solution obj = new Solution();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n :");
		int n = sc.nextInt();
		int ar[] = new int[n];
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		int res[] = obj.plusOne(ar);
		
		for(int i : res)
			System.out.print(res[i]);
	}
}
