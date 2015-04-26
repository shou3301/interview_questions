/*
Three segments of lengths A, B, C form a triangle iff
A + B > C
B + C > A
A + C > B

e.g.
6, 4, 5 can form a triangle
10, 2, 7 can’t

Given a list of segments lengths algorithm should find at least one triplet of segments that form a triangle (if any).

Method should return an array of either:

3 elements: segments that form a triangle (i.e. satisfy the condition above)
empty array if there are no such segments
*/

// The result array should has length = 3
// If there is no valid triangle, then return [-1, -1, -1]
public int[] findValidTriangle(int[] A) {
    if (A.length < 3) return new int[] {-1, -1, -1};
    
    Arrays.sort(A);
    int[] res = new int[3];
    
    for (int i = 0; i < A.length - 2; i++) {
        for (int j = i + 1; j < A.length - 1; j++) {
            if (A[j+1] - A[j] < A[i]) {
                return new int[] {i, j, j+1};
            }
        }
    }
    
    return new int[] {-1, -1, -1};
}

// A follow up question: Could you return the number of all valid triangles? You can assume there’s no duplicates in the original array.
// O(n^2)
public int findNumOfValidTriangles(int[] A) {
    if (A.length < 3) return 0;
    
    Arrays.sort(A);
    int count = 0;
    for (int i = 0; i < A.length - 2; i++) {
        for (int j = i + 1, k = i + 2; j < A.length - 1; j++) {
            while (k < A.length && A[i] + A[j] > A[k]) k++;
            count += k - j - 1;
        }
    }
    
    return count;
}

// A follow up return all valid triangles
// Based on above, it's trivial.