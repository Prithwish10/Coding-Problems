import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print_BT {

public List<List<String>> printTree(TreeNode root) {
        
        int height = findHeight(root);
        
        int width = (int) Math.pow(2, height) - 1;
        
        String grid[][] = new String[height][width];
        
        for(String[] a : grid)
            Arrays.fill(a, "");
        
        helper(root, 0, 0, width - 1, grid);
        
        List<List<String>> list = new ArrayList<>();
        
        for(String s[] : grid)
            list.add(Arrays.asList(s));
        
        return list;
    }
    private void helper(TreeNode root, int level, int left, int right, String grid[][]){
        
        if(root == null)
            return;
        
        int mid = left + (right - left) / 2;
        
        grid[level][mid] = String.valueOf(root.val);
        
        helper(root.left, level + 1, left, mid - 1, grid);
        
        helper(root.right, level + 1, mid + 1, right, grid);
    }
    private int findHeight(TreeNode root){
        
        if(root == null)
            return 0;
        
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        
        return 1 + Math.max(left, right);
    }
}
