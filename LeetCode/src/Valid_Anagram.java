import java.util.HashMap;
import java.util.Map;

class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        
//         char s1[] = s.toCharArray();
//         char t1[] = t.toCharArray();
        
//         Arrays.sort(s1);
//         Arrays.sort(t1);
        
//         if(s1.length != t1.length)
//             return false;
        
//         for(int i = 0; i < s1.length; i++){
            
//             if(s1[i] != t1[i])
//                 return false;
//         }
//         return true;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        
        for(int i = 0; i < t.length(); i++){
            
            if(map.containsKey(t.charAt(i))){
                
                if(map.get(t.charAt(i)) == 1)
                    map.remove(t.charAt(i));
                else
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
            else
                return false;
        }
        if(map.size() == 0)
            return true;
        return false;
    }
}
