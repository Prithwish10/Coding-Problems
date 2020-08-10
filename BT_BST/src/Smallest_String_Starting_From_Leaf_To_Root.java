import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Smallest_String_Starting_From_Leaf_To_Root {
    
    String global = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    
    public String smallestFromLeaf(TreeNode root) {
        
        if(root == null)
            return "";
        
        List<Character> list = new ArrayList<>();
        
        for(char i = 'a'; i <= 'z'; i++)
            list.add(i);
        
        dfs(root, list, "");
        
        return global;
    }
    public void dfs(TreeNode root, List<Character> list, String path){
        
        if(root == null)
            return;
        
        path += list.get(root.val);
       
        if(root.left == null && root.right == null){
            
            String rev = reverse(path);
            
            if(global.compareTo(rev) > 0)
                global = rev;
            
            return;
        }
        dfs(root.left, list, path);
        dfs(root.right, list, path);
    }
    
    public String reverse(String s){
        
        char ch[] = s.toCharArray();
        
        for(int i = 0; i < ch.length/2; i++){
            
            char temp = ch[i];
            ch[i] = ch[ch.length - i - 1];
            ch[ch.length - i -1] = temp;
        }
        
        return new String(ch);
    }
}

