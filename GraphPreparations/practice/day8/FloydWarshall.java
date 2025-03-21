package GraphPreparations.practice.day8;

public class FloydWarshall {
    private static final Integer INF = Integer.MAX_VALUE;
    // Floyd-warshall - O(v^3)
    public void executeFloydWarshall(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int[][] shortestPath = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shortestPath[i][j] = adjMatrix[i][j];
            }
        }

        // perform relaxation for all nodes from all other nodes
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (shortestPath[i][k] != Integer.MAX_VALUE && shortestPath[k][j] != Integer.MAX_VALUE) {
                        shortestPath[i][j] = Math.min(shortestPath[i][j], shortestPath[i][k] + shortestPath[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (shortestPath[i][i] < 0) {
                System.out.println("Negative cycle detected.");
                return;
            }
        }

        System.out.println("All pair shortest path");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(shortestPath[i][j] + ", ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0,    3,    8,    INF, -4},
            {INF,  0,    INF,  1,    7},
            {INF,  4,    0,    INF,  INF},
            {2,    INF, -5,    0,    INF},
            {INF,  INF,  INF,  6,    0}
        };

        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.executeFloydWarshall(graph);   
    }

}
