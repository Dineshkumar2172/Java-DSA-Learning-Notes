package GraphPreparations.practice.day14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    // reference 
    // 1. It's a greedy algorithm used for MST - minimum spanning tree.
    // 2. It works by selecting next smallest vertex based on weight.
    // 3. We use parent array, visited vertices array and minEdgeWeight arrray.
    // 4. It works on undirected and weighted graphs.
    public void executePrims(int startVertex, AdjacencyList adjacencyList) {
       
    }

    public void executePrimsMatrix(Integer startVertex, AdjacencyMatrix adjacencyMatrix) {
        
    }

    public static void main(String[] args) {
        AdjacencyList weightedAdjacencyList = new AdjacencyList(6, false, true);

        weightedAdjacencyList.addEdge(0, 1, 3);
        weightedAdjacencyList.addEdge(0, 2, 3);
        weightedAdjacencyList.addEdge(1, 2, 3);
        weightedAdjacencyList.addEdge(1, 3, 3);
        weightedAdjacencyList.addEdge(2, 3, 3);
        weightedAdjacencyList.addEdge(2, 4, 3);
        weightedAdjacencyList.addEdge(3, 4, 3);
        weightedAdjacencyList.addEdge(4, 5, 3); // Ensure all nodes are connected for MST

        PrimsAlgorithm prims = new PrimsAlgorithm();
        prims.executePrims(0, weightedAdjacencyList);

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(6, false, true);
        adjacencyMatrix.addEdge(0, 1, 3);
        adjacencyMatrix.addEdge(0, 2, 3);
        adjacencyMatrix.addEdge(1, 2, 3);
        adjacencyMatrix.addEdge(1, 3, 3);
        adjacencyMatrix.addEdge(2, 3, 3);
        adjacencyMatrix.addEdge(2, 4, 3);
        adjacencyMatrix.addEdge(3, 4, 3);
        adjacencyMatrix.addEdge(4, 5, 3);

        prims.executePrimsMatrix(0, adjacencyMatrix);
    }
}
