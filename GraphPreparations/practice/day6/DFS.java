package GraphPreparations.practice.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    public void executeDFS(int startVertex, List<List<Integer>> adjList) {
        boolean[] visitedVertex = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            if (visitedVertex[current]) continue;
            
            System.out.print(current + ", ");
            visitedVertex[current] = true;
            for (Integer neigh: adjList.get(current)) {
                if (!visitedVertex[neigh]) {
                    stack.push(neigh);
                }
            }
        }

        System.out.println();
    }

    public void executeDFSRecursive(int startVertex, boolean[] visitedVertex, List<List<Integer>> adjList) {
        if (visitedVertex[startVertex]) return;

        System.out.print(startVertex + ", ");
        visitedVertex[startVertex] = true;
        for (Integer neigh: adjList.get(startVertex)) {
            if (!visitedVertex[neigh]) {
                executeDFSRecursive(neigh, visitedVertex, adjList);
            }
        }
    }

    public void executeDFS(int startVertex, int[][] adjMatrix) {
        boolean[] visitedVertex = new boolean[adjMatrix.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (visitedVertex[current]) continue;

            System.out.print(current + ", ");
            visitedVertex[current] = true;
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[current][i] == 1 && !visitedVertex[i]) {
                    stack.push(i);
                }
            }
        }

        System.out.println();
    }

    public void executeDFSRecursive(int startVertex, boolean[] visitedVertex, int[][] adjMatrix) {
        if (visitedVertex[startVertex]) return;

        System.out.print(startVertex + ", ");
        visitedVertex[startVertex] = true;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (!visitedVertex[i] && adjMatrix[startVertex][i] == 1) {
                executeDFSRecursive(i, visitedVertex, adjMatrix);
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
