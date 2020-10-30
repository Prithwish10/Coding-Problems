//A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
//
//Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
//
//CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
//CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
//CBTInserter.get_root() will return the head node of the tree.
// 
//
//Example 1:
//
//Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
//Output: [null,1,[1,2]]
//Example 2:
//
//Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
//Output: [null,3,4,[1,2,3,4,5,6,7,8]]

import java.util.LinkedList;
import java.util.Queue;

public class Complete_BT_Inserter {

	TreeNode root;
    public Complete_BT_Inserter(TreeNode root) {
        this.root = root;
    }
    
    public int insert(int v) {
        
        TreeNode node = levelOrder(root);
        
        if(node.left == null){
            node.left = new TreeNode(v);
            return node.val;
        }
        else{
            node.right = new TreeNode(v);
            return node.val;
        }
    }
    
    public TreeNode get_root() {
        return root;
    }
    public TreeNode levelOrder(TreeNode root){
        
        if(root == null)
            return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            TreeNode node = queue.poll();
            
            if(node.left != null)
                queue.add(node.left);
            else 
                return node;
            
            if(node.right != null)
                queue.add(node.right);
            else
                return node;
        }
        return null;
    }
}
