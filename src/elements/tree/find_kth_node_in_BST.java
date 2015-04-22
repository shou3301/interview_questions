/**
 * Find Kth smallest node in BST
 */

public class Solution {
    int count = 0;
    int val;
    
    public int kthSmallestInBST(TreeNode root, int k) {
        count = 0;
        helper(root, k);
        return val;
    }
    
    private void helper(TreeNode node, int k) {
        if (node == null) return;
        
        helper(node.left);
        ++count;
        if (count > k) return;
        if (count == k) {
            val = node.val;
            return;
        }
        helper(node.right);
    }
}