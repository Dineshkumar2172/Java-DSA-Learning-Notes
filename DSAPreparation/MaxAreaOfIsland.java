package DSAPreparation;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    // directions at which we can traverse the given island
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numberOfConnected(boolean[][] visited, int[][] grid, int row, int col) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{row, col});
        visited[row][col] = true;

        int area = 1;
        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int currentRow = current[0], currentCol = current[1];
            for (int[] direction: directions) {
                int nextRow = currentRow + direction[0], nextCol = currentCol + direction[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length) {
                    if (grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                        queue.offer(new Integer[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                        area++;
                    }
                }
            }
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int localArea = numberOfConnected(visited, grid, i, j);
                    maxArea = localArea > maxArea ? localArea : maxArea;
                }
            }
        }

        return maxArea;
    }
}
