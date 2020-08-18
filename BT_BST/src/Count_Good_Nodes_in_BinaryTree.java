//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//
//Return the number of good nodes in the binary tree.
//
// 
//
//Example 1:
//
//
//
//Input: root = [3,1,4,3,null,1,5]
//Output: 4
//Explanation: Nodes in blue are good.
//Root Node (3) is always a good node.
//Node 4 -> (3,4) is the maximum value in the path starting from the root.
//Node 5 -> (3,4,5) is the maximum value in the path
//Node 3 -> (3,1,3) is the maximum value in the path.
//Example 2:
//
//
//
//Input: root = [3,3,null,4,2]
//Output: 3
//Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
public class Count_Good_Nodes_in_BinaryTree {

	// List<Integer> list = new ArrayList<>();
    int count = 0;
    public int goodNodes(TreeNode root) {
        
        dfs(root, Integer.MIN_VALUE);
        return count;
        
    }
   /* private void dfs(TreeNode root){
        
        if(root == null)
            return;
        
        list.add(root.val);
        
        helper(list, root.val);
        
        dfs(root.left);
        dfs(root.right);
        
        list.remove(list.size() - 1);
    }
    private void helper(List<Integer> list, int val){
        
        // System.out.println(list);
        boolean flag = false;
        
        for(int i : list){
            
            if(i > val){
                flag = true;
                break;
            }
        }
        if(flag == false)
            count ++;
    }*/
    private void dfs(TreeNode root, int max){
        
        if(root == null)
            return;
        
        if(root.val >= max){
            count ++;
            max = root.val;
        }
        
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
