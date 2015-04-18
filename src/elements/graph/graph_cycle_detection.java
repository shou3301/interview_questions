/**
 * Graph cycle detect
 */
 
// In undirected graph - DFS
public boolean hasCycleUndirected1(Node node) {
    if (node == null)
        return false;
        
    if (node.visited) return true;
    
    node.visited = true;
    for (Node neighbor : node.getNeighbors()) {
        if (hasCycleUndirected1(neighbor)) return true;
    }
    
    return false;
}

// In undirected graph - Union
public boolean hasCycleUndirected2(List<Edge> edges) {
    for (Edge edge : edges) {
        Node p1 = findParent(parent, edge.src);
        Node p2 = findParent(parent, edge.dest);
        if (p1 == p2)
            return true;
        union(parent, p1, p2);
    }
    
    return false;
}

public Node findParent(Map<Node, Node> parent, Node n) {
    if (parent.get(n) == null) return;
    return findParent(parent, parent.get(n));
}

public void union(Map<Node, Node> parent, Node n1, Node n2) {
    Node p1 = findParent(parent, n1);
    Node p2 = findParent(parent, n2);
    parent.put(p2, p1);
}

// In directed graph
public boolean hasCycleDirected(Node node) {
    return helper(node, new HashSet<Node>());
}

public boolean helper(Node node, Set<Node> path) {
    if (node == null) return false;
    
    if (path.contains(node)) return true;
    
    path.add(node);
    for(Node neighbor : node.neighbors) {
        if (helper(neighbor, path)) return true;
    }
    path.remove(node);
    
    return false;
}