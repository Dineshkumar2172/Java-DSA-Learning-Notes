package GraphPreparations.practice.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    // DFS implementation - using recursion and explicit stack
    public void executeTopologicalSort(int srcVertex, boolean[] visitedVertices, List<List<Integer>> adjList, Stack<Integer> stack) {
        if (visitedVertices[srcVertex]) return;

        visitedVertices[srcVertex] = true;
        for (Integer neigh: adjList.get(srcVertex)) {
            if (!visitedVertices[neigh]) {
                executeTopologicalSort(neigh, visitedVertices, adjList, stack);
            }
        }

        stack.push(srcVertex);
    }

    // BFS implementation using queue and inDegree - Khans
    public void executeTopologicalSort(List<List<Integer>> adjList) {
        Integer[] inDegree = new Integer[adjList.size()];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i < adjList.size(); i++) {
            for (int neigh: adjList.get(i)) {
                inDegree[neigh]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adjList.size(); i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            topoOrder.add(current);
            for (int neigh: adjList.get(current)) {
                if (--inDegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }

        System.out.println("Topological order of the given adjacency list : ");
        for (int vertex: topoOrder) {
            System.out.print(vertex + ", ");
        }
        System.out.println();

    };

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
