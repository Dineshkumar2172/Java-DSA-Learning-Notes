package GraphPreparations.practice.day9;

import GraphPreparations.week1.GraphRepresentations.AdjacencyList;

public class CycleDetectionDirectedDFS {

    public boolean executeDFSCycleDetection(int vertex, boolean[] visited, boolean[] recursionStack, AdjacencyList adjList) {
        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (Integer neigh: adjList.getAdjList()[vertex]) {
            if (!visited[neigh]) {
                if (executeDFSCycleDetection(neigh, visited, recursionStack, adjList)) return true;
            } else if (recursionStack[neigh]) {
                return true;
            }
        }

        recursionStack[vertex] = false;
        return false;
    }

    public boolean hasCycle(AdjacencyList adjacencyList) {
        int n = adjacencyList.getNumberOfVertices();
        boolean[] visited = new boolean[n];
        boolean[] recursionStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (executeDFSCycleDetection(i, visited, recursionStack, adjacencyList)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CycleDetectionDirectedDFS directedGraphDFS = new CycleDetectionDirectedDFS();
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
