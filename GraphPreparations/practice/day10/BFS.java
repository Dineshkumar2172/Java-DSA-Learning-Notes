package GraphPreparations.practice.day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    // help in calculating shortest path from source to destination on undirected graphs
    // handles cycles by making use of visited array to track all the visited vertices
    public void executeBFS(int src, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(current + ", "); // print the order as we traverse
            for (int neighbor: adjList.get(current)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        System.out.println();
    }


    public void executeBFS(int src, int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
    
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(current + ", "); // print the order as we traverse
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[current][i] != 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    
        System.out.println();
    }
    

    public static void main(String[] args) {
        // build the input adjacency matrix / list
		// create a object for the BFS and access executeBFS func by keeping
		// adjacency matrix / list as an input.
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

        BFS bfs = new BFS();
        bfs.executeBFS(0, adjList);

        // adjacency matrix implementation
        int[][] adjMatrix = new int[v][v];
        for (int[] edge: edges) {
            adjMatrix[edge[0]][edge[1]] = 1;
        }
        bfs.executeBFS(0, adjMatrix);
    }
}
