package GraphPreparations.practice.day4.v2;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAdjacencyMatrix {

    public void executeBFSAdjMatrix(int vertex, int startVertex, int[][] adjMatrix) {
        boolean[] visitedVertices = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        visitedVertices[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int i = 0; i < vertex; i++) {
                if (!visitedVertices[i] && adjMatrix[current][i] != 0) {
                    queue.offer(i);
                    visitedVertices[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {1, 4},
            {2, 4},
            {3, 5},
            {4, 5}
        };

        int[][] adjacencyMatrix = new int[v][v];
        for (int[] edge: edges) {
            adjacencyMatrix[edge[0]][edge[1]] = 1;
        }
        BFSAdjacencyMatrix bfsAdjacencyMatrix = new BFSAdjacencyMatrix();
        bfsAdjacencyMatrix.executeBFSAdjMatrix(v, 0, adjacencyMatrix);
    }
}
