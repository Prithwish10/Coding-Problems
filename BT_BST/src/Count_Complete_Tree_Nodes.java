
public class Count_Complete_Tree_Nodes {

	int count = 0;
    public int countNodes(TreeNode root) {
        
        helper(root);
        return count;
    }
    private void helper(TreeNode root){
        
        if(root == null)
            return;
        
        count += 1;
        
        helper(root.left);
        helper(root.right);
    }
}
