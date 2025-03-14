package GraphPreparations.practice.day3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import GraphPreparations.practice.day1.AdjacencyList;

public class TopologicalSortDFS {

    public void dfs(int vertex, AdjacencyList adjacencyList, boolean[] visitedVertoces, Stack<Integer> stack) {
        if(visitedVertoces[vertex]) return;

        visitedVertoces[vertex] = true;
        for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(vertex)) {
            if (!visitedVertoces[neighbor[0]]) {
                dfs(neighbor[0], adjacencyList, visitedVertoces, stack);
            }
        }

        stack.push(vertex);
    }
    
    public void executeDFS(AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (!visitedVertices[i]) {
                dfs(i, adjacencyList, visitedVertices, stack);
            }
        }

        System.out.println("topological sort output : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
    }

    public void executeBFS(AdjacencyList adjacencyList) {
        int[] inDegree = new int[adjacencyList.getNumberOfVertices()];

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(i)) {
                inDegree[neighbor[0]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new LinkedList<>();
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            topoOrder.add(current);
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(current)) {
                if (--inDegree[neighbor[0]] == 0) {
                    queue.offer(neighbor[0]);
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

        TopologicalSortDFS topoOrder = new TopologicalSortDFS();
        topoOrder.executeDFS(adjacencyList);
        topoOrder.executeBFS(adjacencyList);
    }
}
