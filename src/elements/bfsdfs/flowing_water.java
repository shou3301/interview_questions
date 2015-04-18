/**
 * Given an integer matrix where each number means altitude.
 * Upper and left side is one ocean, and lower and right side is another ocean.
 * Find all points that can have water flow into the two oceans.
 * Water can only flow from higher altitude to lower altitude.
 */
 
public class Point {
    public int x;
    public int y;
}

public List<Point> getFlowPoints(int[][] land) {
    List<Point> res = new ArrayList<>();
    int m = land.length;
    if (m == 0) return res;
    int n = land[0].length;
    if (n == 0) return res;
    
    int[][] count1 = new int[m][n];
    for (int i = 0; i < m; i++) {
        if (count1[i][0] == 0) {
            backfillWater(i, 0, land, count1, m, n);
        }
    }
    for (int i = 0; i < n; i++) {
        if (count1[0][i] == 0) {
            backfillWater(0, i, land, count1, m, n);
        }
    }
    
    int[][] count2 = new int[m][n];
    for (int i = 0; i < m; i++) {
        if (count2[i][n-1] == 0) {
            backfillWater(i,n-1, land, count2, m, n);
        }
    }
    for (int i = 0; i < n; i++) {
        if (count1[m-1][i] == 0) {
            backfillWater(m-1, i, land, count2, m, n);
        }
    }
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (count1[i][j] == 1 && count2[i][j] == 1) {
                res.add(new Point(i, j));
            }
        }
    }
    
    return res;
}

public void backfillWater(int x, int y, int[][] land, int[][] count, int m, int n) {
    if (x < 0 || y < 0 || x >= m || y >= n) return;
    
    if (count[x][y] == 1) return;
    
    count[x][y] = 1;
    
    if (x - 1 >= 0 && land[x][y] <= land[x-1][y])
        backfillWater(x - 1, y, land, count, m, n);
    
    if (y - 1 >= 0 && land[x][y] <= land[x][y-1])
        backfillWater(x, y - 1, land, count, m, n);
        
    if (x + 1 < m && land[x][y] <= land[x+1][y])
        backfillWater(x + 1, y, land, count, m, n);
        
    if (y + 1 < n && land[x][y] <= land[x][y+1])
        backfillWater(x, y + 1, land, count, m, n);
}