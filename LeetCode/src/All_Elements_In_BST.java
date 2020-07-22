import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class All_Elements_In_BST {
    
    List<Integer> res = new ArrayList<Integer>();
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        inOrder(root1);
        inOrder(root2);
        
        Collections.sort(res);
        
        return res;
    }
    
    public void inOrder(TreeNode root){
        
        if(root == null)
            return;
        
        inOrder(root.left);
        
        res.add(root.val);
        
        inOrder(root.right);
    }
}