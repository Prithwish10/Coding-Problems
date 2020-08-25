//Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
//
//Example :
//Input: 
//S = "abcde"
//words = ["a", "bb", "acd", "ace"]
//Output: 3
//Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".

import java.util.HashSet;
import java.util.Set;

//Time : O(words.length * s)

public class Number_Of_Matching_Subsequence {

	Set<String> sub = new HashSet<>();
    Set<String> nonSub = new HashSet<>();
    
    public int numMatchingSubseq(String s, String[] words) {
        
        int count = 0;
        
        for(int i = 0; i < words.length; i++){
            
            if(sub.contains(words[i])){
                count ++;
                continue;
            }
            
            else if(nonSub.contains(words[i]))
                continue;
            
            if(isSubsequence(words[i], s))
                count ++;
        }
        return count;
    }
    private boolean isSubsequence(String s, String t){
        
        if(s == null || t == null || (t.length() == 0 && s.length() != 0))
            return false;
        
        if(s.length() == 0)
            return true;
        
        int i = 0, j = 0;
        
        while(i < s.length() && j < t.length()){
            
            while(j < t.length() && s.charAt(i) != t.charAt(j))
                j ++;
            
            if(j == t.length()){
                nonSub.add(s);
                return false;
            }
            
            i++;
            j ++;
        }
        if(i == s.length()){
            sub.add(s);
            return true;
        }
        nonSub.add(s);
        return false;
    }
}
