package DSAPreparation;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathObstacleElim {
     private Integer[][] directions = {{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;

        if (k >= m+n-2) return m+n-2;

        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0][0][k] = true;
        queue.offer(new Integer[]{0, 0, k, 0}); // row, col, remainK, steps

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int row = current[0], col = current[1], currentK = current[2], steps = current[3];

            if (row == m-1 && col == n-1) return steps;

            for (Integer[] direction: directions) {
                int nextX = row + direction[0], nextY = col + direction[1];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    int newK = currentK - (grid[nextX][nextY] == 1 ? 1 : 0);

                    if (newK >= 0 && !visited[nextX][nextY][newK]) {
                        visited[nextX][nextY][newK] = true;
                        queue.offer(new Integer[]{nextX, nextY, newK, steps+1});
                    }
                }
            }
        }

        return -1;
    }
}
