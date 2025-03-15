package GraphPreparations.practice.day4;

import java.util.Stack;

import GraphPreparations.practice.day1.AdjacencyList;

public class DFS {
    // it start be exploring deepest part of each node and then start exploring neighbors
    // irt works based in stack during iterative approach and recursive stack during recursion.

    public void executeDFS(int vertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertex = new boolean[adjacencyList.getNumberOfVertices()];
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while(!stack.isEmpty()) {
            Integer current = stack.pop();
            if (visitedVertex[current]) continue;

            visitedVertex[current] = true;
            System.out.print(current + ", ");
            for (Integer[] neighbors: adjacencyList.getAdjacencyList().get(current)) {
                if (!visitedVertex[neighbors[0]]) {
                    stack.push(neighbors[0]);
                }
            }
        }

        System.out.println();
    }

    public void executeDFS(int vertex, AdjacencyList adjacencyList, boolean[] visitedVertices) {
        if (visitedVertices[vertex]) return;

        System.out.print(vertex + ", ");
        visitedVertices[vertex] = true;
        for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(vertex)) {
            if (!visitedVertices[neighbor[0]]) {
                executeDFS(neighbor[0], adjacencyList, visitedVertices);
            }
        }
    }

    // Usiong adjacency matrix

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(7, false, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(1, 3);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(2, 6);

        DFS dfs = new DFS();
        dfs.executeDFS(0, adjacencyList);
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        dfs.executeDFS(0, adjacencyList, visitedVertices);
    }
}
