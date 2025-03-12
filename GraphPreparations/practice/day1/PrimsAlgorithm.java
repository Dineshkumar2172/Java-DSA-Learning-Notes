package GraphPreparations.practice.day1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    // prims algorithm helps us find minimum cost spanning tree.
    // it's a greedy algorithm - it works by finding the minimum edges from source vertex.
    public void prims(Integer startVertex, AdjacencyList adjacencyList) {
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
        Integer[] parent = new Integer[adjacencyList.getNumberOfVertices()];
        Integer[] minEdgeWeight = new Integer[adjacencyList.getNumberOfVertices()];

        Arrays.fill(minEdgeWeight, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        minEdgeWeight[startVertex] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));
        pq.offer(new Integer[]{startVertex, 0});

        int totalWeight = 0;
        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            Integer currentVertex = current[0], currentVertexWeight = current[1];

            if (visitedVertices[currentVertex]) continue;

            visitedVertices[currentVertex] = true;
            totalWeight += currentVertexWeight;

            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(currentVertex)) {
                Integer nextVertex = neighbor[0], nextVertexWeight = neighbor[1];
                if (!visitedVertices[nextVertex] && nextVertexWeight < minEdgeWeight[nextVertex]) {
                    minEdgeWeight[nextVertex] = nextVertexWeight;
                    pq.offer(new Integer[]{nextVertex, nextVertexWeight});
                    parent[nextVertex] = currentVertex;
                }
            }
        }

        System.out.println("Minimum spanning tree edges : ");
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + " (weight: " + minEdgeWeight[i] + ")");
            }
        }
        System.out.println("Total weight of MST: " + totalWeight);
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

        
        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();
        primsAlgorithm.prims(0, weightedAdjacencyList);
    }
}
