/*
Given a Binary Tree, find the deepest leaf node that is left child of its parent.
*/

public TreeNode deepestLeftNode(TreeNode root) {
    helper(root, true, 0);
    return res;
}

int maxDepth = -1;
TreeNode res = null;

public void helper(TreeNode node, boolean left, int depth) {
    if (node == null) return;
    if (node.left == null && node.right == null) {
        if (depth > maxDepth && left) {
            maxDepth = depth;
            res = node;
        }
        return;
    }
    
    helper(node.left, true, depth + 1);
    helper(node.right, false, depth + 1);
}