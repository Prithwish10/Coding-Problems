import java.util.*;
public class First_Common_Character {

	public static void main(String args[]) {
		
		String A[] = {"cool","lock","cook"};
		commonChars(A);
	}
	public static List<String> commonChars(String[] A) {
        
        List<String> res = new ArrayList<>();
        
        if(A == null) return res;
        
        int ar[] = new int[A.length];
        Map<Character, Integer[]> map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++){
            
            String s = A[i];
            
            for(int j = 0; j < s.length(); j++){
                
                if(!map.containsKey(s.charAt(j))) {
                	Integer[] a = new Integer[A.length];
                	a[i] = 1;
                	map.put(s.charAt(j), a);
                }
                else {
                	Integer[] a = map.get(s.charAt(j));
                	if(a[i] == null)
                		a[i] = 1;
                	else
                		a[i] ++;
                	map.put(s.charAt(j), a);
                }        	
                	
            }
        }
        for(Map.Entry<Character, Integer[]> entry : map.entrySet()) {
        	
        	Integer[] a = entry.getValue();
        	int minCount = Integer.MAX_VALUE;
        	int flag = 0;
        	for(int k = 0; k < entry.getValue().length; k++) {
        		
        		if(a[k] == null) {
        			flag = 1;
        			break;
        		}
        		minCount = Math.min(minCount, a[k]);
        	}
        	
        	if(flag != 1 && minCount != Integer.MAX_VALUE) {
        		for(int i = 1; i <= minCount; i++) {
        			String s = Character.toString(entry.getKey());
        			res.add(s);
        		}
        	}
        		
        }
        System.out.println(res);
        return res;
    }
}
