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
class Cousin_In_BT {
	
    int levelOfX = -1;
    int levelOfY = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        return helper(root, 0, x, y);
    }
    public boolean helper(TreeNode root, int level, int x, int y){
        
        if(root == null)
            return true;
      
        if(root.left != null && root.right != null){
                
            if((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x))
                return false;
        }
        
        if(root.val == x)
            levelOfX = level;
        
        if(root.val == y)
            levelOfY = level;
        
        if(levelOfX != -1 && levelOfY != -1)
            return levelOfX == levelOfY;
        
        return helper(root.left, level + 1, x, y) & helper(root.right, level + 1, x, y);
    }
}