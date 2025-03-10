package GraphPreparations.DetectingCycles.UndirectedGraphs;

import java.util.Stack;

import GraphPreparations.GraphRepresentations.AdjacencyList;

public class UndirectedGraphDFS {

    public boolean hasCycle(Integer startVertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{startVertex, -1});

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            int currentNode = pair[0];
            int parentNode = pair[1];

            if (!visitedVertices[currentNode]) {
                visitedVertices[currentNode] = true;
                for (int neighbor : adjacencyList.getAdjList()[currentNode]) {
                    if (!visitedVertices[neighbor]) {
                        stack.push(new int[]{neighbor, currentNode});
                    } else if (neighbor != parentNode) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasCycleRecursive(AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (!visitedVertices[i]) { // check for every connected component
                if (dfsRecursive(i, -1, visitedVertices, adjacencyList)) {
                    return true;
                }
            }    
        }

        return false;
    }

    private boolean dfsRecursive(Integer vertex, Integer parent, boolean[] visited, AdjacencyList adjacencyList) {
        visited[vertex] = true;
        
        for (Integer neighbor : adjacencyList.getAdjList()[vertex]) {
            if (!visited[neighbor]) {
                if (dfsRecursive(neighbor, vertex, visited, adjacencyList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
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

        UndirectedGraphDFS undirectedGraphDFS = new UndirectedGraphDFS();
        System.out.println(undirectedGraphDFS.hasCycle(0, adjacencyList));
        System.out.println(undirectedGraphDFS.hasCycleRecursive(adjacencyList));
    }
}
