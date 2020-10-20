//Design an Iterator class, which has:
//
//A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
//A function next() that returns the next combination of length combinationLength in lexicographical order.
//A function hasNext() that returns True if and only if there exists a next combination.
// 
//
//Example:
//
//CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
//
//iterator.next(); // returns "ab"
//iterator.hasNext(); // returns true
//iterator.next(); // returns "ac"
//iterator.hasNext(); // returns true
//iterator.next(); // returns "bc"
//iterator.hasNext(); // returns false

import java.util.*;

public class Iterator_Of_Combination {

	Queue<String> queue;
    
    public Iterator_Of_Combination(String characters, int combinationLength) {
        
        queue = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        
        distinctSubsequence(characters, 0, combinationLength, sb);
    }
    
    public String next() {
        
        return queue.poll();
    }
    
    public boolean hasNext() {
        
        if(queue.isEmpty())
            return false;
        return true;
    }
    public void distinctSubsequence(String s, int p, int len, StringBuilder sb) {
		
		if(p >= s.length()) {
			if(sb.length() == len)
				queue.add(new String(sb));
			return;
		}
		
		sb.append(s.charAt(p));
		distinctSubsequence(s, p + 1, len, sb);
		
		sb.deleteCharAt(sb.length() - 1);
		distinctSubsequence(s, p + 1, len, sb);
	}
}
