
public class BT_To_String {

	public String tree2str(TreeNode t) {
        
        return helper(t);
        //return res;
    }
    private String helper(TreeNode root){
        
        if(root == null)
            return "";
        
        return root.val + 
            ((root.left == null && root.right == null) ? "" : "(" + helper(root.left) + ")") +
            ((root.right == null) ? "" : "(" + helper(root.right) + ")");
    }
}
