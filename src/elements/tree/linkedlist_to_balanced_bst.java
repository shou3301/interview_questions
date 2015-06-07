/**
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode n = head;
        while (n != null) {
            len++;
            n = n.next;
        }
        curr = head;
        return helper(0, len - 1);
    }
    
    ListNode curr = null;
    
    private TreeNode helper(int s, int e) {
        if (s > e) return null;
        if (s == e) {
            TreeNode node = new TreeNode(curr.val);
            curr = curr.next;
            return node;
        }
        
        int m = (s + e) / 2;
        TreeNode left = helper(s, m - 1);
        TreeNode node = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = helper(m + 1, e);
        node.left = left;
        node.right = right;
        
        return node;
    }
}