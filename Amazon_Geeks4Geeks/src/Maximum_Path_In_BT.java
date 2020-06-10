import java.util.ArrayList;

class Node{
	
	Node left;
	Node right;
	int data;
	
	Node(int data){
		this.data = data;
	}
}

public class Maximum_Path_In_BT {

	int max = 0;
	ArrayList<Integer> path = new ArrayList<Integer>();
	public int maxPath(Node head) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		findPath(head, 0, list);
		
		maxPathSum(head, 0);
		System.out.println("Max Path Sum :"+maxSum);
		
		System.out.println("The maximum path is :"+path);
		return max;
	}
	
	public void findPath(Node node, int c, ArrayList<Integer> list) {
		
		if(node == null)
			return;
		
		c += 1;
		list.add(node.data);
		
		if(node.left == null && node.right == null) {
			
//			max = c > max ? c : max;
			if(c > max) {
				
				while(!path.isEmpty())
					path.remove(path.size() - 1);
				for(int i : list)
					path.add(i);
				max = c;
			}
			list.remove(list.size() - 1);
			return;
		}
		
		findPath(node.left, c, list);
		findPath(node.right, c, list);
		
		list.remove(list.size() - 1);
	}
	int maxSum = 0;
	public void maxPathSum(Node node, int c) {  //Root to Leaf
		
		if(node == null)
			return;
		
		c += node.data;
		
		if(node.left == null && node.right == null) {
			
			maxSum = maxSum < c ? c : maxSum;
		}
		
		maxPathSum(node.left, c);
		maxPathSum(node.right, c);
	}
	public static void main(String args[]) {
		
		Node node = new Node(10);
		node.left = new Node(5);
		node.right = new Node(7);
		node.left.left = new Node(3);
		node.left.right = new Node(9);
		node.right.left = new Node(1);
		node.left.right.left = new Node(7);
		node.left.right.left.right = new Node(2);
		
		Maximum_Path_In_BT max = new Maximum_Path_In_BT();
		
		System.out.println("Maximum Path length is :"+max.maxPath(node));
	}
}
