package GraphPreparations.practice.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSIterative {

    public void executeDFS(int src, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        
        while(!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) continue;
            System.out.print(current + ", ");
            visited[current] = true;
            for (int neighbor: adjList.get(current)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public void executeDFS(int src, int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        
        while(!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) continue;
            System.out.print(current + ", ");
            visited[current] = true;
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[current][i] != 0 && !visited[i]) {
                    stack.push(i);
                }
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

        // adjacency list - dfs iterative
        dfs.executeDFS(0, adjList);
        System.out.println();

        // adjacency matrix
        int[][] adjMatrix = new int[v][v];
        for (int[] edge: edges) adjMatrix[edge[0]][edge[1]] = 1;

        dfs.executeDFS(0, adjMatrix);
        // System.out.println();
    }
}
