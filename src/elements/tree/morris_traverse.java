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
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        TreeNode p = root;
        TreeNode last = null, t1 = null, t2 = null;
        
        while (p != null) {
            if (p.left == null) {
                if (last != null && last.val > p.val) {
                    if (t1 == null) {
                        t1 = last;
                    }
                    t2 = p;
                }
                last = p;
                p = p.right;
            } else {
                TreeNode q = p.left;
                while (q.right != null && q.right != p) {
                    q = q.right;
                }
                
                if (q.right == p) {
                    q.right = null;
                    if (last != null && last.val > p.val) {
                        if (t1 == null) {
                            t1 = last;
                        }
                        t2 = p;
                    }
                    last = p;
                    p = p.right;
                } else {
                    q.right = p;
                    p = p.left;
                }
            }
        }
        
        if (t1 != null && t2 != null) {
            int tmp = t1.val;
            t1.val = t2.val;
            t2.val = tmp;
        }
    }
}