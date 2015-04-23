/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode w = fake;
        
        while (w.next != null) {
            if (w.next.val == val) {
                w.next = w.next.next;
            } else {
                w = w.next;
            }
        }
        
        return fake.next;
    }
}