/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        
        k = k % len;
        
        if (k == 0) return head;
        
        ListNode s = head, f = head;
        int c = 0;
        while (c < k) {
            c++;
            f = f.next;
        }
        
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        
        ListNode newHead = s.next;
        s.next = null;
        f.next = head;
        
        return newHead;
    }
}