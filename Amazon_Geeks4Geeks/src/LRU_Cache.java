import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {

	public static class ListNode{
	    
	    int key;
	    int val;
	    ListNode next;
	    ListNode prev;
	    
	    ListNode(int val){
	        this.val = val;
	    }
	    ListNode(int key, int val){
	    	this.key = key;
	    	this.val = val;
	    }
	}
	
	ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map;
    
    public LRU_Cache(int capacity) {
        
        head = null;
        tail = null;
        this.capacity = capacity;
        map = new HashMap<Integer, ListNode>(capacity);
    }
    
    public int get(int key) {
    	
    	if(map.containsKey(key)) {
    		
    		ListNode temp = map.get(key);
    		removeRandom(temp);
    		addBeginning(temp);
    		return temp.val;
    	}
    	else {
    		return -1;
    	}
    }
    public void put(int key, int value) {
        
    	ListNode temp = map.get(key);
    	
    	//The value is present in the cache
        if(map.containsKey(key)){
            
//        	map.remove(key);
            removeRandom(temp);
            temp.val = value;
            temp.key = key;
            addBeginning(temp);
        }
        else{
            
            if(map.size() == capacity) {
            	
            	map.remove(tail.key);
            	removeLast();
            }
            ListNode node = new ListNode(value);
        	node.key = key;
        	
        	map.put(key, node);
        	addBeginning(node);
        }
    }
    
    public void addBeginning(ListNode new_node){
        
        //ListNode new_node = new ListNode(data);
        
        if(head == null){
            
            head = new_node;
            tail = new_node;
        }
        else{
            
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
        }
    }
    
    public void removeRandom(ListNode node){
        
        if(head != node){
            
            if(node.next == null){
                node.prev.next = null;
                tail = tail.prev;
                node.prev = null;
            }
            else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }
        }
        else if(head == node && head.next != null){
        	head = head.next;
        }
    }
    public void removeLast(){
        
        if(tail != null){
            
            tail = tail.prev;
            
            if(tail != null){
                tail.next.prev = null;
                tail.next = null;
            }
            else{
                head = null;
            }
        }
    }
    
    public void traverse() {
    	
    	ListNode temp = head;
    	
    	while(temp != null)
    	{
    		System.out.println(temp.key+" "+temp.val);
    		temp = temp.next;
    	}
    }
	public static void main(String args[]) {
		
		LRU_Cache lru = new LRU_Cache(2);

//		lru.addBeginning(new ListNode(1, 1));
//		lru.addBeginning(new ListNode(2, 2));
//		lru.addBeginning(new ListNode(3, 3));
//		
//		ListNode t = lru.tail;
//		
//		lru.removeRandom(t);
//		
//		lru.addBeginning(t);
		lru.put(1, 1);
		
		lru.put(2, 7);
		
		lru.get(1);
		
		//System.out.println(lru.capacity+" "+ lru.map.size());
		System.out.println(lru.head.key+" "+lru.tail.key);
		//lru.map.remove(lru.tail.key);
		lru.put(3, 3);
		System.out.println(lru.head.key+" "+lru.tail.key);
		//System.out.println(lru.capacity+" "+ lru.map.size());
		System.out.println(lru.get(2));
		
	}
}
