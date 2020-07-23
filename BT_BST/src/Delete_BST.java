class Delete_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null)
            return root;
        
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        
        else{
                
            if(root.left == null)
                return root.right;
                
            else if(root.right == null)
                return root.left;
                
            root.val = findMin(root.right);
            root.right = deleteNode(root.right, root.val); 
        }
        return root;
    }
    public int findMin(TreeNode root){
        
        int temp = root.val;
        
        while(root.left != null){
            temp = root.left.val;
            root = root.left;
        }
        return temp;
    }
}
//if(root.left != null && root.right != null){

//TreeNode temp = findMin(root.right);

//root.val = temp.val;
//root.right = deleteNode(root.right, temp.val);
//}
//else{

//if(root.left != null){
// return root.left;
//}
//else if(root.right != null){
//  return root.right;
//}
//}