package GraphPreparations.practice.day1;

import java.util.LinkedList;
import java.util.Queue;

public class BFSIterative {
    // representation:
    //      1. Get a start vertex from user to decided where to start traversing from.
    //      2. BFS uses queue to traverse through neighbors first and the traverse layer by layer.
    //      3. BFS uses visitedVertex array to keep track of arrays visited.
    //      4. it works with directed, undirected and unweighted graphs on both adjacency list and matrix.
    //      5. For BFS, it doesn't matter if a graph is directed or undirected as it supports both as it keeps track of visitedVertices, so it works likewise in both graphs.
    //              Undirected Graphs:
    //                  If u is connected to v, then v is also connected to u.
    //                  The BFS traversal will explore u → v and v → u, but the visitedVertices array ensures that each node is visited only once.
        
    //              Directed Graphs:
    //                  If u → v exists, it does not mean v → u exists.
    //                  BFS will only traverse edges in the given direction, making it suitable for directed graphs.

    public void executeBFS(int startVertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertex = new boolean[adjacencyList.getNumberOfVertices()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visitedVertex[startVertex] = true;

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            System.out.print(currentVertex + ", ");

            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(currentVertex)) {
                if (!visitedVertex[neighbor[0]]) {
                    queue.add(neighbor[0]);
                    visitedVertex[neighbor[0]] = true;
                }
            }
        }

    }


    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(5, true, false);
        // Add edges
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(3, 4);
        adjacencyList.displayGraph();
        BFSIterative bfsIterative = new BFSIterative();
        bfsIterative.executeBFS(0, adjacencyList);
    }
}
