import java.util.ArrayList;
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
class Balance_A_BST {
    List<Integer> inorder = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        
        inOrder(root);
        
        return convert(0, inorder.size() - 1);
    }
    public void inOrder(TreeNode root){
        
        if(root == null)
            return;
        inOrder(root.left);
        inorder.add(root.val);
        inOrder(root.right);
    }
    public TreeNode convert(int L, int R){
        
        if(L > R){
            return null;
        }
        int mid = L + (R - L)/2;
        
        TreeNode node = new TreeNode(inorder.get(mid));
        
        node.left = convert(L, mid - 1);
        node.right = convert(mid + 1, R);
        
        return node;
    }
}
