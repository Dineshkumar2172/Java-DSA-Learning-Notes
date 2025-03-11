package GraphPreparations.week3.MinimumSpanningTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import GraphPreparations.week2.WeightedAdjacencyList;

public class PrimsAlgorithm {
    // Prim's algorithm helps us to find MST - Minimum Cost Spanning Tree
    public void primMST(Integer startVertex, WeightedAdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getVertexCount()];
        Integer[] minEdgeWeight = new Integer[adjacencyList.getVertexCount()];
        Integer[] parent = new Integer[adjacencyList.getVertexCount()];

        Arrays.fill(minEdgeWeight, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        minEdgeWeight[startVertex] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(data -> data[1]));
        pq.offer(new Integer[]{startVertex, 0});

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            Integer currentVertex = current[0];

            if (visitedVertices[currentVertex]) continue;

            visitedVertices[currentVertex] = true;
            totalWeight += current[1];

            for (Integer[] neighbor: adjacencyList.getAdjacencyList()[currentVertex]) {
                Integer nextVertex = neighbor[0], nextVertexWeight = neighbor[1];
                if (!visitedVertices[nextVertex] && nextVertexWeight < minEdgeWeight[nextVertex]) {
                    minEdgeWeight[nextVertex] = nextVertexWeight;
                    pq.offer(new Integer[]{nextVertex, nextVertexWeight});
                    parent[nextVertex] = currentVertex;
                }
            }
        }

        System.out.println("Minimum spanning tree edges : ");
        for (int i = 0; i < adjacencyList.getVertexCount(); i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + " (weight: " + minEdgeWeight[i] + ")");
            }
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        WeightedAdjacencyList weightedAdjacencyList = new WeightedAdjacencyList(6, false); // it works only on directed graph

        weightedAdjacencyList.addEdge(0, 1, 3);
        weightedAdjacencyList.addEdge(0, 2, 3);
        weightedAdjacencyList.addEdge(1, 2, 3);
        weightedAdjacencyList.addEdge(1, 3, 3);
        weightedAdjacencyList.addEdge(2, 3, 3);
        weightedAdjacencyList.addEdge(2, 4, 3);
        weightedAdjacencyList.addEdge(3, 4, 3);
        weightedAdjacencyList.addEdge(4, 5, 3); // Ensure all nodes are connected for MST

        
        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();
        primsAlgorithm.primMST(0, weightedAdjacencyList);
    }   
}
