//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

//Example 1:

//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
//Example 2:
//
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
//Example 3:

//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
//Example 4:

//Input: pattern = "abba", s = "dog dog dog dog"
//Output: false

import java.util.HashMap;
import java.util.Map;

public class Word_Pattern {

	public boolean wordPattern(String pattern, String s) {
        
        if(pattern == null || s == null) return false;
        
        Map<Character, String> map = new HashMap<>();
        
        int i = 0, j = 0;
        
        String words[] = s.split(" ");
        
        if(pattern.length() != words.length) return false;
        
        while(i < pattern.length() && j < words.length){
            
            char key = pattern.charAt(i);
            String value = words[j];
            
            if(!map.containsKey(key) && !map.containsValue(value))
                map.put(key, value);
            
            else if(map.containsKey(key) && map.get(key).equals(value)){
                
                i ++;
                j ++;
                continue;
            }
            
            else
                return false;
            
            i ++;
            j ++;
        }
        return true;
    }
}
