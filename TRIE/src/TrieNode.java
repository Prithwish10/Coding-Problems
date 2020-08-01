import java.util.HashMap;
import java.util.Map;

class TrieNode{
    
    Map<Character, TrieNode> child;
    boolean endOfWord;
    
    TrieNode(){
        
        this.child = new HashMap<Character, TrieNode>();
        this.endOfWord = false;
    }
}

