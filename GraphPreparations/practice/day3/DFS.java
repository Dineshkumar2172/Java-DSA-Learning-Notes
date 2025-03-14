package GraphPreparations.practice.day3;

import java.util.Stack;

import GraphPreparations.practice.day2.AdjacencyMatrix;
import GraphPreparations.practice.day2.AdjacencyList;

public class DFS {

    public void executeDFS(int vertex, AdjacencyList adjacencyList) {
        boolean[] isVisited = new boolean[adjacencyList.getNumberOfVertices()];
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (isVisited[current]) continue;

            System.out.print(current + ", ");
            isVisited[current] = true;

            // explore neighors
            for (Integer[] neigh: adjacencyList.getAdjacencyList().get(current)) {
                if (!isVisited[neigh[0]]) {
                    stack.push(neigh[0]);
                }
            }
        }

        System.out.println();
    }

    public void executeDFS(int vertex, AdjacencyMatrix adjacencyMatrix) {
        boolean[] isVisited = new boolean[adjacencyMatrix.getVertexCount()];
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (isVisited[current]) continue;
            
            System.out.print(current + ", ");
            isVisited[current] = true;

            // exploring the neighbors
            for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
                if (!isVisited[i] && adjacencyMatrix.getAdjacencyMatrix()[current][i] != 0) {
                        stack.push(i);
                }
            }
        }

        System.out.println();
    }

    public void executeDFSRecursive(int vertex, AdjacencyList adjacencyList, boolean[] visitedVertices) {
        if (visitedVertices[vertex]) return;

        System.out.print(vertex + ", ");
        visitedVertices[vertex] = true;

        for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(vertex)) {
            if (!visitedVertices[neighbor[0]]) {
                executeDFSRecursive(neighbor[0], adjacencyList, visitedVertices);
            }
        }
    }

    public void executeDFSRecursive(int vertex, AdjacencyMatrix adjacencyMatrix, boolean[] visitedVertices) {
        if (visitedVertices[vertex]) return;
        

        System.out.print(vertex + ", ");
        visitedVertices[vertex] = true;

        for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
            if(!visitedVertices[i] && adjacencyMatrix.getAdjacencyMatrix()[vertex][i] != 0) {
                executeDFSRecursive(i, adjacencyMatrix, visitedVertices);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(7, false, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(1, 3);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(2, 6);

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(7, false, false);
        adjacencyMatrix.addEdge(0, 1);
        adjacencyMatrix.addEdge(0, 2);
        adjacencyMatrix.addEdge(1, 3);
        adjacencyMatrix.addEdge(1, 4);
        adjacencyMatrix.addEdge(2, 5);
        adjacencyMatrix.addEdge(2, 6);

        DFS dfs = new DFS();
        dfs.executeDFS(0, adjacencyList);
        dfs.executeDFS(0, adjacencyMatrix);

        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        dfs.executeDFSRecursive(0, adjacencyList, visitedVertices);
        System.out.println();
        visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        dfs.executeDFSRecursive(0, adjacencyMatrix, visitedVertices);
        System.out.println();
    }
}
