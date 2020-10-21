
public class Check_For_Complete_BT {

	public boolean isCompleteTree(TreeNode root) {
        
        if(root == null)
            return false;
        int h = height(root);
        return helper(root, 0, h);
    }
    private boolean flag = false;
    private TreeNode node = null;
    private boolean helper(TreeNode root, int level, int h){
        
        if(level < h - 1 && root == null)  //Check if any Intermediate nodes missing
            return false;
        
        if(level == h - 2 && root.left == null && root.right != null) //For any second last level node if                                                                    there is no left child and have right child
            return false;
        
        if(level == h - 2 && root.right == null && !flag){
            flag = true;
            node = root;
            //System.out.println(root.val);
        }
        
        if(level == h - 2 && (root.left!= null || root.right != null) && flag == true && root != node){
            return false;
        }
        
        if(root == null)
            return true;
        
        return helper(root.left, level + 1, h) && helper(root.right, level + 1, h);
    }
    private int height(TreeNode root){
        
        if(root == null)
            return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        return Math.max(left, right) + 1;
    }
}
