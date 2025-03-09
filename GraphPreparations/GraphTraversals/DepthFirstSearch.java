package GraphPreparations.GraphTraversals;

import java.util.LinkedList;
import java.util.Stack;

import GraphPreparations.GraphRepresentations.AdjacencyList;

public class DepthFirstSearch {
    // implementing both recursive and iterative versions for DFS
    // Why?
    //      1. Recursive DFS is easier to implement but can cause stack overflow on deep graphs.
    //      2. Iterative DFS avoids recursion depth limits and is useful in large graphs.
    
    public void dfsIterative(Integer vertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        LinkedList<Integer>[] adjList = adjacencyList.getAdjList();
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if (!visitedVertices[current]) {
                System.out.print(current + ", ");
                visitedVertices[current] = true;
                for (Integer edge : adjList[current]) {
                    if (!visitedVertices[edge]) {
                        stack.push(edge);
                    }
                }
            }
        }

        System.out.println();
    }

    // for recursive, this visited array has to be maintained globally
    private boolean[] visitedVertices;

    public void dfsRecursiveInitialise(AdjacencyList adjacencyList) {
        this.visitedVertices = new boolean[adjacencyList.getAdjList().length];
    }

    public void dfsRecursive(Integer vertex, AdjacencyList adjacencyList) {
        if (visitedVertices[vertex]) return;

        System.out.print(vertex + ", ");
        visitedVertices[vertex] = true;

        for (Integer neighbor: adjacencyList.getAdjList()[vertex]) {
            dfsRecursive(neighbor, adjacencyList);
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(10, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(3, 4);
        adjacencyList.addEdge(3, 5);
        adjacencyList.addEdge(5, 6);
        adjacencyList.addEdge(3, 7);
        adjacencyList.addEdge(7, 8);
        adjacencyList.addEdge(8, 9);
        adjacencyList.addEdge(9, 5);
        adjacencyList.addEdge(5, 8);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfsIterative(0, adjacencyList);

        depthFirstSearch.dfsRecursiveInitialise(adjacencyList);
        depthFirstSearch.dfsRecursive(0, adjacencyList);
        System.out.println();
    }

}
