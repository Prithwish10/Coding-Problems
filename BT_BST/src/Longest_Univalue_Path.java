//Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
//
//The length of path between two nodes is represented by the number of edges between them.
//
// 
//
//Example 1:
//
//Input:
//
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//Output: 2
//
// 
//
//Example 2:
//
//Input:
//
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
//	Output: 2
public class Longest_Univalue_Path {

	class Pair{
	    
	    int val, dis;
	    Pair(int val, int dis){
	        this.val = val;
	        this.dis = dis;
	    }
	}
	    int ans = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        
        helper(root);
        return (ans == 1 || ans == 0) ? 0 : ans - 1;
    }
    private Pair helper(TreeNode root){
        
        if(root == null)
            return new Pair(-1, 0);
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        int bend = 0;
        int left_straight = 1;
        int right_straight = 1;
        
        if(root.val == left.val && root.val == right.val)
            bend = left.dis + right.dis + 1;
        
        if(root.val == left.val)
            left_straight = 1 + left.dis;
        
        if(root.val == right.val)
            right_straight = 1 + right.dis;
        
        ans = Math.max(ans, Math.max(bend, Math.max(left_straight, right_straight)));
        
        return new Pair(root.val, Math.max(left_straight, right_straight));
    }
}


