/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/

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
    
    List<TreeNode>[][] memo;
    
    public List<TreeNode> generateTrees(int n) {
        if (n > 0) {
            memo = new ArrayList[n+1][n+1];
        }
        
        return generate(1, n);
    }
    
    public List<TreeNode> generate(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        
        if (memo[s][e] != null) return memo[s][e];
        
        if (s == e) {
            res.add(new TreeNode(s));
            memo[s][e] = res;
            return res;
        }
        
        for (int i = s; i <= e; i++) {
            for (TreeNode left : generate(s, i - 1)) {
                for (TreeNode right : generate(i + 1, e)) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    res.add(curr);
                }
            }
        }
        
        memo[s][e] = res;
        return res;
    }
}