/*
Rolling Ball Game

一个球从起点开始沿着通道，看能不能滚到终点。不过有限制， 每次球一走到底要不到边界，要不到障碍物，中间不能停留。 可以上下左右走，然后让写个function 给定起点， 终点，和图，判断是不是solvable.
For example (1代表有障碍, 0代表可以通过):
*/

public boolean solvable(int[][] board, int sx, int sy, int dx, int dy) {
    if (sx == dx && sy == dy) return true;
    
    int m = board.length;
    int n = board[0].length;
    
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(sx, sy));
    
    boolean[][] visited = new boolean[m][n];
    
    while (!queue.isEmpty()) {
        Pair p = queue.poll();
        
        if (p.x == dx && p.y == dy) return true;
        
        visited[p.x][p.y] = true;
        
        // go left
        int j = p.y - 1;
        while (j >= 0 && !visited[p.x][j] && board[p.x][j] != 1) {
            j--;
        }
        if (++j != p.y) {
            queue.offer(new Pair(p.x, j));
        }
        
        // go right
        j = p.y + 1;
        while (j < n && !visited[p.x][j] && board[p.x][j] != 1) {
            j++;
        }
        if (--j != p.y) {
            queue.offer(new Pair(p.x, j));
        }
        
        // go up
        j = p.x - 1;
        while (j >= 0 && !visited[j][p.y] && board[j][p.y] != 1) {
            j--;
        }
        if (++j != p.x) {
            queue.offer(new Pair(j, p.y));
        }
        
        // go down
        j = p.x + 1;
        while (j < m && !visited[j][p.y] && board[j][p.y] != 1) {
            j++;
        }
        if (--j != p.x) {
            queue.offer(new Pair(j, p.y));
        }
    }
    
    return false;
}

public class Pair {
    public int x;
    public int y;
}