package DSAPreparation;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    // check four sides of the current cell in a given matrix
    int[][] directions = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public void executeBFSSearch(boolean[][] visited, char[][] grid, int row, int col) {
        // search on all four directions, if connected cells are found
        // use a queue to store and traverse through it
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Integer[] currentPosition = queue.poll();
            int currentRow = currentPosition[0], currentCol = currentPosition[1];

            for (int[] direction: directions) {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];
                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
                    if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1') {
                        queue.offer(new Integer[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islandCount++;
                    executeBFSSearch(visited, grid, i, j);
                }
            }
        }

        return islandCount;
    }
}
