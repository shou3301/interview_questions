/*
一个数组 A: 1 3 0 2 4 7
input: dest-node: A0
output: all the source nodes: (A1, A3, A4)

数组中每个元素表示他能走的步数，既能向左走 又能向右走，能到A[0]的点有A[1]和A[4]，A[1]可以走3步到A[4] A[4]能走4步道A[0]。
*/

// Return a list of index that can eventually reach the given point
public List<Integer> findAllSources(int[] A, int index) {
    // "create" a graph
    Map<Integer, List<Integer>> incoming = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
        incoming.put(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < A.length; i++) {
        if (i - A[i] >= 0) {
            incoming.get(i - A[i]).add(i);
        }
        if (i + A[i] < A.length) {
            incoming.get(i + A[i]).add(i);
        }
    }
    
    // bfs
    Queue<Integer> q = new LinkedList<>();
    q.offer(index);
    
    Set<Integer> sources = new HashSet<>();
    while (!q.isEmpty()) {
        int curr = q.poll();
        if (!sources.contains(curr)) sources.add(curr);
        for (Integer s : incoming.get(curr)) {
            if (!sources.contains(s)) q.offer(s);
        }
    }
    
    return new ArrayList<Integer>(sources);
}