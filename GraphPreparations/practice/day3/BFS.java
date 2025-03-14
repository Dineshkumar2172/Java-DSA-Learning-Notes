package GraphPreparations.practice.day3;

import java.util.LinkedList;
import java.util.Queue;

import GraphPreparations.practice.day2.AdjacencyList;
import GraphPreparations.practice.day2.AdjacencyMatrix;

public class BFS {

    // BFS on adjacency list representation of graph data structure
    public void executeBFS(Integer vertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(vertex);
        visitedVertices[vertex] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
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

    // BFS on adjacency matrix representation of graph data structure
    public void executeBFS(int vertex, AdjacencyMatrix adjacencyMatrix) {
        boolean[] visitedVertices = new boolean[adjacencyMatrix.getVertexCount()];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(vertex);
        visitedVertices[vertex] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
                int isConnected = adjacencyMatrix.getAdjacencyMatrix()[current][i];
                if (!visitedVertices[i] && isConnected != 0) {
                    queue.offer(i);
                    visitedVertices[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(5, false, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(3, 4);

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, false, false);
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
