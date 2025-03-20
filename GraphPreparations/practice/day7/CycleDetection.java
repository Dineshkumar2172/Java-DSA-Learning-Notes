package GraphPreparations.practice.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetection {

    public boolean executeDFSCycleDetection(int vertex, int parent, boolean[] visited, List<List<Integer>> adjList) {
        visited[vertex] = true;
        for (Integer neigh: adjList.get(vertex)) {
            if (!visited[neigh]) {
                if(executeDFSCycleDetection(neigh, vertex, visited, adjList)) {
                    return true; // cycle detected
                }
            } else if (vertex != parent) {
                return true; // cycle detected
            }
        }

        return false;
    }

    public boolean hasCycle(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                if (executeDFSCycleDetection(i, -1, visited, adjList)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean executeBFSCycleDetection(List<List<Integer>> adjList) {
        int vertex = adjList.size();
        Integer[] inDegree = new Integer[vertex];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i < vertex; i++) {
            for (int neigh: adjList.get(i)) {
                inDegree[neigh]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertex; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int neigh: adjList.get(current)) {
                if (--inDegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }


        // cycle exists if some nodes remain unprocessed: count < vertex.
        // cycle doesn't exist if all nodes are processed: count == vertex.
        return count < vertex;
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
