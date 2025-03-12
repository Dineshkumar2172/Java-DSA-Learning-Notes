package GraphPreparations.practice.day1;

import java.util.Stack;

public class DFSAdjacencyMatrix {

    public void executeDFSIterative(Integer startVertex, AdjacencyMatrix adjacencyMatrix) {
        boolean[] visitedVertices = new boolean[adjacencyMatrix.getNumberOfVertices()];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if (!visitedVertices[current]) {
                System.out.print(current + ", ");
                visitedVertices[current] = true;
                for (int i = 0; i < adjacencyMatrix.getNumberOfVertices(); i++) {
                    if(adjacencyMatrix.getAdjacencyMatrix()[current][i] != 0 && !visitedVertices[i]) {
                        stack.push(i);
                    }
                }
            }
        }

        System.out.println();
    }


    private boolean visitedVertices[];

    public void initialiseDFSRecursive(Integer V) { this.visitedVertices = new boolean[V];}

    public void executeDFSRecursive(Integer startVertex, AdjacencyMatrix adjacencyMatrix) {
        if (visitedVertices[startVertex]) return;

        System.out.print(startVertex + ", ");
        visitedVertices[startVertex] = true;
        for (int i = 0; i < adjacencyMatrix.getNumberOfVertices(); i++) {
            if (adjacencyMatrix.getAdjacencyMatrix()[startVertex][i] == 1 && !visitedVertices[i]) {
                executeDFSRecursive(i, adjacencyMatrix);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, true, false);
        // Add edges
        adjacencyMatrix.addEdge(0, 1);
        adjacencyMatrix.addEdge(0, 3);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(1, 4);
        adjacencyMatrix.addEdge(3, 4);
        adjacencyMatrix.displayGraph();

        DFSAdjacencyMatrix dfsAdjacencyMatrix = new DFSAdjacencyMatrix();
        dfsAdjacencyMatrix.executeDFSIterative(0, adjacencyMatrix);
        dfsAdjacencyMatrix.initialiseDFSRecursive(5);
        dfsAdjacencyMatrix.executeDFSRecursive(0, adjacencyMatrix);
    }
}
