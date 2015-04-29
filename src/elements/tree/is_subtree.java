/*
You have two very large binary trees: T1, with millions of nodes, 
and T2 with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
*/

public boolean subtree(TreeNode root1, TreeNode root2) {
    if (root2 == null) return true;
    if (root1 == null) return false;
    
    if (isMatch(root1, root2)) {
        return true;
    }
    
    return subtree(root1.left, root2) || subtree(root1.right, root2);
}

public boolean isMatch(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) return true;
    
    if (!isMatch(node1.val == node2.val)) return false;
    
    return isMatch(node1.left, node2.left) && isMatch(node1.right, node2.right);
}