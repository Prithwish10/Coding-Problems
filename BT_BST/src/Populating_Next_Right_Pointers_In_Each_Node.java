//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class Populating_Next_Right_Pointers_In_Each_Node {
	class Pair{
	    
	    Node root;
	    int level;
	    
	    Pair(Node root, int level){
	        this.root = root;
	        this.level = level;
	    }
	}
	public Node connect(Node root) {
        
        if(root == null)
            return root;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        Pair previous = queue.peek();
        
        while(!queue.isEmpty()){
            
            Pair current = queue.poll();
            
            if(current.level == previous.level){
                previous.root.next = current.root;
            }
            else{
                previous.root.next = null;
            }
            
            previous = current;
            
            if(current.root.left != null)
                queue.add(new Pair(current.root.left, current.level + 1));
            
            if(current.root.right != null)
                queue.add(new Pair(current.root.right, current.level + 1));
        }
        previous.root.next = null;
        
        return root;
    }
}
