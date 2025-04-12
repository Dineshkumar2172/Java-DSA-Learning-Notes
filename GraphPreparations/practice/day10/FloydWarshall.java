package GraphPreparations.practice.day10;

public class FloydWarshall {
    
    private static final Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(int[][] graph) {
        int n = graph.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (graph[i][i] < 0) {
                System.out.println("Negative cycle detected");
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((graph[i][j] != INF ? graph[i][j] : "INF") + " ");
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
