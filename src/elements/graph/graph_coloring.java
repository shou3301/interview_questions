/**
 * Given M colors color[0] - color[m-1], check whether if we can assign each graph node a color
 * so that for any two neighbor nodes, they don't have the same color.
 *
 * Using DFS.
 */
 
public boolean canFillColor(GraphNode node, int m) {
	return helper(node, new HashMap<GraphNode, Integer>());
	// If want to output the color for each node,
	// then we just need to output the map.
}

public boolean helper(GraphNode node, Map<GraphNode, Integer> colorMap) {
	if (node == null) return true;
	
	for (int i = 0; i < m; i++) {
		// for every color
		if (isSafe(node, colorMap, i)) {
			colorMap.put(node, i);
			for (GraphNode neighbor : node.getNeighbors()) {
				if (!colorMap.containsKey(neighbor)) {
					if (helper(neighbor, colorMap)) return true;
				}
			}
			colorMap.remove(node);
		}
	}
	
	return false;
}

public boolean isSafe(GraphNode node, Map<GraphNode, Integer> colorMap, int color) {
	for (GraphNode neighbor : node.getNeighbors()) {
		if (colorMap.containsKey(neighbor) && colorMap.get(neighbor) == color)
			return false;
	}
	
	return true;
}