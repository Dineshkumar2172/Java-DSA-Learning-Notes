package DSAPreparation;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryMatrixShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        Integer[] dest = {n - 1, n - 1};

        boolean[][] visited = new boolean[n][n];
        Queue<Integer[]> queue = new LinkedList<>();
        
        queue.offer(new Integer[]{0, 0, 1}); // start from 0th element (0, 0) with distance 0
        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int currentVertexRow = current[0], currentVertexCol = current[1];
            int currentDistance = current[2];

            if (currentVertexRow == dest[0] && currentVertexCol == dest[1]) return currentDistance;

            // above row check - formula for checking above rows
            // (r-1, c-1) - for checking above left connected element
            // (r-1, c)   - for checking above connected element
            // (r-1, c+1) - for checking above right connected element
            if (currentVertexRow - 1 >= 0){
                if( currentVertexCol - 1 >= 0
                    && !visited[currentVertexRow - 1][currentVertexCol - 1]){
                        if (grid[currentVertexRow - 1][currentVertexCol - 1] == 0) {
                            queue.offer(new Integer[]{
                                currentVertexRow - 1,
                                currentVertexCol - 1,
                                currentDistance+1
                            });
                            visited[currentVertexRow - 1][currentVertexCol - 1] = true;
                        } 
                }

                if( !visited[currentVertexRow - 1][currentVertexCol]){
                        if ( grid[currentVertexRow - 1][currentVertexCol] == 0) {
                            queue.offer(new Integer[]{
                                currentVertexRow - 1,
                                currentVertexCol,
                                currentDistance+1
                            });
                            visited[currentVertexRow - 1][currentVertexCol] = true;
                        } 
                }

                if(currentVertexCol + 1 < n &&
                    !visited[currentVertexRow - 1][currentVertexCol + 1]){
                        if (grid[currentVertexRow - 1][currentVertexCol + 1] == 0) {
                            queue.offer(new Integer[]{
                                currentVertexRow - 1,
                                currentVertexCol + 1,
                                currentDistance+1
                            });
                            visited[currentVertexRow - 1][currentVertexCol + 1] = true;
                        } 
                }
            }

            // same row check - formula for checking same rows
            // (r, c-1) - for checking left connected element
            // (r, c+1) - for checking right connected element
            if (currentVertexCol - 1 >= 0) {
                if (grid[currentVertexRow][currentVertexCol - 1] == 0 &&
                    !visited[currentVertexRow][currentVertexCol - 1]) {
                        queue.offer(new Integer[] {
                            currentVertexRow,
                            currentVertexCol - 1,
                            currentDistance+1,
                        });
                    } 
            }

            if (currentVertexCol + 1 < n) {
                if (grid[currentVertexRow][currentVertexCol + 1] == 0 &&
                    !visited[currentVertexRow][currentVertexCol + 1]) {
                        queue.offer(new Integer[] {
                            currentVertexRow,
                            currentVertexCol + 1,
                            currentDistance+1,
                        });
                    } 
            }

            // below row check - formula for checking below rows
            // (r+1, c-1)  - for checking bottom left connected element
            // (r+1, c)    - for checking bottom connected element
            // (r+1, c+1)  - for checking bottom right connected element
            if (currentVertexRow + 1 < n){
                if( currentVertexCol - 1 >= 0
                    && !visited[currentVertexRow + 1][currentVertexCol - 1]){
                        if (grid[currentVertexRow + 1][currentVertexCol - 1] == 0) {
                            queue.offer(new Integer[]{
                                currentVertexRow + 1,
                                currentVertexCol - 1,
                                currentDistance+1
                            });
                            visited[currentVertexRow + 1][currentVertexCol - 1] = true;
                        } 
                }

                if( !visited[currentVertexRow + 1][currentVertexCol]){
                        if ( grid[currentVertexRow + 1][currentVertexCol] == 0) {
                            queue.offer(new Integer[]{
                                currentVertexRow + 1,
                                currentVertexCol,
                                currentDistance+1
                            });
                            visited[currentVertexRow + 1][currentVertexCol] = true;
                        } 
                }

                if(currentVertexCol + 1 < n &&
                    !visited[currentVertexRow + 1][currentVertexCol + 1]){
                        if (grid[currentVertexRow + 1][currentVertexCol + 1] == 0) {
                            queue.offer(new Integer[]{
                                currentVertexRow + 1,
                                currentVertexCol + 1,
                                currentDistance+1
                            });
                            visited[currentVertexRow + 1][currentVertexCol + 1] = true;
                        } 
                }
            }
        }


        return -1;
    }

    // optimised approach
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}, {-1, 0}, {-1,-1}, {-1, 1}};

    public int shortestPathBinaryMatrixOptimised(int[][] grid) {
        int n = grid.length;
        
        // return -1 if the start and end are already blocked
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        boolean[][] visited = new boolean[n][n];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{0, 0});
        visited[0][0] = true;

        int minimumSteps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] current = queue.poll();
                int row = current[0], col = current[1];
                if (row == n-1 && col == n-1) return ++minimumSteps;

                for (int k = 0; k < 8; k++) {
                    int nextX = dir[k][0] + row;
                    int nextY = dir[k][1] + col;

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                        if (!visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                            queue.offer(new Integer[]{nextX, nextY});
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }

            minimumSteps++;
        }

        return -1;
    }
}
