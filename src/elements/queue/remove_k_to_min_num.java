/**
 * given a number, remove K characters, return the min number we can get.
 */
public String minNum(String origin, int k) {
    if (origin == null && origin.length() == 0 || k >= origin.length()) return "";
    if (k == 0) return origin;
    
    Deque<Character> q = new LinkedList<>();
    int removed = 0;
    
    for (int i = 0; i < origin.length(); i++) {
        while (removed < k && !q.isEmpty() && q.peekLast() > origin.charAt(i)) {
            removed++;
            q.removeLast();
        }
        q.addLast(origin.charAt(i));
    }
    
    while (removed < k && !q.isEmpty()) {
        removed++;
        q.removeLast();
    }
    
    StringBuilder sb = new StringBuilder();
    while(!q.isEmpty()) {
        sb.append(q.removeFirst());
    }
    
    return sb.toString();
}