/*
一个 n x n 矩阵，每个房间可能是封闭的房间，可能是警察，可能是开的房间，
封闭的房间不能过，返回一个n x n矩阵，每一个元素是最近的警察到这个房间的最短距离。
初始矩阵中-1代表封闭房间，INT_MAX代表普通房间，0代表有警察的房间。

常规思路是对每一个警察做一次BFS，复杂度为O(n^3)。可以一开始找出所有警察，然后一起push到BFS的queue里面，同时搜索。复杂度可降为O(n^2)。
本题出现的频率还是很高的，比如还有这样的描述形式：
给一个matrix里面有人，墙和空格，把空格里填上需要走到最近的人那里的步数。
*/

public void closestPolice(int[][] matrix) {
    Queue<Pair> queue = new LinkedList<>();
    int m = matrix.length;
    int n = matrix[0].length;
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0) {
                queue.offer(new Pair(i, j));
            }
        }
    }
    
    int level = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Pair p = queue.poll();
            matrix[p.x][p.y] = Math.min(matrix[p.x][p.y], level);
            visited[p.x][p.y] = true;
            
            if (p.x - 1 >= 0 && matrix[p.x - 1][y] == Integer.MAX_VALUE) queue.offer(new Pair(p.x - 1, p.y));
            if (p.x + 1 < m && matrix[p.x + 1][y] == Integer.MAX_VALUE) queue.offer(new Pair(p.x + 1, p.y));
            if (p.y - 1 >= 0 && matrix[p.x][p.y - 1] == Integer.MAX_VALUE) queue.offer(new Pair(p.x, p.y - 1));
            if (p.y + 1 < n && matrix[p.x][p.y + 1] == Integer.MAX_VALUE) queue.offer(new Pair(p.x, p.y + 1));
        }
        level++;
    }
}

public class Pair {
    public int x;
    public int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}