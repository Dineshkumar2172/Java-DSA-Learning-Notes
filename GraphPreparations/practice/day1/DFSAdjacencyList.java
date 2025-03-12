package GraphPreparations.practice.day1;

import java.util.Stack;

public class DFSAdjacencyList {

    public void executeDFS(Integer startVertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if (!visitedVertices[current]) {
                System.out.print(current + ", ");
                visitedVertices[current] = true;
                for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(current)) {
                    if (!visitedVertices[neighbor[0]]) {
                        stack.push(neighbor[0]);
                    }
                }
            }
        }
        System.out.println();
    }

    private boolean visitedVertices[];

    public void initialiseDFSRecursive(Integer V) { this.visitedVertices = new boolean[V];}

    public void executeDFSRecursive(Integer startVertex, AdjacencyList adjacencyList) {
        if (visitedVertices[startVertex]) return;

        System.out.print(startVertex + ", ");
        visitedVertices[startVertex] = true;

        for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(startVertex)) {
            executeDFSRecursive(neighbor[0], adjacencyList);
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(10, false, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(1, 3);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(2, 6);

        DFSAdjacencyList dfsAdjacencyList = new DFSAdjacencyList();
        dfsAdjacencyList.executeDFS(0, adjacencyList);
        dfsAdjacencyList.initialiseDFSRecursive(10);
        dfsAdjacencyList.executeDFSRecursive(0, adjacencyList);
        
    }
}
