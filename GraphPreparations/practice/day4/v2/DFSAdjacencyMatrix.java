package GraphPreparations.practice.day4.v2;

import java.util.Stack;

public class DFSAdjacencyMatrix {
    public void executeDFSAdjacencyMatrix(int vertex, int startVertex, int[][] adjMatrix) {
        boolean[] isVisited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (isVisited[current]) continue;
            isVisited[current] = true;
            System.out.print(current + ", ");
            for (int i = 0; i < vertex; i++) {
                if (adjMatrix[current][i] == 1 && !isVisited[i]) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public void executeDFSAdjacencyMatrix(int vertex, int startVertex, int[][] adjMatrix, boolean[] isVisited) {
        if (isVisited[startVertex]) return;
        
        System.out.print(startVertex + ", ");
        isVisited[startVertex] = true;
        
        for (int i = 0; i < vertex; i++) {
            if (!isVisited[i] && adjMatrix[startVertex][i] == 1) {
                executeDFSAdjacencyMatrix(vertex, i, adjMatrix, isVisited);
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

        int[][] adjMatrix = new int[v][v];
        for (int[] edge: edges) adjMatrix[edge[0]][edge[1]] = 1;
        DFSAdjacencyMatrix dfsAdjacencyMatrix = new DFSAdjacencyMatrix();
        dfsAdjacencyMatrix.executeDFSAdjacencyMatrix(v, 0, adjMatrix);
        boolean[] isVisited = new boolean[v];
        dfsAdjacencyMatrix.executeDFSAdjacencyMatrix(v, 0, adjMatrix, isVisited);
    }
}
