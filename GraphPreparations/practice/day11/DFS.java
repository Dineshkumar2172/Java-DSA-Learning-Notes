package GraphPreparations.practice.day11;

import java.util.Stack;

public class DFS {
    // 1. It's a graph traversal algorithm - (neither greedy nor dynamic)
    // 2. It uses stack to keep track of vertices it travese through.
    // 3. It traverse the graph by visiting single vertex in depth at a time and then come back by visting the unvisited vertices.
    // 4. DFS works irrespective of whether if a graph is directional, undirectional, unweighted.
    public void performDFSIterative(Integer start, AdjacencyList adjacencyList) {
        int vertex = adjacencyList.getNumberOfVertices();
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (visited[current]) continue;
            System.out.print(current + ", ");
            visited[current] = true;
            for (Integer[] neigh: adjacencyList.getAdjacencyList().get(current)) {
                if (!visited[neigh[0]]) {
                    stack.push(neigh[0]);
                }
            }
        }

        System.out.println();
    }

    public void executeDFSRecursive(Integer vertex, AdjacencyList adjacencyList, boolean[] visitedVertices) {
        if (visitedVertices[vertex]) return;

        System.out.print(vertex + ". ");
        visitedVertices[vertex] = true;
        for (Integer[] neigh: adjacencyList.getAdjacencyList().get(vertex)) {
            if (!visitedVertices[neigh[0]]) {
                executeDFSRecursive(neigh[0], adjacencyList, visitedVertices);
            }
        }
    }
    
    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(7, false, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(1, 3);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(2, 6);
        adjacencyList.displayGraph();
        
        DFS dfs = new DFS();
        dfs.performDFSIterative(0, adjacencyList);

        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        dfs.executeDFSRecursive(0, adjacencyList, visitedVertices);
    }
}
