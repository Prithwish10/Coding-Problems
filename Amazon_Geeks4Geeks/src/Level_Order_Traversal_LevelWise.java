import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Traversal_LevelWise {

	// Method 1
	public void levelOrder1(Node root) {
		
		Queue<Node> queue1 = new LinkedList<Node>();
		Queue<Node> queue2 = new LinkedList<Node>();
		
		queue1.add(root);
		
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
			
			if(!queue1.isEmpty()) {
				while(!queue1.isEmpty()) {
				
					Node temp = queue1.poll();
					System.out.print(temp.data+" ");
					if(temp.left  != null)
						queue2.add(temp.left);
					if(temp.right != null)
						queue2.add(temp.right);
				}
			}
			else {
				
				while(!queue2.isEmpty()) {
					
					Node temp = queue2.poll();
					System.out.print(temp.data+" ");
					if(temp.left  != null)
						queue1.add(temp.left);
					if(temp.right != null)
						queue1.add(temp.right);
				}
			}
			if(queue1.isEmpty() || queue2.isEmpty())
				System.out.println();
		}
	}
	// Method 2
	public void levelOrder(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			
			if(queue.size() == 1 && queue.peek() == null)
				break;
			
			Node temp = queue.poll();
			
			if(temp == null) {
				
				System.out.println();
				queue.add(null);
			}
			else {
				System.out.print(temp.data+" ");
				
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
			}
		}
	}
	public static void main(String args[]) {
		
		Node node = new Node(15);
		node.left = new Node(10);
		node.right = new Node(20);
		node.left.left = new Node(8);
		node.left.right = new Node(12);
		node.right.left = new Node(17);
		node.right.right = new Node(25);
		node.left.left.left = new Node(6);
		node.left.right.left = new Node(11);
		node.right.left.left = new Node(16);
		node.right.right.right = new Node(27);
		
		Level_Order_Traversal_LevelWise level = new Level_Order_Traversal_LevelWise();
		
		level.levelOrder1(node);
	}
}
