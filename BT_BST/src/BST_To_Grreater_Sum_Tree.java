//Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of 
//the original tree that are greater than or equal to node.val.

//Leetcode : 1038

import java.util.HashMap;
import java.util.Map;

public class BST_To_Grreater_Sum_Tree {

	int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode bstToGst(TreeNode root) {
        
        if(root == null)
            return null;
        
        dfs(root);
        create(root);
        return root;
    }
    // ..................Space : O(n) || Time : O(n) .......................................
    public void dfs(TreeNode root){
        if(root == null)
            return;
        
        dfs(root.right);
        
        sum += root.val;
        map.put(root.val, sum);
        
        dfs(root.left);
    }
    public void create(TreeNode root){
        
        if(root == null)
            return;
        
        root.val = map.get(root.val);
        
        create(root.left);
        create(root.right);
    }
    
    // ..................Space : O(1) || Time : O(n) .......................................
    public void create1(TreeNode root){
        
        if(root == null)
            return;
        
        create(root.right);
        
        root.val += sum;
        sum = root.val;
        
        create(root.left);
    }
}
