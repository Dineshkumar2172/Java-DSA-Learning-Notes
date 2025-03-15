package GraphPreparations.practice.day4;

import java.util.LinkedList;
import java.util.Queue;

import GraphPreparations.practice.day1.AdjacencyList;
import GraphPreparations.practice.day1.AdjacencyMatrix;

public class BFS {
    // iterates layer by layer
    // works irrespective of weights and directionality and cycles.

    public void executeBFS(int vertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visitedVertices[vertex] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(current)) {
                if (!visitedVertices[neighbor[0]]) {
                    queue.offer(neighbor[0]);
                    visitedVertices[neighbor[0]] = true;
                }
            }
        }

        System.out.println();
    }

    public void executeBFS(int vertex, AdjacencyMatrix adjacencyMatrix) {
        boolean[] visitedVertices = new boolean[adjacencyMatrix.getNumberOfVertices()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visitedVertices[vertex] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int i = 0; i < adjacencyMatrix.getNumberOfVertices(); i++) {
                if (adjacencyMatrix.getAdjacencyMatrix()[current][i] !=0 && !visitedVertices[i]) {
                    queue.offer(i);
                    visitedVertices[i] = true;
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(5, false, false);
        // Add edges
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(3, 4);

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, false, false);
        // Add edges
        adjacencyMatrix.addEdge(0, 1);
        adjacencyMatrix.addEdge(0, 3);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(1, 4);
        adjacencyMatrix.addEdge(3, 4);

        BFS bfs = new BFS();
        bfs.executeBFS(0, adjacencyList);
        bfs.executeBFS(0, adjacencyMatrix);
    }
}
