package GraphPreparations.practice.day11;

public class FloydWarshall {
    // 1. It's a all pair shortest path algorithm - find shortest path from all vertices to all others.
    // 2. It's based on dynamic programming and based on matrix representation.
    // 3. It works based on minimization on top of all vertices for A^N times based on earlier matrix.

    public static final Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(AdjacencyMatrix adjacencyMatrix) {
        final int N = adjacencyMatrix.getVertexCount();
        int[][] shortestPath = new int[N][N];
        
        // creating matrix representation for floyd warshall
        // 1. diagonals should be 0
        // 2. No edges should be represented as INF
        // 3. Edges should be represented with weights
        for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
            for (int j = 0; j < adjacencyMatrix.getVertexCount(); j++) {
                if (i == j) {
                    shortestPath[i][j] = 0; // Distance to itself is 0
                } else if (adjacencyMatrix.getAdjacencyMatrix()[i][j] != 0) {
                    shortestPath[i][j] = adjacencyMatrix.getAdjacencyMatrix()[i][j];
                } else {
                    shortestPath[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (shortestPath[i][k] != INF && shortestPath[k][j] != INF) {
                        shortestPath[i][j] = Math.min(shortestPath[i][j], shortestPath[i][k] + shortestPath[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (shortestPath[i][i] < 0) {
                System.out.println("negative cycle detected");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((shortestPath[i][j] != INF ? shortestPath[i][j] : "INF") + ", ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, true, false);
        adjacencyMatrix.addEdge(0, 1, 3);
        adjacencyMatrix.addEdge(0, 2, 6);
        adjacencyMatrix.addEdge(1, 2, 2);
        adjacencyMatrix.addEdge(1, 3, 1);
        adjacencyMatrix.addEdge(2, 3, 1);

        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.executeFloydWarshall(adjacencyMatrix);
    }
}
