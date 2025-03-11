package GraphPreparations.week2.FloydWarshallAlgorithm;

public class FloydWarshallImplementation {
    
    // Algorithm Steps
    // 1. Create a distance matrix dist[][], where dist[i][j] stores the shortest distance from node i to node j.
    //      i) Initialize dist[i][j] = weight(i → j) if an edge exists.
    //     ii) Otherwise, set dist[i][j] = ∞ (Integer.MAX_VALUE).
    //    iii) Set dist[i][i] = 0 for all i.
    // 2. Run a Triple Nested Loop:
    //      i) Iterate over all possible intermediate nodes k.
    //     ii) Update dist[i][j] using dist[i][k] + dist[k][j].
    // 3. Check for Negative Cycles:
    //      i) If dist[i][i] < 0 for any i, there is a negative cycle.


    public static void main(String[] args) {
        
    }
}
