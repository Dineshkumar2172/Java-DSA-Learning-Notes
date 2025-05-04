package GraphPreparations.practice.day16;

import java.util.Arrays;

public class FloydWarshall {
    // 1. It's a all pair shortest path algorithm - find shortest path from all vertices to all others.
    // 2. It's based on dynamic programming and based on matrix representation.
    // 3. It works based on minimization on top of all vertices for A^N times based on earlier matrix.

    public static final Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(AdjacencyMatrix adjacencyMatrix) {
        int n = adjacencyMatrix.getVertexCount();
        Integer[][] shortestDistance = new Integer[n][n];
        
        for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
            for (int j = 0; j < adjacencyMatrix.getVertexCount(); j++) {
                if (i == j) {
                    shortestDistance[i][j] = 0; // Distance to itself is 0
                } else if (adjacencyMatrix.getAdjacencyMatrix()[i][j] != 0) {
                    shortestDistance[i][j] = adjacencyMatrix.getAdjacencyMatrix()[i][j];
                } else {
                    shortestDistance[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (shortestDistance[i][k] != INF && shortestDistance[k][j] != INF){
                        shortestDistance[i][j] = Math.min(
                                shortestDistance[i][j], 
                                shortestDistance[i][k] + shortestDistance[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (shortestDistance[i][i] < 0) {
                System.out.println("negative cycle detected");
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((shortestDistance[i][j] != INF ? shortestDistance[i][j] : "INF") + ", ");
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
