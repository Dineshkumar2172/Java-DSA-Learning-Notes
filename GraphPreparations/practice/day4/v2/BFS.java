package GraphPreparations.practice.day4.v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public void executeBFS(int startVertex, int vertex, List<List<Integer>> adjacencyList) {
        boolean[] visitedVertices = new boolean[vertex];
        // bfs uses queue to keep track of neighbor vertices
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visitedVertices[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + ", ");
            // explore its neighbors - which are not visited yet
            for (Integer neighbor: adjacencyList.get(currentVertex)) {
                if (!visitedVertices[neighbor]) {
                    queue.offer(neighbor);
                    visitedVertices[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {        
        int v = 6;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {1, 4},
            {2, 4},
            {3, 5},
            {4, 5}
        };
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        // build a adjacency list using above array
        for (int[] edge: edges) {
            // build the adjacency matrix
            adjList.get(edge[0]).add(edge[1]);
        }

        BFS bfs = new BFS();
        bfs.executeBFS(0, 6, adjList);
    }
}
