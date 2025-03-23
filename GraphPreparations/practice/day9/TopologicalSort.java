package GraphPreparations.practice.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    public void executeTopologicalSort(int vertex, boolean[] visited, List<List<Integer>> adjList, Stack<Integer> stack) {
        if (visited[vertex]) return;

        visited[vertex] = true;
        for (Integer neighbor: adjList.get(vertex)) {
            if (!visited[neighbor]) {
                executeTopologicalSort(neighbor, visited, adjList, stack);
            }
        }

        stack.push(vertex);
    }

    // using khan's indegree algorithm
    public void executeTopologicalSort(List<List<Integer>> adjList) {
        int n = adjList.size();
        Integer[] inDegree = new Integer[n];
        Arrays.fill(inDegree, 0);
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

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int neigh: adjList.get(current)) {
                if (--inDegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        int[][] edges = {
            {5, 0},
            {5, 2},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adjList.add(new ArrayList<>());
        for (int[] edge: edges) adjList.get(edge[0]).add(edge[1]);

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        TopologicalSort topologicalSort = new TopologicalSort();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) topologicalSort.executeTopologicalSort(i, visited, adjList, stack);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + ", ");
        }

        System.out.println();

        topologicalSort.executeTopologicalSort(adjList);
    }
}
