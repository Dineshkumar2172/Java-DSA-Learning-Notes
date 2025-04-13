package GraphPreparations.practice.day11;

public class FloydWarshall {
    // 1. It's a all pair shortest path algorithm - find shortest path from all vertices to all others.
    // 2. It's based on dynamic programming and based on matrix representation.
    // 3. It works based on minimization on top of all vertices for A^N times based on earlier matrix.

    public static final Integer INF = Integer.MAX_VALUE;

    public void executeFloydWarshall(AdjacencyMatrix adjacencyMatrix) {
        
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
