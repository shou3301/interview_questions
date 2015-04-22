/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode w = head;
        while (w != null) {
            RandomListNode next = w.next;
            RandomListNode copy = new RandomListNode(w.label);
            w.next = copy;
            copy.next = next;
            w = next;
        }
        
        w = head;
        while (w != null) {
            if (w.random != null) {
                w.next.random = w.random.next;
            } else {
                w.next.random = null;
            }
            w = w.next.next;
        }
        
        RandomListNode copyHead = head.next;
        w = head;
        while (w != null) {
            RandomListNode copy = w.next;
            w.next = copy.next;
            if (w.next != null) {
                copy.next = w.next.next;
            }
            
            w = w.next;
        }
        
        return copyHead;
    }
}