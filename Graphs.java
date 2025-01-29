public class Graphs {
    
    private int[][] adjMatrix;
    private int V; // number of vertices in graph
    private int E; // number of edges in graph

    public Graphs(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v){
        // in undirected graph, nodes are birectional
        // relationship between em will go both ways, so both are set to 1
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;
        this.E++; // increase the edges as we add nodes
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            stringBuilder.append(v + " : ");
            for (int w : adjMatrix[v]) {
                stringBuilder.append(w + " ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        /**
         * What is a Graph?
         *      1. It's a non linear data structure used for storing data.
         *      2. It is a set of vertices and a collection of edges that connects a pair of vertices.
         *      3. Nodes are the vertex of graph and each line connecting them is called as edge.
         *      3. Graphs help us implement social networking sites such as Facebook, Twitter etc. It can be called as social networking graph.
         *      4. Names of people represent vertices of graph and friendship between two people can be represented as an edge of graph.
         *          (https://youtu.be/2ZLl8GAk1X4?t=113979)
         */

         // Adjacency Matrix Representation (Undirected Graph)
         // What is an undirected graph?
         //     1. Example - social networking graph is an undirected graph.
         //     2. If John is a friend to max, then max is also a friend to john.
         
         // Adjacency Matrix Implementation (Undirected Graph)
         Graphs graphs = new Graphs(4);
         graphs.addEdge(0, 1);
         graphs.addEdge(1, 2);
         graphs.addEdge(2, 3);
         graphs.addEdge(3, 0);
         System.out.println(graphs);
    }
}
