

public class Check_BT_Is_BST_OrNot {

	public boolean check(Node head) {
		
		return isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean isBST(Node node, int min, int max) {
		
		if(node == null)
			return true;
		if(node.data < min || node.data > max)
			return false;
		
		return isBST(node.left, min, node.data) 
				&& isBST(node.right, node.data, max);
	}
	public static void main(String args[]) {
		
		Node node = new Node(10);
		node.left = new Node(5);
		node.right = new Node(12);
		node.left.left = new Node(3);
		node.left.right = new Node(9);
		node.right.left = new Node(1);
		node.left.right.left = new Node(7);
		//node.left.right.left.right = new Node(2);
		
		Check_BT_Is_BST_OrNot ch = new Check_BT_Is_BST_OrNot();
		
		System.out.println(ch.check(node));
	}
}
