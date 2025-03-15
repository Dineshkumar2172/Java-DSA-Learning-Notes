package GraphPreparations.practice.day4;

public class FloydWarshall {

    static final Integer INF = Integer.MAX_VALUE;

    // all pair shortest path - works by relaxation
    // finds shortest path from all vertices to all other vertices
    public void executeFloydWarshall(int[][] graph) {
        int vertices = graph.length;
        int[][] shortestPath = new int[vertices][vertices];

        // build initial shortest path matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                shortestPath[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < vertices; k++) { // intermediate vertex
            for (int i = 0; i < vertices; i++) { // source vertex
                for (int j = 0; j < vertices; j++) { // destination vertex
                    if (shortestPath[i][k] != INF && shortestPath[k][j] != INF) {
                            shortestPath[i][j] = Math.min(shortestPath[i][j], shortestPath[i][k] + shortestPath[k][j]);        
                    }
                }
            }
        }

        // Detect negative cycles (if any diagonal element becomes negative)
        for (int i = 0; i < vertices; i++) {
            if (shortestPath[i][i] < 0) {
                System.out.println("Negative cycle detected!");
                return;
            }
        }

        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < shortestPath.length; i++) {
            for (int j = 0; j < shortestPath[i].length; j++) {
                if (shortestPath[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(shortestPath[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, 2, 0}
        };

        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.executeFloydWarshall(graph);
    }
}
