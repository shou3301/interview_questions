/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        ListNode fakeHead = new ListNode(0);
        ListNode last = fakeHead;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                heap.add(lists[i]);
        }
        
        while (!heap.isEmpty()) {
            ListNode curr = heap.remove();
            last.next = curr;
            last = curr;
            if (curr.next != null)
                heap.add(curr.next);
        }
        
        return fakeHead.next;
    }
}