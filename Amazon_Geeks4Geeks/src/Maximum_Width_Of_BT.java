import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Maximum_Width_Of_BT {
	
	// Level Order Based Approach
	// Time : O(n)
	// Space : O(n)
	public void maxWidth(Node node) {
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(node);
		
		int max = 1;
		
		while(!queue.isEmpty()) {
			
			if(queue.size() > max)
				max = queue.size();
			
			Node temp = queue.poll();
			
			if(temp.left != null)
				queue.add(temp.left);
			
			if(temp.right != null)
				queue.add(temp.right);
		}
		System.out.println("Maximum width of the Binary tree is :"+max);
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
		
		Maximum_Width_Of_BT max = new Maximum_Width_Of_BT();
		
		max.maxWidth(node);
	}
}
