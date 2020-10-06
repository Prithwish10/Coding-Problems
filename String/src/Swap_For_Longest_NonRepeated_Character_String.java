import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Swap_For_Longest_NonRepeated_Character_String {

	public int maxRepOpt1(String text) {
        
        if(text == null || text.length() == 0) return 0;
        
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < text.length(); i++){
            
            char ch = text.charAt(i);
            List<Integer> l;
            
            if(map.containsKey(ch)){
                l = map.get(ch);
            }else{
                l = new ArrayList<>();
            }
            l.add(i);
            map.put(ch, l);
        }
        List<List<Integer>> groups = new ArrayList<>();
        
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
            
            groups.add(entry.getValue());
        }
        
        int cur, prev, res = 1, sum = 1;
        boolean flag = false;
        
        for(int i = 0; i < groups.size(); i++){
            
            List<Integer> l = groups.get(i);
            cur = 1; prev = 0;
            sum = 0;
            
            for(int j = 1; j < l.size(); j ++){
                
                if(l.get(j) == l.get(j - 1) + 1)
                    cur ++;
                else{
                    if(l.get(j) == l.get(j - 1) + 2){
                        prev = cur;
                        cur = 1;
                    }
                    else{
                        cur = 1;
                        prev = 0;
                    }
                }
                sum = Math.max(sum, cur + prev);
                
               
            }
            
            if(sum < l.size())
                sum += 1;
            res = Math.max(res, sum);
    
        }
        return res;
    }
}
