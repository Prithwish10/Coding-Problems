//A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
//
// 
//
//Example 1:
//
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

import java.util.*;

public class Partition_Labels {

	public List<Integer> partitionLabels(String s) {
        
        List<Integer> res = new ArrayList<>();
        
        if(s == null || s.length() == 0)
            return res;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        Set<Character> set = new HashSet<>();
        
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(!set.contains(ch))
                set.add(ch);
            
            map.put(ch, map.get(ch) - 1);
            
            if(map.get(ch) == 0)
                set.remove(ch);
            
            count ++;
            
            if(set.size() == 0){
                res.add(count);
                count = 0;
            }
        }
        return res;
    }
}
