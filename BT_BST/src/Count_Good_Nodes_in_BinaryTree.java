
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
