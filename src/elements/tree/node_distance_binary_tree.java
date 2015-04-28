/*
Find the distance between two keys in a binary tree, no parent pointers are given.
*/

// If either not exist, return -1.
public int distance(TreeNode root, TreeNode v1, TreeNode v2) {
    TreeNode anc = lca(root, v1, v2, 0);
    
    if (d1 != -1 && d2 != -1) return res;
    else if (d1 != -1) return height(anc, v2, 0);
    else if (d2 != -1) return height(anc, v1, 0);
        
    return -1;
}

int d1 = -1, d2 = -1, res = -1;

public TreeNode lca(TreeNode node, TreeNode v1, TreeNode v2, int depth) {
    if (node == v1) {
        d1 = depth;
        return node;
    } else if (node == v2) {
        d2 = depth;
        return node;
    }
    
    if (node == null) return null;
    
    TreeNode l = lca(node.left, v1, v2, depth + 1);
    TreeNode r = lca(node.right, v1, v2, depth + 1);
    
    if (l != null && r != null) {
        res = (d1 - depth) + (d2 - depth);
        return node;
    }
    if (l == null && r != null) return r;
    else return l;
}

public int height(TreeNode node, TreeNode child, int depth) {
    if (node == null) return -1;
    if (node == child) {
        return depth;
    } else {
        return Math.max(height(node.left, child, depth + 1), height(node.right, child, depth + 1));
    }
}