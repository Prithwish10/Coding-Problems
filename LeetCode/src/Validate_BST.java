import java.util.Stack;

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
class Validate_BST {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        inOrder(root);
        int val = stack.pop().val;
        
        while(!stack.isEmpty()){
            
            if(stack.peek().val >= val)
                return false;
            val = stack.pop().val;
        }
        return true;
       // return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
//    public boolean isValid(TreeNode root, int min, int max){
        
//         if(root == null)
//             return true;
        
//         if(root.val <= min || root.val >= max)
//             return false;
        
//         return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        
        
//    }
    public void inOrder(TreeNode root){
        
        if(root == null)
            return;
        
        inOrder(root.left);
        stack.add(root);
        inOrder(root.right);
    }
}

