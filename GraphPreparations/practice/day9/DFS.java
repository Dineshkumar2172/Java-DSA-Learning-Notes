package GraphPreparations.practice.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public void executeDFS(int start, List<List<Integer>> adjList) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

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

    public void executeDFSRecursive(int vertex, boolean[] visited, List<List<Integer>> adjList) {
        if (visited[vertex]) return;

        System.out.print(vertex + ", ");
        visited[vertex] = true;
        for (int neigh: adjList.get(vertex)) {
            if (!visited[neigh]) {
                executeDFSRecursive(neigh, visited, adjList);
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
            dfs.executeDFS(0, adjList);

            // adjacency list - dfs recursive
            boolean[] visited = new boolean[v];
            dfs.executeDFSRecursive(0, visited, adjList);
            System.out.println();
    }
}
