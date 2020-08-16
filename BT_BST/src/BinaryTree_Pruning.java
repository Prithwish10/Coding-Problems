
public class BinaryTree_Pruning {

	 public TreeNode pruneTree(TreeNode root) {
	        
	        removeInvalidNodes(root);
	        
	        if(root == null)
	            return null;
	        if(root.val == 0 && root.left == null && root.right == null)
	            return null;
	        
	        return root;
	    }
	    private void removeInvalidNodes(TreeNode root){
	        
	        if(root == null){
	            return;
	        }
	        
	        boolean left = check(root.left);
	        boolean right = check(root.right);
	        
	        if(left == false)
	            root.left = null;
	        if(right == false)
	            root.right = null;
	        
	        removeInvalidNodes(root.left);
	        removeInvalidNodes(root.right);
	    }
	    private boolean check(TreeNode root){
	        
	        if(root == null)
	            return false;
	        if(root.val == 1)
	            return true;
	        return check(root.left) || check(root.right);
	    }
}
