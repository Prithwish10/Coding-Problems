//Given a string s and a string t, check if s is subsequence of t.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
//
//Follow up:
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
//
//Credits:
//Special thanks to @pbrother for adding this problem and creating all test cases.
//
// 
//
//Example 1:
//
//Input: s = "abc", t = "ahbgdc"
//Output: true
//Example 2:
//
//Input: s = "axc", t = "ahbgdc"
//Output: false
public class Is_Subsequence {

	//Time : O(t.length())
	public boolean isSubsequence(String s, String t) {
        
        if(s == null || t == null || (t.length() == 0 && s.length() != 0))
            return false;
        
        if(s.length() == 0)
            return true;
        
        int i = 0, j = 0;
        
        while(i < s.length() && j < t.length()){
            
            while(j < t.length() && s.charAt(i) != t.charAt(j))
                j ++;
            
            if(j == t.length())
                return false;
            
            i++;
            j ++;
        }
        if(i == s.length())
            return true;
        
        return false;
    }
}
