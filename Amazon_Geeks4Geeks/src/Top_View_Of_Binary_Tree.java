import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Top_View_Of_Binary_Tree {
	class Object{
		
		Node node;
		int dis;
		
		Object(Node node, int dis){
			this.node = node;
			this.dis = dis;
		}
	}
	public void topView(Node root) {
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		Queue<Object> queue = new LinkedList<Object>();
		
		queue.add(new Object(root, 0));
		
		while(!queue.isEmpty()) {
			
			Object temp = queue.poll();
			
			if(!map.containsKey(temp.dis)) {
				map.put(temp.dis, temp.node.data);
			}
			if(temp.node.left != null)
				queue.add(new Object(temp.node.left, temp.dis - 1));
			if(temp.node.right != null)
				queue.add(new Object(temp.node.right, temp.dis + 1));
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			System.out.print(entry.getValue()+" ");
		}
	}
	public static void main(String args[]) {
		
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		node.right.left.right = new Node(8);
		
		Top_View_Of_Binary_Tree topView = new Top_View_Of_Binary_Tree();
		
		topView.topView(node);
	}
}
