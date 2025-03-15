package GraphPreparations.practice.day4.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSAdjacencyList {

    public void executeDFSAdjacencyList(int vertex, int startVertex, List<List<Integer>> adjList) {
        boolean[] visitedVertices = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (visitedVertices[current]) continue;

            System.out.print(current + ", ");
            visitedVertices[current] = true;
            for (int neighbor: adjList.get(current)) {
                if (!visitedVertices[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void executeDFSAdjacencyList(int vertex, int startVertex, List<List<Integer>> adjList, boolean[] isVisited) {
        if (isVisited[startVertex]) return;
        
        System.out.print(startVertex + ", ");
        isVisited[startVertex] = true;
        for (int neighbor: adjList.get(startVertex)) {
            if (!isVisited[neighbor]) {
                executeDFSAdjacencyList(vertex, neighbor, adjList, isVisited);
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

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        for (int[] edge: edges) adjList.get(edge[0]).add(edge[1]);
        DFSAdjacencyList dfsAdjacencyList = new DFSAdjacencyList();
        dfsAdjacencyList.executeDFSAdjacencyList(v, 0, adjList);

        boolean[] isVisited = new boolean[v];
        dfsAdjacencyList.executeDFSAdjacencyList(v, 0, adjList, isVisited);
    }
}
