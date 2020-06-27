
public class Sum_Root_to_Leaf_Numbers {

	int s = 0;
	public void sumRootToLeaf(Node root) {
		
		System.out.println("All the root to leaf paths are :");
		sum(root, 0);
		//return count;
		
		System.out.println("\nSum of all the root to leaf paths is : "+s);
	}
	
	public void sum(Node root, int count) {
		
		if(root == null)
			return;
		
		count = count * 10 + root.data;
		
		if(root.left == null && root.right == null){
			
			System.out.print(count+" "); // Root to leaf paths
			s += count;
			count = count / 10;
			return;
		}
		
		sum(root.left, count);
		sum(root.right, count);
		
		count = count / 10;
	}
	public static void main(String args[]) {
		
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		node.left.right.left = new Node(8);
		node.right.right.right = new Node(9);
		
		Sum_Root_to_Leaf_Numbers max = new Sum_Root_to_Leaf_Numbers();
		
		max.sumRootToLeaf(node);
	}
}
