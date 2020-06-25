import java.util.Arrays;

public class LCS {

	public static void main(String args[]) {
		
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		
//		int res = lcs_Recur(s1, s2, 0, 0);
//		System.out.println(res);
		
		int cache[][] = new int[s1.length() + 1][s2.length() + 1];
		
		for(int[] row : cache)
			Arrays.fill(row, -1);
		int res1 = lcs_Memo(s1, s2, 0, 0, cache);
		System.out.println("Length of LCS : "+res1);
	}
	
	// Time : O(2^n)
	// Space : O(m * n)
	public static int lcs_Recur(String s1, String s2, int i, int j){
		
		if(i == s1.length() || j == s2.length())
			return 0;
		
		if(s1.charAt(i) == s2.charAt(j))
			return 1 + lcs_Recur(s1, s2, i + 1, j + 1);
		
		else
			return Math.max(lcs_Recur(s1, s2, i + 1, j), lcs_Recur(s1, s2, i, j + 1));
	}
	
	// Time : O(m * n)
	// Space : O(m * n)
	public static int lcs_Memo(String s1, String s2, int i, int j, int cache[][]) {
		
		if(i == s1.length() || j == s2.length())
			return cache[i][j] = 0;
		
		if(cache[i][j] != -1)
			return cache[i][j];
		
		if(s1.charAt(i) == s2.charAt(j))
			return cache[i][j] = 1 + lcs_Recur(s1, s2, i + 1, j + 1);
		
		else
			return cache[i][j] = Math.max(lcs_Recur(s1, s2, i + 1, j), lcs_Recur(s1, s2, i, j + 1));
	}
}
