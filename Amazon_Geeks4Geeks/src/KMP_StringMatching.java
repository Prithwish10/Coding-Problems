import java.util.Scanner;
public class KMP_StringMatching {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the text :");
		String txt = sc.next();
		
		System.out.println("Enter the pattern :");
		String pat = sc.next();
		
		findPositionOfMatch(txt, pat);
	}
	
	public static void findPositionOfMatch(String txt, String pat) {
		
		if(txt.length() == 0 && pat.length() == 0)
            return;
        if(pat.length() == 0)
            return;
        
		int M = pat.length();
		int N = txt.length();
		
		int prefixArray[] = findPrefixArray(pat, M);
		
		int i = 0; // Represent the index of the text
		int j = 0; // Represent the index of the pattern
		
		while(i < N) {
			
			if(pat.charAt(j) == txt.charAt(i)) {
				i ++;
				j ++;
			}
			if(j == M) {
				
				System.out.println("First position the match occurs at "+(i - j));
			}
			else if(i < N && pat.charAt(j) != txt.charAt(i)) {
				
				if(j != 0)
					j = prefixArray[j - 1];
				else
					i ++;
			}
		}
	}
	
	public static int[] findPrefixArray(String pat, int M) {
		
		int preArr[] = new int[M];
		
		int i = 1;
		int j = 0;
		
		while(i < M) {
			
			if(pat.charAt(i) == pat.charAt(j)) {
				
				preArr[i] = j + 1;
				i ++;
				j ++;
			}
			else {
				
				if(j != 0) {
					j = preArr[j - 1];
				}
				else {
					preArr[i] = j;
					i ++;
				}
			}
		}
		return preArr;
	}
}
