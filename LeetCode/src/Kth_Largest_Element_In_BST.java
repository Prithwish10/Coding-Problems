import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Kth_Largest_Element_In_BST {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return -1;
        
        inOrder(root, k);
        
        // if(k > list.size())
        //     return -1;
        
        //return list.get(k - 1);
        return maxHeap.peek();
    }
    //Time Complexity : n log k
    public void inOrder(TreeNode root, int k){
        
        
        if(root == null)
            return;
        inOrder(root.left, k);
        //list.add(root.val);
        if(maxHeap.size() < k)
            maxHeap.add(root.val);
        else{
            
            if(root.val < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(root.val);
            }
        }
        inOrder(root.right, k);
    }
	public static void main(String args[]) {
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(1);
		node.right = new TreeNode(4);
		//node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(2);
//		node.right.left = new TreeNode(1);
//		node.left.right.left = new TreeNode(7);
//		node.left.right.left.right = new TreeNode(2);
		
		Kth_Largest_Element_In_BST max = new Kth_Largest_Element_In_BST();
		
		System.out.println("Maximum Path length is :"+max.kthSmallest(node, 3));
	}
}