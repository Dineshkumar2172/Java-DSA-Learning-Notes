package GraphPreparations.practice.day2;

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
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (!visitedVertices[i]) {
                dfs(i, visitedVertices, stack, adjacencyList);
            }
        }

        System.out.print("Topological order in DFS : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
    }

    public void executeTopologicalSortBFS(AdjacencyList adjacencyList) {
        int[] inDegree = new int[adjacencyList.getNumberOfVertices()];

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(i)) {
                inDegree[neighbor[0]]++; // updatinng in-order count
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // to handle independent tasks - vertices who don't have any inDegrees
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            topoOrder.add(current);
            for (Integer neighbor[]: adjacencyList.getAdjacencyList().get(current)) {
                if (--inDegree[neighbor[0]] == 0) {
                    queue.add(neighbor[0]);
                }
            }
        }

        System.out.println("Topological order in BFS : " + topoOrder);
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
