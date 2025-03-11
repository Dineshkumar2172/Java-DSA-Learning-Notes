package GraphPreparations.week3.TopologicalSorting;

import java.util.Stack;

import GraphPreparations.week1.GraphRepresentations.AdjacencyList;

public class TopologicalSortingDFS {

    // Topological Sorting using DFS:
    // 1. Use a boolean visited array to track visited nodes.
    // 2. Perform DFS traversal, pushing nodes onto a stack after visiting all their neighbors.
    // 3. Pop the stack to get the topological order.


    public void dfs(Integer vertex, boolean[] visitedVertices, Stack<Integer> stack, AdjacencyList adjacencyList) {
        visitedVertices[vertex] = true;
        for (Integer neighbor: adjacencyList.getAdjList()[vertex]) {
            if (!visitedVertices[neighbor]) {
                dfs(neighbor, visitedVertices, stack, adjacencyList);
            }
        }

        stack.push(vertex); // Add to stack after visiting all neighbors
    }

    public void ExecuteTopologicalSort(AdjacencyList adjacencyList) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (!visitedVertices[i]) { // to handle all connected components
                dfs(i, visitedVertices, stack, adjacencyList);
            }
        }

        System.out.println("Topological sort (DFS): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, false);
        adjacencyList.addEdge(5, 2);
        adjacencyList.addEdge(5, 0);
        adjacencyList.addEdge(4, 0);
        adjacencyList.addEdge(4, 1);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(3, 1);
        
        TopologicalSortingDFS topologicalSortingDFS = new TopologicalSortingDFS();
        topologicalSortingDFS.ExecuteTopologicalSort(adjacencyList);
    }
}
