import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Designation_City {

	public String destCity(List<List<String>> paths) {
	     
        if(paths.size() == 0)
            return "-1";
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < paths.size(); i++){
            
            List<String> list = paths.get(i);
            
            map.put(list.get(0), map.getOrDefault(list.get(0), 0) + 1);
            
            if(!map.containsKey(list.get(1)))
                map.put(list.get(1), 0);
            else
                map.put(list.get(1), map.getOrDefault(list.get(1), 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 0)
                return entry.getKey();
        }
        return "-1";
    }
}
