/**
 * Print out the exterior of a binary tree.
 */
 
public class PrintExterior {
    
    public void printExteropr(TreeNode root) {
        if (root == null) return;
        print(root.val);
        printLeftSubTree(root.left, true);
        printRightSubTree(root.right, true);
    }
    
    private void printLeftSubTree(TreeNode node, boolean isBoundary) {
        if (node == null) return;
        if (node.left == null && node.right == null || isBoundary)
            print(node.val);
        
        printLeftSubTree(node.left, isBoundary);
        printLeftSubTree(node.right, isBoundary && node.left == null);
    }
    
    private void printRightSubTree(TreeNode node, boolean isBoundary) {
        if (node == null) return;
        
        printRightSubTree(node.left, node.right == null && isBoundary);
        printRightSubTree(node.right, isBoundary);
        
        if (isBoundary || node.left == null && node.right == null)
            print(node.val);
    }
    
}