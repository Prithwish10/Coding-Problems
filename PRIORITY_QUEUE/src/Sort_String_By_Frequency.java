import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Sort_String_By_Frequency {

	public static void main(String args[]) {
		
		String s = "tree";
		String res = frequencySort(s);
		System.out.println(res);
	}
	
	public static String frequencySort(String s) {
        
        if(s == null)
            return null;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = 
        		new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){

					@Override
					public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
						
						return o2.getValue() - o1.getValue();
					}
        		}) ;
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        	pq.add(entry);
        }
        String res = "";
        
        while(!pq.isEmpty()) {
        	Map.Entry<Character, Integer> entry = pq.poll();
        	char c = entry.getKey();
        	int val = entry.getValue();
        	
        	for(int i = 1; i <= val; i++) {
        		res += c;
        	}
        }
        return res;
    }
}

