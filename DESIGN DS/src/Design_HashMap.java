import java.util.Arrays;

class Design_HashMap {

    /** Initialize your data structure here. */
    int ar[];
    public Design_HashMap() {
        ar = new int[1000000];
        Arrays.fill(ar, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        ar[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(ar[key] == -1)
            return -1;
        return ar[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ar[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
