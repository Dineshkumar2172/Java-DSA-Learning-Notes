package GraphPreparations.practice.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetection {

    // works well for finding cycle in undirected graph
    public boolean dfsCycle(boolean[] visitedVertices, int vertex, int parent, List<List<Integer>> adjList) {
        visitedVertices[vertex] = true;

        for (int neigh: adjList.get(vertex)) {
            if (!visitedVertices[neigh]) {
                if(dfsCycle(visitedVertices, neigh, vertex, adjList)) return true; // deep cycle
            } else if (neigh != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean executeDFSCycleDetection(List<List<Integer>> adjList) {
        int n = adjList.size();
        boolean[] visitedVertices = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visitedVertices[i]) {
                if (dfsCycle(visitedVertices, i, -1, adjList)) {
                    return true;
                }
            }
        }
        return false;
    }

    // works well for finding cycle in directed graph
    public boolean executeBFSCycleDetection(List<List<Integer>> adjList) {
        int n = adjList.size();
        Integer[] inDegree = new Integer[n];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i < n; i++) {
            for (int edge: adjList.get(i)) inDegree[edge]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int totalEdges = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            totalEdges++;
            for (int neigh: adjList.get(current)) {
                if (--inDegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }

        // If the number of processed nodes is less than the total nodes, a cycle exists.
        return totalEdges != n;

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
        System.out.println(cycleDetection.executeDFSCycleDetection(adjList)); // undirected
        System.out.println(cycleDetection.executeBFSCycleDetection(adjList)); // directed
    }
}
