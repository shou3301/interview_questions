/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, index);
    }
    
    public TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2, Map<Integer, Integer> index) {
        if (s1 > e1) return null;
        
        TreeNode curr = new TreeNode(preorder[s1]);
        int idx = index.get(preorder[s1]);
        int lsize = idx - s2;
        curr.left = build(preorder, s1 + 1, s1 + lsize, inorder, s2, idx - 1, index);
        curr.right = build(preorder, s1 + lsize + 1, e1, inorder, idx + 1, e2, index);
        
        return curr;
    }
}