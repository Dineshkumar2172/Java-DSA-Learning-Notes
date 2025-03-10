package GraphPreparations.week2.DijkstraAlgorithm;

public class DijkstraImplementation {
    public static void main(String[] args) {
        WeightedAdjacencyList weightedAdjacencyList = new WeightedAdjacencyList(5, true);
        weightedAdjacencyList.addEdge(0, 1, 10);
        weightedAdjacencyList.displayGraph();
    }
}
