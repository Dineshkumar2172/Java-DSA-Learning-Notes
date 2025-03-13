package GraphPreparations.practice.day2;

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
        boolean[] visitedVertex = new boolean[adjacencyList.getNumberOfVertices()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visitedVertex[startVertex] = true;

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            System.out.print(currentVertex + ", ");
            for  (Integer[] neighbor: adjacencyList.getAdjacencyList().get(currentVertex)) {
                if (!visitedVertex[neighbor[0]]) {
                    queue.offer(neighbor[0]);
                    visitedVertex[neighbor[0]] = true;
                }
            }
        }

        System.out.println();
    }

    public void executeBFSAdjacencyMatrix(int startVertex, AdjacencyMatrix adjacencyMatrix) {
        boolean[] visitedVertex = new boolean[adjacencyMatrix.getVertexCount()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visitedVertex[startVertex] = true;

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            System.out.print(currentVertex + ", ");
            for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
                if (adjacencyMatrix.getAdjacencyMatrix()[currentVertex][i] > 0 &&  !visitedVertex[i]) {
                    queue.offer(i);
                    visitedVertex[i] = true;
                }
            }
        }

        System.out.println();

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
