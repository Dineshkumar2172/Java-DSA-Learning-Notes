package GraphPreparations.practice.day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetection {

    public boolean executeDFSCycleDetection(int vertex, int parent, boolean[] visited, List<List<Integer>> adjList) {
        visited[vertex] = true;

        for (Integer neighbor: adjList.get(vertex)) {
            if (!visited[neighbor]) {
                if (executeDFSCycleDetection(neighbor, parent, visited, adjList)) return true;
            } else if (vertex != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle(List<List<Integer>> adjList) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (executeDFSCycleDetection(i, -1, visited, adjList))  return true;
            }
        }

        return false;
    }

    public boolean executeBFSCycleDetection(List<List<Integer>> adjList) {
        int n = adjList.size();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer in: adjList.get(i)) {
                inDegree[in]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> vertices = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            vertices.add(current);
            for (Integer neigh: adjList.get(current)) {
                if (--inDegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }

        return vertices.size() < n;
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
