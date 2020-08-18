
public class Sum_Of_Left_Leaves {

	int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }
    private void dfs(TreeNode root){
        
        if(root == null)
            return;
        
        if(root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        
        dfs(root.left);
        dfs(root.right);
    }
}
