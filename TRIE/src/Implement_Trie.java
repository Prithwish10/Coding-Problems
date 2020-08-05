import java.util.Scanner;

class Implement_Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    
    public Implement_Trie() {
       root = new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++){
            
            char ch = word.charAt(i);
            
            TrieNode node = current.child.get(ch);
            
            if(node == null){
                
                node = new TrieNode();
                current.child.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
		
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++){
            
            char ch = word.charAt(i);
            
            TrieNode node = current.child.get(ch);
            
            if(node == null)
                return false;
            
            current = node;
        }
        return current.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode current = root;
        
        for(int i = 0; i < prefix.length(); i++){
            
            char ch = prefix.charAt(i);
            
            TrieNode node = current.child.get(ch);
            
            if(node == null)
                return false;
            
            current = node;
        }
        return true;
    }
    public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	Implement_Trie obj = new Implement_Trie();
    	
    	obj.insert("abc");
    	obj.insert("abcd");
    	obj.insert("lmn");
    	obj.insert("abghi");
    	obj.insert("geeksforgeeks");
    	
    	System.out.println(obj.search("abc"));
    	System.out.print(obj.startsWith("geeks"));
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */