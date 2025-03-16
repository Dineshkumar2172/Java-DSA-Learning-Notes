package GraphPreparations.practice.day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetection {
    // undireced - use DFS
    // directed - use BFS
    public boolean detectCycleDFS(boolean[] visited, int vertex, int parent, List<List<Integer>> adjList) {
        visited[vertex] = true;

        for (int neigh: adjList.get(vertex)) {
            if (!visited[neigh]) {
               if ( detectCycleDFS(visited, neigh, vertex, adjList)) {
                    return true;
               }
            } else if (neigh != parent) { // back edge found (cycle detected)
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                if (detectCycleDFS(visited, i, -1, adjList)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean executeBFSCycleDetection(List<List<Integer>> adjList) {
        int[] inDegree = new int[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            for (int neighbor: adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adjList.size(); i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        Integer count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int neigh: adjList.get(current)) {
                if (--inDegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }

        return count != adjList.size();
    }


    public static void main(String[] args) {
        int vertices = 5;
        int[][] edges = {
            {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}  // This forms a cycle
        };

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);  // Because it's an undirected graph
        }

        CycleDetection cycleDetection = new CycleDetection();
        System.out.println(cycleDetection.hasCycle(adjList));
        System.out.println(cycleDetection.executeBFSCycleDetection(adjList));
    }
}
