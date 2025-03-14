package GraphPreparations.practice.day3;

import GraphPreparations.practice.day2.AdjacencyMatrix;

public class FloydWarshall {

    private static final Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(AdjacencyMatrix adjacencyMatrix) {
        int[][] shortestPath = new int[adjacencyMatrix.getVertexCount()][adjacencyMatrix.getVertexCount()];
        
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


        // perform floyd warshall - vertex to all other vertices
        for (int k = 0; k < adjacencyMatrix.getVertexCount(); k++) {
            for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
                for (int j = 0; j < adjacencyMatrix.getVertexCount(); j++) {
                    if (shortestPath[i][k] != INF && shortestPath[k][j] != INF) {
                        if (shortestPath[i][k] + shortestPath[k][j] < shortestPath[i][j]) {
                            shortestPath[i][j] = shortestPath[i][k] + shortestPath[k][j];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
            if (shortestPath[i][i] < 0) {
                System.out.println("negative cycle detected!");
                return;
            }
        }

        System.out.println("All-pairs shortest path:");
        for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < adjacencyMatrix.getVertexCount(); j++) {
                if (shortestPath[i][j] == INF) {
                    System.out.print("INF, ");
                } else {
                    System.out.print(shortestPath[i][j] + ", ");
                }
            }
            System.out.println("]");
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
