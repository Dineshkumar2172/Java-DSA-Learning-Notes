package GraphPreparations.practice.day9;

public class FloydWarshall {
    private static final Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] shortestPath = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shortestPath[i][j] = graph[i][j];
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (shortestPath[i][k] != INF && shortestPath[k][j] != INF) {
                        shortestPath[i][j] = Math.min(shortestPath[i][j], shortestPath[i][k] + shortestPath[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (shortestPath[i][i] < 0) {
                System.out.println("negative cycle detected");
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((shortestPath[i][j] == INF ? "INF" : shortestPath[i][j]) + ", ");
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
