/**
 * Intersection of two quadtree. Given QuadTree node.
 */
 
public class QuadNode {
    int val;
    QuadNode[] child = new QuadNode[4];
}

/**
 * 1. Please build a quadtree to represent a 0-1 matrix, assume the matrix is a square and the dimension is power of 2.
 * 2. Given two such quadtrees with same depth, please write a function to calculate how many 1s are overlapped.
 */
 
public class QuadTreeBuilder {
    public QuadNode build(int[][] matrix) {
        return buildHelper(matrix, 0, 0, matrix.length);
    }
    
    private QuadNode buildHelper(int[][] matrix, int x, int y, int len) {
        if (len == 1) {
            return new QuadNode(matrix[x][y]); // number of 1s
        }
        
        QuadNode curr = new QuadNode();
        curr.val = 0;
        curr.child[0] = buildHelper(matrix, x, y, len / 2);
        curr.child[1] = buildHelper(matrix, x + (len / 2), y, len / 2);
        curr.child[2] = buildHelper(matrix, x, y + (len / 2), len / 2);
        curr.child[3] = buildHelper(matrix, x + (len / 2), y + (len / 2), len / 2);
        for (int i = 0; i < 4; i++) {
            curr.val += child[i].val;
        }
        
        return curr;
    }
}

public int overlappingOnes(QuadNode root1, QuadNode root2) {
    if (root1.val == 0 || root2.val == 0) return 0;
    
    if (root1.child[0] == null) return root1.val == root2.val;
    
    int res = 0;
    for (int i = 0; i < 4; i++) {
        res += overlappingOnes(root1.child[i], root2.child[i]);
    }
    
    return res;
}