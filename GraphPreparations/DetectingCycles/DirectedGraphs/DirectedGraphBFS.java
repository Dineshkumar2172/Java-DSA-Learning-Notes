package GraphPreparations.DetectingCycles.DirectedGraphs;

import java.util.LinkedList;
import java.util.Queue;

import GraphPreparations.GraphRepresentations.AdjacencyList;

public class DirectedGraphBFS {

    // reference: Topological sorting (BFS) - https://youtu.be/73sneFXuTEg

    // notes:
    //      1. Compute in-degree for each node (number of incoming edges).
    //      2. Add all nodes with in-degree = 0 to the queue.
    //      3. Process nodes in the queue:
    //          i) Remove a node and reduce the in-degree of its neighbors.
    //         ii) If any neighbor's in-degree becomes 0, add it to the queue.
    //      4. If we process all nodes, there's no cycle. Otherwise, a cycle exists.

    public boolean hasCycle(AdjacencyList adjacencyList) {
        int[] inDegrees = new int[adjacencyList.getNumberOfVertices()];

        // Compute in-degree of each vertex
        for(int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for(Integer neighbor: adjacencyList.getAdjList()[i]){
                inDegrees[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // Add all nodes with in-degree 0 to the queue
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0; // Track number of processed nodes

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            count++;

            for(Integer neighbor: adjacencyList.getAdjList()[current]) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return count != adjacencyList.getNumberOfVertices();
    }

    public static void main(String[] args) {
        DirectedGraphBFS directedGraphBFS = new DirectedGraphBFS();
        AdjacencyList adjacencyList = new AdjacencyList(7, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(4, 6);
        adjacencyList.addEdge(5, 6);        
        System.out.println("Cycle detection result : " + directedGraphBFS.hasCycle(adjacencyList));


        AdjacencyList adjacencyList2 = new AdjacencyList(4, false);
        adjacencyList2.addEdge(0, 1);
        adjacencyList2.addEdge(1, 2);
        adjacencyList2.addEdge(2, 3);
        adjacencyList2.addEdge(3, 1); // This edge is a cycle
        System.out.println("Cycle detection result : " + directedGraphBFS.hasCycle(adjacencyList2));
    }
}
