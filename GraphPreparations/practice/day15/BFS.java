package GraphPreparations.practice.day15;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // references:
    //  1. Initialise visitedVertex array to keep track of visited vertices.
    //  2. Get startVertex from the client to know where to start the traversal from.
    //  3. Initialise a queue with type integer to keep track of vertices for traversing in layer by layer manner.
    //  3. BFS works irrespective of if a graph is directional, undirectional, unweighted.
    //  4. It's a neither greedy nor dynamic algorithms - its a graph traversal that helps you traverse through graph.                   

    public void executeBFSAdjacencyList(int startVertex, AdjacencyList adjacencyList) {
       
    }

    public void executeBFSAdjacencyMatrix(int startVertex, AdjacencyMatrix adjacencyMatrix) {

    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(5, false, false);
        // Add edges
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(3, 4);

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, false, false);
        // Add edges
        adjacencyMatrix.addEdge(0, 1);
        adjacencyMatrix.addEdge(0, 3);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(1, 4);
        adjacencyMatrix.addEdge(3, 4);

        BFS bfs = new BFS();
        bfs.executeBFSAdjacencyList(0, adjacencyList);
        bfs.executeBFSAdjacencyMatrix(0, adjacencyMatrix);
    }
}
