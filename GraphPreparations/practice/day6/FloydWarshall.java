package GraphPreparations.practice.day6;

public class FloydWarshall {
    private final static Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(int v, int[][] graph) {
        int[][] tempGraph = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                tempGraph[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (tempGraph[i][k] != INF && tempGraph[k][j] != INF) {
                        tempGraph[i][j] = Math.min(tempGraph[i][j], tempGraph[i][k] + tempGraph[k][j]);
                    }
                }
            }
        }

        // negative cycle detection
        for (int i = 0; i < v; i++) {
            if (tempGraph[i][i] < 0) {
                System.out.println("negative cycle found");
                return;
            }
        }

        System.out.println("All pair shortest path result : ");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(tempGraph[i][j] + ", ");
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
