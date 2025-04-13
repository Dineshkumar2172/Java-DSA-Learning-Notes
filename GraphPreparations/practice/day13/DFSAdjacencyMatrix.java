package GraphPreparations.practice.day13;

import java.util.Stack;

public class DFSAdjacencyMatrix {
    
    public void executeDFSIterative(Integer startVertex, AdjacencyMatrix adjacencyMatrix) {
       
    }

    public void executeDFSRecursive(Integer vertex, AdjacencyMatrix adjacencyMatrix, boolean[] visitedvertices) {
        
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, true, false);
        // Add edges
        adjacencyMatrix.addEdge(0, 1);
        adjacencyMatrix.addEdge(0, 3);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(1, 4);
        adjacencyMatrix.addEdge(3, 4);
        adjacencyMatrix.displayGraph();

        DFSAdjacencyMatrix dfs = new DFSAdjacencyMatrix();
        dfs.executeDFSIterative(0, adjacencyMatrix);
        boolean[] visitedVertices = new boolean[adjacencyMatrix.getVertexCount()];
        dfs.executeDFSRecursive(0, adjacencyMatrix, visitedVertices);
        System.out.println();
    }
}
