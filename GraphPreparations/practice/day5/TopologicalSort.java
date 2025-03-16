package GraphPreparations.practice.day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    // usgin DFS recusive
    public void executeTopologicalSort(boolean[] visited, int srcVertex, List<List<Integer>> adjList, Stack<Integer> stack) {
        if (visited[srcVertex]) return;

        visited[srcVertex] = true;
        for (int neigh: adjList.get(srcVertex)) {
            if (!visited[neigh]) {
                executeTopologicalSort(visited, neigh, adjList, stack);
            }
        }
        
        stack.push(srcVertex);
    }

    public void executeTopologicalSort(List<List<Integer>> adjList) {
        int[] inDegree = new int[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            for (int vertex: adjList.get(i)) {
                inDegree[vertex]++;
            }
        }
        

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adjList.size(); i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            topoOrder.add(current);
            for (int neigh: adjList.get(current)) {
                if ( --inDegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }

        System.out.println("Topo order BFS : " + topoOrder);
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
            if (!visited[i]) topologicalSort.executeTopologicalSort(visited, i, adjList, stack);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + ", ");
        }

        System.out.println();

        topologicalSort.executeTopologicalSort(adjList);
    }
}
