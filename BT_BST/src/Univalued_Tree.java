
public class Univalued_Tree {

	public boolean isUnivalTree(TreeNode root) {
        
        if(root == null)
            return true;
        
        return helper(root, root.val);
    }
    private boolean helper(TreeNode root, int val){
        
        if(root == null)
            return true;
        
        if(root.val != val)
            return false;
        
        return helper(root.left, val) & helper(root.right, val);
    }
}
