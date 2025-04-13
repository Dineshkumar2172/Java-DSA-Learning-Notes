package GraphPreparations.practice.day11;

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
        boolean[] visited = new boolean[adjacencyList.getNumberOfVertices()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(current)) {
                if (!visited[neighbor[0]]) {
                    queue.add(neighbor[0]);
                    visited[neighbor[0]] = true;
                }
            }
        }
        System.out.println();
    }

    public void executeBFSAdjacencyMatrix(int startVertex, AdjacencyMatrix adjacencyMatrix) {
        boolean[] visited = new boolean[adjacencyMatrix.getVertexCount()];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
                if (adjacencyMatrix.getAdjacencyMatrix()[current][i] != 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
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
