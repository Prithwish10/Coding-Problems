import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Timestamp {

    class Node{
        
        int timestamp;
        String value;
        
        Node(int timestamp, String value){
            
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    
    Map<String, List<Node>> map;
    
    public Timestamp() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        List<Node> list;
        
        if(!map.containsKey(key)){
            list = new ArrayList<>();
        }
        else{
            list = map.get(key);
        }
        
        list.add(new Node(timestamp, value));
        
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key))
            return "";
        
        List<Node> list = map.get(key);
        
        Node res = search(list, 0, list.size() - 1, null, timestamp);
        
        return res == null ? "" : res.value;
    }
    private Node search(List<Node> list, int low, int high, Node res, int timestamp){
        
        if(low > high)
            return res;
        
        int mid = low + (high - low) / 2;
        
        Node nodes = list.get(mid);
        
        
        if(nodes.timestamp <= timestamp){
            res = nodes;
            return search(list, mid + 1, high, res, timestamp);
        }
        else{
            return search(list, low, mid - 1, res, timestamp);
        }
    }
}
