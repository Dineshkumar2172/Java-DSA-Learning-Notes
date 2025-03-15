package GraphPreparations.practice.day4;

import java.util.LinkedList;
import java.util.Queue;

import GraphPreparations.practice.day1.AdjacencyList;

public class CycleDetection {

    public boolean executeUndirectedBFS(int start, AdjacencyList adjacencyList) {
        boolean[] visitedNodes = new boolean[adjacencyList.getNumberOfVertices()];
        Queue<Integer> queue = new LinkedList<>();
        visitedNodes[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer[] neigh: adjacencyList.getAdjacencyList().get(current)) {
                if (!visitedNodes[neigh[0]]) {
                    queue.offer(neigh[0]);
                    visitedNodes[neigh[0]] = true;
                // if the node is already visited but not by the parent (current) node.
                } else if (neigh[0] != current) { // then there is a cycle
                    return true;
                }
            }
        }

        return false;
    }

    public boolean executeDFS(AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (!visitedVertices[i]) {
                if (executeUndirectedDFS(i, visitedVertices, adjacencyList)) {
                    return true;
                };
            }
        }

        return false;
    }

    public boolean executeUndirectedDFS(
        int vertex,  boolean[] visitedVertex, AdjacencyList adjacencyList) {
            visitedVertex[vertex] = true;

            for (Integer[] neigh: adjacencyList.getAdjacencyList().get(vertex)) {
                if (!visitedVertex[neigh[0]]) {
                    if(executeUndirectedDFS(neigh[0], visitedVertex, adjacencyList)) {
                        return true;
                    };
                } else if (neigh[0] != vertex) {
                    return true;
                }
            }
            
            return false;
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(7, true, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(4, 6);
        adjacencyList.addEdge(5, 6);

        CycleDetection cycleDetection = new CycleDetection();
        System.out.println(cycleDetection.executeUndirectedBFS(0, adjacencyList));
        System.out.println(cycleDetection.executeDFS(adjacencyList));
    }
}
