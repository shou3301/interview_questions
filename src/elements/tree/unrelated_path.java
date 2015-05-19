/*
Problem Statement
    
This problem is about paths on a tree. A path is any sequence of one or more vertices such that all the vertices are distinct and each pair of consecutive vertices is connected by an edge of the tree.

Our tree is a rooted tree with N+1 vertices, labeled 0 through N. The label of the root is 0. For each i, the parent of vertex i has a number smaller than i. You are given the description of the tree: a int[] parent with N elements. For each i, the vertex parent[i] is the parent of the vertex i+1.

The vertex u is an ancestor of the vertex v if u lies on the (only) path that connects v to the root. Note that each vertex is its own ancestor. Also note that the root is an ancestor of all other vertices.

Two paths A and B in our tree are said to be related if path A contains a vertex u and path B contains a vertex v such that one of u, v is an ancestor of the other.

We want to choose many paths in such a way that no two of them will be related. Find and return the largest possible number of pairwise unrelated paths in the given tree.
*/


public class UnrelatedPaths {
    // Equals to find how many leaves are there
    public int maxUnrelatedPaths(int[] parent) {
        if (parent.length == 0) return 1;
        
        // index
        Set<Integer> count = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            if (!count.contains(parent[i])) {
                count.add(parent[i]);
            }
        }
        
        int res = 0;
        for (int i = parent.length; i > 0; i--) {
            if (!count.contains(i)) res++;
        }
        
        return res;
    }
}