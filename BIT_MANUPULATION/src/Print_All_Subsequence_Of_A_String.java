// All Possible Subsequence using Bit Masking

import java.util.Scanner;

public class Print_All_Subsequence_Of_A_String {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = sc.next();
		findAllSubsequences(s);
	}
	public static void findAllSubsequences(String s){
		
		int range = (1 << s.length()) - 1;
		for(int index = 0; index <= range; index ++){
			helper(s,index);
		}
	}
	public static void helper(String s, int n){
		
		int index = s.length() - 1;
		while(n > 0){
			if((n & 1) == 1)
				System.out.print(s.charAt(index));
			else
				System.out.print("");
			index --;
			n = n >> 1;
		}
		System.out.println();
	}
}
