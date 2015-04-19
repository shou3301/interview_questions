/**
 * Graph coloring with two colors.
 * Using BFS.
 */
 
public boolean canFillTwoColor(GraphNode node) {
	if (node == null) return true;
	
	Map<GraphNode, Integer> record = new HashMap<>();
	Queue<GraphNode> q = new LinkedList<>();
	q.offer(node);
	int color = 0;
	
	while (!q.isEmpty()) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			GraphNode curr = q.poll();
			record.put(curr, color);
			for (GraphNode neighbor : curr.getNeighbors()) {
				if (record.containsKey(neighbor) && record.get(neighbor) == color)
					return false;
				else if (!recod.containsKey(neighbor)) {
					q.offer(neighbor);
				}
			}
		}
		color = color == 0 ? 1 : 0;
	}
}