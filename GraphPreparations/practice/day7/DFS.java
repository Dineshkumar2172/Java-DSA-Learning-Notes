package GraphPreparations.practice.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    public void executeDFS (int start, List<List<Integer>>  adjList) {
        int n = adjList.size();
        boolean[] visitedVertex = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + ", ");
            visitedVertex[current] = true;

            for (Integer neighbor: adjList.get(current)) {
                if (!visitedVertex[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void executeDFSRecursive (int startVertex, boolean[] visited, List<List<Integer>> adjList) {
        if (visited[startVertex]) return;

        System.out.print(startVertex + ", ");
        visited[startVertex] = true;
        for (Integer neigh: adjList.get(startVertex)) {
            if (!visited[neigh]) {
                executeDFSRecursive(neigh, visited, adjList);
            }
        }
    }

    public void executeDFS (int start, int[][] adjList) {}

    public void executeDFSRecursive (int startVertex, boolean[] visited, int[][] adjList) {}

    public static void main(String[] args) {
        int v = 6;
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 5}, {4, 5}
        };

        // adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        
        DFS dfs = new DFS();

        // adjacency list - dfs iterative
        dfs.executeDFS(0, adjList);

        // adjacency list - dfs recursive
        boolean[] visited = new boolean[v];
        dfs.executeDFSRecursive(0, visited, adjList);
        System.out.println();

        // adjacency matrix
        int[][] adjMatrix = new int[v][v];
        for (int[] edge: edges) adjMatrix[edge[0]][edge[1]] = 1;

        // adjacency matrix - dfs iterative
        dfs.executeDFS(0, adjMatrix);

        // adjacency matrix - dfs recursive
        boolean[] visitedVertex = new boolean[v];
        dfs.executeDFSRecursive(0, visitedVertex, adjMatrix);
    }
}
