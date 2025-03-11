package GraphPreparations.week3.TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import GraphPreparations.week1.GraphRepresentations.AdjacencyList;

public class TopologicalSortingBFSKhans {
    
    // Topological Sorting using Kahn’s Algorithm (BFS-Based):
    // 1. Compute in-degree of all nodes (number of incoming edges).
    // 2. Push nodes with in-degree 0 into a queue (these are independent tasks).
    // 3. Process nodes in the queue:
    //      i) Remove a node, add it to the result.
    //     ii) Reduce in-degree of its neighbors.
    //    iii) If any neighbor’s in-degree becomes 0, push it to the queue.
    // 4. If all nodes are processed, we have a valid topological order.

    public void topologicalSort(AdjacencyList adjacencyList) {
        int[] inDegree = new int[adjacencyList.getNumberOfVertices()];

        // Step1: computing in-degree of all nodes - number of incoming nodes for a vertex
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for (Integer neighbor: adjacencyList.getAdjList()[i]) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // Step 2: push nodes with in-degree 0 into a queue (these are independent tasks).
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            topoOrder.add(currentVertex);

            for (Integer neighbor: adjacencyList.getAdjList()[currentVertex]) {
                if (--inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Topological Sort (BFS): " + topoOrder);
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, false);
        adjacencyList.addEdge(5, 2);
        adjacencyList.addEdge(5, 0);
        adjacencyList.addEdge(4, 0);
        adjacencyList.addEdge(4, 1);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(3, 1);

        TopologicalSortingBFSKhans topologicalSortingBFSKhans = new TopologicalSortingBFSKhans();
        topologicalSortingBFSKhans.topologicalSort(adjacencyList);
    }
}
