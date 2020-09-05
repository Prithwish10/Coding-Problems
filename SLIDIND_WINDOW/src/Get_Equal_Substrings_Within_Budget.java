//You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.
//
//You are also given an integer maxCost.
//
//Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.
//
//If there is no substring from s that can be changed to its corresponding substring from t, return 0.
//
// 
//
//Example 1:
//
//Input: s = "abcd", t = "bcdf", maxCost = 3
//Output: 3
//Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
//Example 2:
//
//Input: s = "abcd", t = "cdef", maxCost = 3
//Output: 1
//Explanation: Each character in s costs 2 to change to charactor in t, so the maximum length is 1.
//Example 3:
//
//Input: s = "abcd", t = "acde", maxCost = 0
//Output: 1
//Explanation: You can't make any change, so the maximum length is 1.

public class Get_Equal_Substrings_Within_Budget {

	public int equalSubstring(String s, String t, int maxCost) {
        
        if(s == null || t == null || s.length() == 0)
            return 0;
        
        int ar[] = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            
            ar[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        
        int start = 0, end = 0, max = 0, sum = 0;
        
        while(end < ar.length){
            
            sum += ar[end];
            
            if(sum <= maxCost)
                max = Math.max(max, end - start + 1);
            
            while(sum > maxCost){
                
                sum -= ar[start];
                start ++;
            }
            
            end ++;
        }
        return max;
    }
}
