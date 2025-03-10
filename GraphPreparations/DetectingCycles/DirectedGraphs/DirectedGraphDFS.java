package GraphPreparations.DetectingCycles.DirectedGraphs;

import GraphPreparations.GraphRepresentations.AdjacencyList;

public class DirectedGraphDFS {
    // reference - https://youtu.be/9twcmtQj4DU
    // reference for Topological sorting in DFS - https://youtu.be/5lZ0iJMrUMk

    // Notes:
    //      1. Here we maintain two arrays
    //          i) To track the visited vertices.
    //         ii) Recursion stack to track back edges, which indicates a cycle.
    //      2. If a node is visited while still in the recursion stack, a cycle is detected.

    public boolean dfs(Integer vertex, boolean[] visitedVertices, boolean[] recursionStack, AdjacencyList adjacencyList) {
        visitedVertices[vertex] = true;
        recursionStack[vertex] = true; // Mark the node in the recursion stack

        for(Integer neighbor: adjacencyList.getAdjList()[vertex]) {
            if (!visitedVertices[neighbor]) {
                if (dfs(neighbor, visitedVertices, recursionStack, adjacencyList)) {
                    return true; // cycle detected in deeper recursion
                }
            } else if (recursionStack[neighbor]) {
                return true; // back edge found -> cycle detected
            }
        }

        recursionStack[vertex] = false; // remove the recursion stack before returning
        return false;
    }

    public boolean hasCycle(AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        boolean[] recursionStack = new boolean[adjacencyList.getNumberOfVertices()];

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (!visitedVertices[i]) { // check every connected components
                if (dfs(i, visitedVertices, recursionStack, adjacencyList)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DirectedGraphDFS directedGraphDFS = new DirectedGraphDFS();
        AdjacencyList adjacencyList = new AdjacencyList(7, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(4, 6);
        adjacencyList.addEdge(5, 6);        
        System.out.println("Cycle detection result : " + directedGraphDFS.hasCycle(adjacencyList));


        AdjacencyList adjacencyList2 = new AdjacencyList(4, false);
        adjacencyList2.addEdge(0, 1);
        adjacencyList2.addEdge(1, 2);
        adjacencyList2.addEdge(2, 3);
        adjacencyList2.addEdge(3, 1); // This edge is a cycle
        System.out.println("Cycle detection result : " + directedGraphDFS.hasCycle(adjacencyList2));
    }
}
