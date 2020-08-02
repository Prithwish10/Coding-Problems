class Add_And_Search_Word_DS_Design {
   
	TrieNode root;
    /** Initialize your data structure here. */
    public Add_And_Search_Word_DS_Design() {
        root=new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    //tc=O(M), where M is the key length,sc=O(M) worst case is when there's no shared prefixes.
    public void addWord(String word) {
        
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word,root);
    }
    
     public boolean search(String word, TrieNode root) {
         
        TrieNode current = root;
         
         for(int i = 0; i < word.length(); i++){
            
             char ch = word.charAt(i);
            
            if(!current.child.containsKey(ch)){
            
                if(ch == '.'){
                    
                     for(char c : current.child.keySet())
                         if(search(word.substring(i + 1, word.length()), current.child.get(c)))
                             return true;
                 }
                return false;
            } 
            else 
                current = current.child.get(ch);
        }
        return current.endOfWord;
    }
}
// /**
//  * Your WordDictionary object will be instantiated and called as such:
//  * WordDictionary obj = new WordDictionary();
//  * obj.addWord(word);
//  * boolean param_2 = obj.search(word);
//  */
