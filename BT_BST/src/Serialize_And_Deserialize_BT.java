import java.util.Arrays;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Serialize_And_Deserialize_BT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        builtTree(root, sb);
        return sb.toString();
    }

    private void builtTree(TreeNode root, StringBuilder sb){
        
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        builtTree(root.left, sb);
        builtTree(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(list);
    }
    private TreeNode helper(LinkedList<String> list){
        
        String first = list.removeFirst();
        if(first.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(first));
        node.left = helper(list);
        node.right = helper(list);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
