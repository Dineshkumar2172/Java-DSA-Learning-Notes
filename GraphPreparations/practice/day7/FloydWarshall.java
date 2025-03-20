package GraphPreparations.practice.day7;

public class FloydWarshall {
    private static final Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(int vertex, int[][] adjMatrix) {
        int[][] shortestDistance = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                shortestDistance[i][j] = adjMatrix[i][j];
            }
        }

        for (int k = 0; k < vertex; k++) {
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < vertex; j++) {
                    if (shortestDistance[i][k] != INF && shortestDistance[k][j] != INF
                        && shortestDistance[i][k] + shortestDistance[k][j] < shortestDistance[i][j]) {
                            shortestDistance[i][j] = shortestDistance[i][k] + shortestDistance[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < vertex; i++) {
            if (shortestDistance[i][i] < 0) {
                System.out.println("negative cycle detected");
                return;
            }
        }

        System.out.println("All pair shortest path result : ");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(shortestDistance[i][j] + ", ");
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
