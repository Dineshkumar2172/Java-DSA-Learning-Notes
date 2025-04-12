package GraphPreparations.practice.day10;

import java.util.ArrayList;
import java.util.List;

public class DFSRecursive {

    // DFS recursive approach - we make use of recursion stack frame to track
    public void executeDFS(int src, List<List<Integer>> adjList, boolean[] visited) {
        if (visited[src]) return;
        
        visited[src] = true;
        System.out.print(src + ", ");
        for (int neighbor: adjList.get(src)) {
            if (!visited[neighbor]) {
                executeDFS(neighbor, adjList, visited);
            } 
        }
    }

    public void executeDFS(int src, int[][] adjMatrix, boolean[] visited) {
        if (visited[src]) return;
        
        visited[src] = true;
        System.out.print(src + ", ");
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[src][i] != 0 && !visited[i]) {
                executeDFS(i, adjMatrix, visited);
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
        
        DFSIterative dfs = new DFSIterative();

        // // adjacency list - dfs iterative
        dfs.executeDFS(0, adjList);
        System.out.println();

        // adjacency matrix
        int[][] adjMatrix = new int[v][v];
        for (int[] edge: edges) adjMatrix[edge[0]][edge[1]] = 1;

        dfs.executeDFS(0, adjMatrix);
    }
}
