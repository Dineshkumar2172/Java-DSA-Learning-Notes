package GraphPreparations.practice.day1;

public class FloydWarshallAlgorithm {
    // 1. It's a all pairs shortest path algorithm (works based on dynamic programming)
    // 1. It works based on adjacency matrix representation.
    // 2. We perform relaxation on top of all the vertices on all the other vertices for A^(0 to n-1) times.
    private static final Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(AdjacencyMatrix adjacencyMatrix) {
        int[][] shortestPath = new int[adjacencyMatrix.getNumberOfVertices()][adjacencyMatrix.getNumberOfVertices()];

        for (int i = 0; i < adjacencyMatrix.getNumberOfVertices(); i++) {
            for (int j = 0; j < adjacencyMatrix.getNumberOfVertices(); j++) {
                if (i == j) {
                    shortestPath[i][j] = 0; // Distance to itself ia 0
                } else if (adjacencyMatrix.getWeight(i, j) != 0) {
                    shortestPath[i][j] = adjacencyMatrix.getWeight(i, j);
                } else {
                    shortestPath[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < adjacencyMatrix.getNumberOfVertices(); k++) {
            for (int i = 0; i < adjacencyMatrix.getNumberOfVertices(); i++) {
                for (int j = 0; j < adjacencyMatrix.getNumberOfVertices(); j++) {
                    if (shortestPath[i][k] != INF && shortestPath[k][j] !=INF) {
                        shortestPath[i][j] = Math.min(shortestPath[i][j], shortestPath[i][k] + shortestPath[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < adjacencyMatrix.getNumberOfVertices(); i++) {
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
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, false, true);
        adjacencyMatrix.addEdge(0, 1, 3);
        adjacencyMatrix.addEdge(0, 2, 6);
        adjacencyMatrix.addEdge(1, 2, 2);
        adjacencyMatrix.addEdge(1, 3, 1);
        adjacencyMatrix.addEdge(2, 3, 1);

        FloydWarshallAlgorithm fwa = new FloydWarshallAlgorithm();
        fwa.executeFloydWarshall(adjacencyMatrix);
    }
}
