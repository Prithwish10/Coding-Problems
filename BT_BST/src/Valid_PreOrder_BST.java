//Problem Description
//
//You are given a preorder traversal A, of a Binary Search Tree.
//
//Find if it is a valid preorder traversal of a BST.
import java.util.ArrayList;
import java.util.Stack;

public class Valid_PreOrder_BST {
    public int solve(ArrayList<Integer> A) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int root = Integer.MIN_VALUE;
        
        for(int i = 0; i < A.size(); i++){
            
            if(A.get(i) < root)
                return 0;
            
            while(!stack.isEmpty() && stack.peek() < A.get(i)){
                root = stack.peek();
                stack.pop();
            }
                
                
            stack.add(A.get(i));
        }
        return 1;
    }
}
