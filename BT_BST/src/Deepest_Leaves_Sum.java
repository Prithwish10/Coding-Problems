
public class Deepest_Leaves_Sum {
	int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        
        if(root == null) return 0;
        
        int height = height(root);
        
        findSum(root, 0, height - 1);
        return sum;
    }
    private int height(TreeNode root){
        
        if(root == null)
            return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    private void findSum(TreeNode root, int height, int deepestLeaf){
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null && height == deepestLeaf){
            sum += root.val;
            return;
        }
        findSum(root.left, height + 1, deepestLeaf);
        findSum(root.right, height + 1, deepestLeaf);
    }
}
