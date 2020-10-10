import java.util.HashMap;
import java.util.Map;

public class Longest_Well_Performing_Intervals {

	public int longestWPI(int[] hours) {
        
        if(hours == null || hours.length == 0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0, max = 0, n = hours.length;
        
        for(int i = 0; i < n; i++){
            
            sum += hours[i] > 8 ? 1 : -1;

            if(!map.containsKey(sum))
                map.put(sum, i);
            if(sum > 0)
                max = i + 1;
            
            if(map.containsKey(sum - 1)){
                
                max = Math.max(max, i - map.get(sum - 1));
            }  
        }
        return max;
    }
}
