/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        Queue<UndirectedGraphNode> q1 = new LinkedList<>();
        q1.offer(node);
        UndirectedGraphNode cf = clone(node);
        Map<Integer, UndirectedGraphNode> cloned = new HashMap<>();
        cloned.put(node.label, cf);

        while (!q1.isEmpty()) {
        	UndirectedGraphNode o = q1.poll();
        	UndirectedGraphNode c = cloned.get(o.label);
        	for (UndirectedGraphNode neighbor : o.neighbors) {
        		if (!cloned.containsKey(neighbor.label)) {
        			cloned.put(neighbor.label, clone(neighbor));
        			q1.offer(neighbor);
        		}

        		c.neighbors.add(cloned.get(neighbor.label));
        	}
        }

        return cf;
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
    	UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    	return copy;
    }
}