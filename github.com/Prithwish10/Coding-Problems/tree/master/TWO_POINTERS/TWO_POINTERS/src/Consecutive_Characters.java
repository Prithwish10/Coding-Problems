//Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
//
//Return the power of the string.
//
// 
//
//Example 1:
//
//Input: s = "leetcode"
//Output: 2
//Explanation: The substring "ee" is of length 2 with the character 'e' only.
//Example 2:
//
//Input: s = "abbcccddddeeeeedcba"
//Output: 5
//Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

public class Consecutive_Characters {

	public int maxPower(String s) {
        
        if(s == null) return 0;
        
        int power = 1, i = 0, j = 0, n = s.length();
        
        while(i < n){
            
            char ch = s.charAt(i);
            
            while(j < n && ch == s.charAt(j)){
                j ++;
            }
            power = Math.max(power, j - i);
            
            i = j;
        }
        return Math.max(power, j - i);
    }
}
