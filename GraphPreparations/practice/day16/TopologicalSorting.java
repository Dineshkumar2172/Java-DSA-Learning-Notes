package GraphPreparations.practice.day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {

    public void dfs(Integer vertex, boolean[] visitedVertices, Stack<Integer> stack, AdjacencyList adjacencyList) {
        
    }

    public void executeTopologicalSortDFS(AdjacencyList adjacencyList) {
       
    }

    public void executeTopologicalSortBFS(AdjacencyList adjacencyList) {
        int[] inDegree = new int[adjacencyList.getNumberOfVertices()];
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for (Integer[] connectedVertex: adjacencyList.getAdjacencyList().get(i)) {
                inDegree[connectedVertex[0]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i  = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " -> ");
            for (Integer[] connected: adjacencyList.getAdjacencyList().get(current)) {
                if (--inDegree[connected[0]] == 0) {
                    queue.add(connected[0]);
                }
            }
        }

        System.out.println();
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
        // topoSort.executeTopologicalSortDFS(adjacencyList);
        topoSort.executeTopologicalSortBFS(adjacencyList);
    }
}
