package GraphPreparations.practice.day11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {

    public void dfs(Integer vertex, boolean[] visitedVertices, Stack<Integer> stack, AdjacencyList adjacencyList) {
        if (visitedVertices[vertex]) return;

        visitedVertices[vertex] = true;
        for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(vertex)) {
            if (!visitedVertices[neighbor[0]]) {
                dfs(neighbor[0], visitedVertices, stack, adjacencyList);
            }
        }

        stack.push(vertex);
    }

    public void executeTopologicalSortDFS(AdjacencyList adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.getNumberOfVertices()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adjacencyList);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
    }

    public void executeTopologicalSortBFS(AdjacencyList adjacencyList) {
        System.out.println();
        int n = adjacencyList.getNumberOfVertices();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer[] edge: adjacencyList.getAdjacencyList().get(i)) {
                inDegree[edge[0]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (Integer[] edge: adjacencyList.getAdjacencyList().get(current)) {
                if (--inDegree[edge[0]] == 0) {
                    queue.add(edge[0]);
                }
            }
        }
    }


    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, false, false);
        adjacencyList.addEdge(5, 2);
        adjacencyList.addEdge(5, 0);
        adjacencyList.addEdge(4, 0);
        adjacencyList.addEdge(4, 1);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(3, 1);

        TopologicalSorting topoSort = new TopologicalSorting();
        topoSort.executeTopologicalSortDFS(adjacencyList);
        topoSort.executeTopologicalSortBFS(adjacencyList);
    }
}
