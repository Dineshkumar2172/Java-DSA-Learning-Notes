package GraphPreparations.practice.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public void executeBFS (int startVertex, List<List<Integer>> adjList) {
        boolean[] visitedVertex = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        visitedVertex[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            
            for (int neigh: adjList.get(current)) {
                if (!visitedVertex[neigh]) {
                    queue.offer(neigh);
                    visitedVertex[neigh] = true;
                }
            }
        }

        System.out.println();
    }

    public void executeBFS(int startVertex, int[][] adjMatrix) {
        boolean[] visitedVertex = new boolean[adjMatrix.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visitedVertex[startVertex] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[current][i] == 1 && !visitedVertex[i]) {
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
        bfs.executeBFS( 0, adjList);

        // adjacency matrix implementation
        int[][] adjMatrix = new int[v][v];
        for (int[] edge: edges) {
            adjMatrix[edge[0]][edge[1]] = 1;
        }
        bfs.executeBFS(0, adjMatrix);
    }
}
