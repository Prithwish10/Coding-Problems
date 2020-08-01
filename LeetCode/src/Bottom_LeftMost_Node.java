import java.util.LinkedList;
import java.util.Queue;

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
class Bottom_LeftMost_Node {
    
    public int findBottomLeftValue(TreeNode root) {
        
        if(root == null)
            return -1;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        TreeNode node = null;
        
        while(!queue.isEmpty()){
            
            node = queue.poll();
            
            if(node.right != null)
                queue.add(node.right);
            
            if(node.left != null)
                queue.add(node.left);
        }
        return node.val;
    }
    
}
