
public class First_Node_Greater_Than_K {

	static TreeNode res = null;
	static int s = Integer.MAX_VALUE;
	
	public TreeNode firstNodeGreater(TreeNode root, int k) {
		
		find(root, k);
		
		return res;
	}
	public static void find(TreeNode root, int k) {
		
		if(root == null)
			return;
		
		if(root.val > k && root.val < s) {
			res = root;
			s = root.val;
		}
		
		find(root.left, k);
		find(root.right, k);
	}
	
	public static void main(String args[]) {
		
		TreeNode node = new TreeNode(20);
		node.left = new TreeNode(9);
		node.right = new TreeNode(25);
		node.left.left = new TreeNode(5);
		node.left.right = new TreeNode(12);
		//node.right.left = new TreeNode(6);
		node.left.right.left = new TreeNode(11);
		node.left.right.right = new TreeNode(14);
		
		First_Node_Greater_Than_K f = new First_Node_Greater_Than_K();
		
		System.out.println(f.firstNodeGreater(node,14).val);
	}
}
