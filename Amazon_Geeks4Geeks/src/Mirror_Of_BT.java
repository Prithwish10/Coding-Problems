import java.util.LinkedList;
import java.util.Queue;

public class Mirror_Of_BT {

	public void mirrorImage(Node node) {
		
		if(node == null)
			return;
		
		mirrorImage(node.left);
		mirrorImage(node.right);
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
	
	public void levelOrder(Node node) {
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			System.out.print((char)temp.data+"->");
			
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
		System.out.println();
	}
	public static void main(String args[]) {
		
		Node node = new Node('a');
		node.left = new Node('b');
		node.right = new Node('c');
		node.left.left = new Node('d');
		node.left.right = new Node('e');
		node.right.left = new Node('f');
		node.right.right = new Node('g');
		
		Mirror_Of_BT m = new Mirror_Of_BT();
		
		m.levelOrder(node);
		
		m.mirrorImage(node);
		m.levelOrder(node);
	}
}
