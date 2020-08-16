import java.util.ArrayList;
import java.util.List;

public class All_Nodes_From_Distance_K_From_Target_Node {

	static List<TreeNode> list = new ArrayList<>();
	
	public static int findKDistanceNodesDriver(TreeNode root, int k, TreeNode targetNode) {
		
		if(root == null || k < 0 || targetNode == null)
			return -1;
		return findKDistanceNodes(root, k, targetNode);
	}
	private static int findKDistanceNodes(TreeNode root, int k, TreeNode targetNode) {
		
		if(root == null)
			return -1;
		
		if(root == targetNode) {
			printAllKDistanceNodesDown(root, k);
			return 0;
		}
		
		int left = findKDistanceNodes(root.left, k, targetNode);
		
		if(left != -1) {
			
			if(left + 1 == k)
				list.add(root);
			else
				printAllKDistanceNodesDown(root.right, k - 2 - left);
			
			return left + 1;
		}
		
		int right = findKDistanceNodes(root.right, k, targetNode);
		
		if(right != -1) {
			
			if(right + 1 == k)
				list.add(root);
			else
				printAllKDistanceNodesDown(root.left, k - 2 - right);
			
			return right + 1;
		}
		return -1;
	}
	
	private static void printAllKDistanceNodesDown(TreeNode root, int k) {
		
		if(root == null)
			return;
		
		if(k == 0) {
			list.add(root);
		}
		printAllKDistanceNodesDown(root.left, k - 1);
		printAllKDistanceNodesDown(root.right, k - 1);
	}
	
	public static void main(String args[]) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(9);
		root.left.left.left = new TreeNode(10);
		root.left.left.right = new TreeNode(6);
		root.left.right.right = new TreeNode(3);
		root.left.left.right.left = new TreeNode(5);
		root.left.left.right.right = new TreeNode(11);
		
		findKDistanceNodesDriver(root, 2, root.left.left);
		
		for(TreeNode node : list)
			System.out.print(node.val+" ");
	}
}
