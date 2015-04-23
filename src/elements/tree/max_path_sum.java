/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    
    private int maxSum(TreeNode node) {
        if (node == null) return 0;
        
        int l = maxSum(node.left);
        int r = maxSum(node.right);
        
        int curr = node.val;
        curr = Math.max(curr, l + curr);
        curr = Math.max(curr, r + curr);
        
        max = Math.max(max, curr);
        
        return Math.max(node.val, Math.max(node.val + l, node.val + r));
    }
}