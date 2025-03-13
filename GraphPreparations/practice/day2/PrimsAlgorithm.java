package GraphPreparations.practice.day2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    // reference 
    // 1. It's a greedy algorithm used for MST - minimum spanning tree.
    // 2. It works by selecting next smallest vertex based on weight.
    // 3. We use parent array, visited vertices array and minEdgeWeight arrray.
    // 4. It works on undirected and weighted graphs.
    public void executePrims(int startVertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Integer[] parent = new Integer[adjacencyList.getNumberOfVertices()];
        Integer[] minEdgeWeights = new Integer[adjacencyList.getNumberOfVertices()];

        Arrays.fill(minEdgeWeights, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        minEdgeWeights[startVertex] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        pq.offer(new Integer[]{startVertex, 0});

        Integer totalWeight = 0;

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            Integer currentVertex = current[0], currentWeight = current[1];
            if (visitedVertices[currentVertex]) continue;

            visitedVertices[currentVertex] = true;
            totalWeight += currentWeight;

            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(currentVertex)) {
                if (!visitedVertices[neighbor[0]] && neighbor[1] < minEdgeWeights[neighbor[0]]) {
                    minEdgeWeights[neighbor[0]] = neighbor[1];
                    pq.offer(new Integer[]{neighbor[0], neighbor[1]});
                    parent[neighbor[0]] = currentVertex;
                }
            }
        }

        System.out.println("Minimum spanning tree edges : ");
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + " (weight: " + minEdgeWeights[i] + ")");
            }
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public void executePrimsMatrix(Integer startVertex, AdjacencyMatrix adjacencyMatrix) {
        boolean[] visitedVertices = new boolean[adjacencyMatrix.getVertexCount()];
        Integer[] parent = new Integer[adjacencyMatrix.getVertexCount()];
        Integer[] minEdgeWeight = new Integer[adjacencyMatrix.getVertexCount()];
        
        Arrays.fill(parent, -1);
        Arrays.fill(minEdgeWeight, Integer.MAX_VALUE);
        minEdgeWeight[startVertex] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        pq.offer(new Integer[]{startVertex, 0});

        Integer totalWeight = 0;
        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            Integer currentVertex = current[0], currentWeight = current[1];

            if (visitedVertices[currentVertex]) continue;

            visitedVertices[currentVertex] = true;
            totalWeight += currentWeight;

            for (int neighbor = 0; neighbor < adjacencyMatrix.getVertexCount(); neighbor++) {
                if (adjacencyMatrix.getAdjacencyMatrix()[currentVertex][neighbor] > 0 &&
                    adjacencyMatrix.getAdjacencyMatrix()[currentVertex][neighbor] < minEdgeWeight[neighbor]) {
                    minEdgeWeight[neighbor] =  adjacencyMatrix.getAdjacencyMatrix()[currentVertex][neighbor];
                    parent[neighbor] = currentVertex;
                    pq.offer(new Integer[]{neighbor, adjacencyMatrix.getAdjacencyMatrix()[currentVertex][neighbor]});
                }
            }
        }

        System.out.println("Minimum spanning tree edges : ");
        for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + " (weight: " + minEdgeWeight[i] + ")");
            }
        }
        System.out.println("Total weight of MST : " + totalWeight);
    }

    public static void main(String[] args) {
        AdjacencyList weightedAdjacencyList = new AdjacencyList(6, false, true);

        weightedAdjacencyList.addEdge(0, 1, 3);
        weightedAdjacencyList.addEdge(0, 2, 3);
        weightedAdjacencyList.addEdge(1, 2, 3);
        weightedAdjacencyList.addEdge(1, 3, 3);
        weightedAdjacencyList.addEdge(2, 3, 3);
        weightedAdjacencyList.addEdge(2, 4, 3);
        weightedAdjacencyList.addEdge(3, 4, 3);
        weightedAdjacencyList.addEdge(4, 5, 3); // Ensure all nodes are connected for MST

        PrimsAlgorithm prims = new PrimsAlgorithm();
        prims.executePrims(0, weightedAdjacencyList);

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(6, false, true);
        adjacencyMatrix.addEdge(0, 1, 3);
        adjacencyMatrix.addEdge(0, 2, 3);
        adjacencyMatrix.addEdge(1, 2, 3);
        adjacencyMatrix.addEdge(1, 3, 3);
        adjacencyMatrix.addEdge(2, 3, 3);
        adjacencyMatrix.addEdge(2, 4, 3);
        adjacencyMatrix.addEdge(3, 4, 3);
        adjacencyMatrix.addEdge(4, 5, 3);

        prims.executePrimsMatrix(0, adjacencyMatrix);
    }
}
