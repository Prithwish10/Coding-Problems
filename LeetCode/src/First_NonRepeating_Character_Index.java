import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class First_NonRepeating_Character_Index {

public int firstUniqChar(String s) {
        
        if(s == null || s.length() == 0)
            return -1;
        
        Map<Character, ArrayList<Integer>> map = new LinkedHashMap<Character, ArrayList<Integer>>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
                map.get(s.charAt(i)).add(i);
            else{
                
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i), list);
            }
        }
        
        for(Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()){
            
            if(entry.getValue().size() == 1)
                return entry.getValue().get(0);
        }
        return -1;
    }
}
