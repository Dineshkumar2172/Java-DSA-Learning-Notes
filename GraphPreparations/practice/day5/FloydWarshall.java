package GraphPreparations.practice.day5;

public class FloydWarshall {
    private static final Integer INF = 99999; // Avoids integer overflow

    public void executeFloydWarshall(int v, int[][] graph) {
        int[][] shortestPath = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                shortestPath[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (shortestPath[i][k] != INF && shortestPath[k][j] != INF) {
                        shortestPath[i][j] = Math.min(shortestPath[i][j], shortestPath[i][k] + shortestPath[k][j]);
                    }
                }
            }
        }

        // detecting negative cycles
        for (int i = 0; i < v; i++) {
            if(shortestPath[i][i] < 0) {
                System.out.println("negative cycle found");
                return;
            }
        }

        System.out.println("shortest distance floyd warshall result : ");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (shortestPath[i][j] == INF) {
                    System.out.print("INF, ");
                    continue;
                }
                System.out.print(shortestPath[i][j] + ", ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int vertices = 5;
        int[][] graph = {
            {0,    3,    8,    INF, -4},
            {INF,  0,    INF,  1,    7},
            {INF,  4,    0,    INF,  INF},
            {2,    INF, -5,    0,    INF},
            {INF,  INF,  INF,  6,    0}
        };

        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.executeFloydWarshall(vertices, graph);
        
    }
}
