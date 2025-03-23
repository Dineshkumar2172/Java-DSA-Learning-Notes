package GraphPreparations.practice.day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    // adjacency list
    public void executeBFS(int start, List<List<Integer>> adjList) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int neigh: adjList.get(current)) {
                if (!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                }
            }
        }

        System.out.println();

    }

    // adjacency matrix
    public void executeBFS(int start, int[][] adjMatrix) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int i = 0; i < n; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
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
