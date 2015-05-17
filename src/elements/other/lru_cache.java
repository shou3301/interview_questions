/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
    
    private int capacity;
    
    private ListNode head;
    
    private ListNode tail;
    
    private Map<Integer, ListNode> map;
    
    protected class ListNode {
        public ListNode previous;
        public ListNode next;
        public int val;
        public int key;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.previous = null;
            this.next = null;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int res = map.get(key).val;
            moveToHead(map.get(key));
            return res;
        } else
            return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            moveToHead(map.get(key));
            map.get(key).val = value;
            return;
        }
        
        if (map.size() >= capacity) {
            ListNode n = removeTail();
            map.remove(n.key);
        }
        ListNode node = new ListNode(key, value);
        addToHead(node);
        map.put(key, node);
    }
    
    private void moveToHead(ListNode node) {
        if (head == node) return;
        if (tail == node) {
            ListNode t = removeTail();
            addToHead(t);
            return;
        }
        
        if (node.previous != null) {
            node.previous.next = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }
        
        node.next = null;
        node.previous = null;
        addToHead(node);
    }
    
    private ListNode removeTail() {
        if (tail == head) {
            ListNode tmp = tail;
            head = null;
            tail = null;
            return tmp;
        }
        
        ListNode tmp = tail;
        tail.next.previous = null;
        tail = tail.next;
        tmp.next = null;
        
        return tmp;
    }
    
    private void addToHead(ListNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.next = node;
            node.previous = head;
            head = node;
        }
    }
}
































