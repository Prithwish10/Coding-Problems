
public class Delete_Leaves_With_A_Given_Value {

	boolean flag = false;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        if(root == null)
            return null;
        
        helper(root, target);
        if(root != null && root.val == 0)
            return null;
        return root;
    }
    private void helper(TreeNode root, int target){
        
        if(root == null)
            return;
        
        helper(root.left, target);
        helper(root.right, target);
        
        if(root != null){
            
            if(root.left != null && root.left.val == 0)
                root.left = null;
            
            if(root.right != null && root.right.val == 0)
                root.right = null;
            
            if(root.left != null && root.right != null && root.left.val == 0 && root.right.val == 0){
                root.left = null;
                root.right = null;
            }
            if(root.val == target && root.left == null && root.right == null)
                 root.val = 0;
        }
        return;
    }
}
