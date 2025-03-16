package GraphPreparations.practice.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public void executeDFS(int v, int startVertex, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) continue;
            
            System.out.print(current + ", ");
            visited[current] = true;
            for (int neigh: adjList.get(current)) {
                if (!visited[neigh]) {
                    stack.push(neigh);
                }
            }
        }
        System.out.println();
    }
    
    public void executeDFSRecursive(int v, int startVertex, boolean[] visited, List<List<Integer>> adjList) {
        if (visited[startVertex]) return;

        System.out.print(startVertex + ", ");
        visited[startVertex] = true;
        for (int neigh: adjList.get(startVertex)) {
            if (!visited[neigh]) {
                executeDFSRecursive(v, neigh, visited, adjList);
            }
        }
    }

    public void executeDFS(int v, int startVertex, int[][] adjMatrix) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) continue;
            System.out.print(current + ", ");
            visited[current] = true;

            for (int i = 0; i < v; i++) {
                if (!visited[i] && adjMatrix[current][i] == 1) {
                    stack.push(i);
                }
            }
        }

        System.out.println();
    }

    public void executeDFSRecursive(int v, int startVertex, boolean[] visited, int[][] adjMatrix) {
        if (visited[startVertex]) return;
        
        System.out.print(startVertex + ", ");
        visited[startVertex] = true;
        for (int i = 0; i < v; i++) {
            if (!visited[i] && adjMatrix[startVertex][i] == 1) {
                executeDFSRecursive(v, i, visited, adjMatrix);
            }
        }
    }

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
        dfs.executeDFS(v, 0, adjList);

        // adjacency list - dfs recursive
        boolean[] visited = new boolean[v];
        dfs.executeDFSRecursive(v, 0, visited, adjList);
        System.out.println();

        // adjacency matrix
        int[][] adjMatrix = new int[v][v];
        for (int[] edge: edges) adjMatrix[edge[0]][edge[1]] = 1;

        // adjacency matrix - dfs iterative
        dfs.executeDFS(v, 0, adjMatrix);

        // adjacency matrix - dfs recursive
        boolean[] visitedVertex = new boolean[v];
        dfs.executeDFSRecursive(v, 0, visitedVertex, adjMatrix);
    }
}
