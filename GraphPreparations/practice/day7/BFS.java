package GraphPreparations.practice.day7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public void executeBFS(int start, List<List<Integer>> adjList) {
        int n = adjList.size();
        boolean[] visitedNodes = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitedNodes[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (Integer neighbor: adjList.get(current)) {
                if (!visitedNodes[neighbor]) {
                    queue.offer(neighbor);
                    visitedNodes[neighbor] = true;
                }
            }
        }

        System.out.println();
    }

    public void executeBFS(int start, int[][] adjMatrix) {
        int n = adjMatrix.length;
        boolean[] visitedVertex = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visitedVertex[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int i = 0; i < n; i++) {
                if (!visitedVertex[i] && adjMatrix[current][i] == 1) {
                    queue.offer(i);
                    visitedVertex[i] = true;
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
