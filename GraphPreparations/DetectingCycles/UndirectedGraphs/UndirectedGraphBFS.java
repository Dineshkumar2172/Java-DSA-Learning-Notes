package GraphPreparations.DetectingCycles.UndirectedGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import GraphPreparations.GraphRepresentations.AdjacencyList;

public class UndirectedGraphBFS {
    // reference - https://youtu.be/BPlrALf1LDU
    public boolean hasCycle(Integer vertex, AdjacencyList adjacencyList) {
        
        Integer[] visitedVertices = new Integer[adjacencyList.getNumberOfVertices()];
        Arrays.fill(visitedVertices, 0); // initialising array with 0's

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{vertex, -1}); // {node, parent}
        visitedVertices[vertex] = 1;
        
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int currentNode = pair[0];
            int parentNode = pair[1];

            for (int neighbor : adjacencyList.getAdjList()[currentNode]) {
                if (visitedVertices[neighbor] == 0) {
                    visitedVertices[neighbor] = 1;
                    queue.add(new int[]{neighbor, currentNode});
                } else if (neighbor != parentNode) { // If visited and not parent → cycle found
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(7, true);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(4, 6);
        adjacencyList.addEdge(5, 6);

        UndirectedGraphBFS undirectedGraphBFS = new UndirectedGraphBFS();
        System.out.println(undirectedGraphBFS.hasCycle(0, adjacencyList));
    }
}
