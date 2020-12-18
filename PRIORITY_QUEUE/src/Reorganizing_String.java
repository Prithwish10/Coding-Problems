import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Reorganizing_String {

	public String reorganizeString(String S) {
        
        if(S == null) return null;
        
        int n = S.length();
        if(S.length() == 0 || S.length() == 1) return S;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = 
            new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
                
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2)                   {
                    return o2.getValue() - o1.getValue();
                }
            });
        pq.addAll(map.entrySet());
        
        String s = "";
        
        while(pq.size() > 1){
            
            Map.Entry<Character, Integer> current = pq.poll();
            Map.Entry<Character, Integer> next = pq.poll();
            
            s += current.getKey();
            s += next.getKey();
            
            current.setValue(current.getValue() - 1);
            next.setValue(next.getValue() - 1);
            
            if(current.getValue() > 0)
                pq.add(current);
            
            if(next.getValue() > 0)
                pq.add(next);   
        }
        
        if(!pq.isEmpty()){
            Map.Entry<Character, Integer> current = pq.poll();
            if(current.getValue() > 1)
                return "";
            else
                s += current.getKey();
        }
        return s;
	}
}
