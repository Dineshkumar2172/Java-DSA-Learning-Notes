package GraphPreparations.week2.FloydWarshallAlgorithm;

public class FloydWarshallImplementation {
    
    // Algorithm Steps
    // 1. Create a distance matrix dist[][], where dist[i][j] stores the shortest distance from node i to node j.
    //      i) Initialize dist[i][j] = weight(i → j) if an edge exists.
    //     ii) Otherwise, set dist[i][j] = ∞ (Integer.MAX_VALUE).
    //    iii) Set dist[i][i] = 0 for all i.
    // 2. Run a Triple Nested Loop:
    //      i) Iterate over all possible intermediate nodes k.
    //     ii) Update dist[i][j] using dist[i][k] + dist[k][j].
    // 3. Check for Negative Cycles:
    //      i) If dist[i][i] < 0 for any i, there is a negative cycle.

    private final static Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(int[][] graph) {
        Integer V = graph.length;
        int[][] shortestDistance = new int[V][V];

        // step1: initialize a distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // copy the input graph weights
                shortestDistance[i][j] = graph[i][j];
            }
        }

        // step 2: run floyd-warshall algorithm - for each iteration of A^(0-n)
        for (int k = 0; k < V; k++) { // intermediate node
            for (int i = 0; i < V; i++) { // for source node
                for (int j = 0; j < V; j++) { // for destination node
                    if (shortestDistance[i][k] != INF && shortestDistance[k][j] != INF) {
                        shortestDistance[i][j] = Math.min(shortestDistance[i][j], shortestDistance[i][k] + shortestDistance[k][j]);
                    }
                }
            }
        }

        // Step 3: Detect Negative Cycles
        for (int i = 0; i < V; i++) {
            if (shortestDistance[i][i] < 0) {
                System.out.println("Negative cycle detected!");
                return;
            }
        }

        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < shortestDistance.length; i++) {
            for (int j = 0; j < shortestDistance[i].length; j++) {
                if (shortestDistance[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(shortestDistance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // representation of weighted graph in adjacency matrix
        int[][] graph = {
            {0, 3, INF, INF, INF, INF},
            {INF, 0, 1, INF, INF, INF},
            {INF, INF, 0, 7, INF, 2},
            {INF, INF, INF, 0, 2, INF},
            {INF, INF, INF, INF, 0, 3},
            {INF, INF, INF, INF, INF, 0}
        };

        FloydWarshallImplementation floydWarshallImplementation = new FloydWarshallImplementation();
        floydWarshallImplementation.executeFloydWarshall(graph);
    }
}
