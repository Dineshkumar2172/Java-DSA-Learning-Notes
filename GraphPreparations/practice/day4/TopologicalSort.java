package GraphPreparations.practice.day4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import GraphPreparations.practice.day1.AdjacencyList;

public class TopologicalSort {

    public void executeTopoSortDFS(int vertex, boolean[] visitedVertices, AdjacencyList adjacencyList, Stack<Integer> stack) {
        if (visitedVertices[vertex]) return;

        visitedVertices[vertex] = true;
        for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(vertex)) {
            if (!visitedVertices[neighbor[0]]) {
                executeTopoSortDFS(neighbor[0], visitedVertices, adjacencyList, stack);
            }
        }

        stack.push(vertex);
    }

    public void executeTopologicalSort(AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (!visitedVertices[i]) {
                executeTopoSortDFS(i, visitedVertices, adjacencyList, stack);
            }
        }

        System.out.println("Topological sort in DFS : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
    }

    public void executeTopologicalSortBFS(AdjacencyList adjacencyList) {
        // uses indegree operation
        int[] inDegree = new int[adjacencyList.getNumberOfVertices()];
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for (Integer[] neigh: adjacencyList.getAdjacencyList().get(i)) {
                inDegree[neigh[0]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            // update vertices with indegree 0 to queue to cover independent tasks
            if (inDegree[i] == 0) queue.offer(i);
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            topoOrder.add(current);
            for (Integer[] neigh: adjacencyList.getAdjacencyList().get(current)) {
                if (--inDegree[neigh[0]] == 0) {
                    queue.add(neigh[0]);
                }
            }
        }

        System.out.println("Topological order of given graph : " + topoOrder);
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, false, false);
        adjacencyList.addEdge(5, 2);
        adjacencyList.addEdge(5, 0);
        adjacencyList.addEdge(4, 0);
        adjacencyList.addEdge(4, 1);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(3, 1);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.executeTopologicalSort(adjacencyList);
        topologicalSort.executeTopologicalSortBFS(adjacencyList);
    }
}
