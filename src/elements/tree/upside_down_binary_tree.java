/**
 * Binary tree upside down.
 */
 
public class Solution {
    
    public TreeNode flip(TreeNode root) {
        return helper(root, null);
    }
    
    private TreeNode helper(TreeNode node, TreeNode parent) {
        if (node == null) return parent;
        
        TreeNode root = helper(node.left, node);
        node.left = parent == null ? null : parent.right;
        node.right = parent;
        
        return root;
    }
    
}