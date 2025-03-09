package GraphPreparations.GraphRepresentations;

public class AdjacencyMatrix {
    // representation
    //      1. it's a 2*2 matrix adjMatrix[i][j] (represents the vertices)
    //      2. each element in the matrix is set to either 0 or 1
    //      3. 0 represents no edges, 1 represents edges

    private boolean[][] adjMatrix;
    private boolean isUndirectedGraph; // flag for user to tell if its directed or undirected graph

    public AdjacencyMatrix(int v, boolean isUndirectedGraph){
        // matrix is always in a dimension of V*V based on number of vertices
        // If there are 2 vertices in a graph, then it's dimension would be 2*2
        this.adjMatrix = new boolean[v][v];
        this.isUndirectedGraph = isUndirectedGraph;
    }

    public void addEdge(int startVertex, int endVertex){
        if (!isValidVertex(startVertex) || !isValidVertex(endVertex)) {
            System.out.println("Entered vertex is out of bound. Please verify the input vertex");
            return;
        }

        if (adjMatrix[startVertex][endVertex]) {
            System.out.println("Invalid operation: There is already an edge exists between " + startVertex + " and " + endVertex);
            return;
        }

        this.adjMatrix[startVertex][endVertex] = true;
        // if its undirected graph
        if (isUndirectedGraph) {
            // then the equivalent reverse link should also be updated
            this.adjMatrix[endVertex][startVertex] = true;
        }
    };

    public void removeEdge(int startVertex, int endVertex){
        if (!isValidVertex(startVertex) || !isValidVertex(endVertex)) {
            System.out.println("Entered vertex is out of bound. Please verify the input vertex");
            return;
        }

        if (!adjMatrix[startVertex][endVertex]) {
            System.out.println("Invalid operation: There is no existing link between " + startVertex + " and " + endVertex);
            return;
        }

        this.adjMatrix[startVertex][endVertex] = false;
         // if its undirected graph
        if (isUndirectedGraph) {
            // then the equivalent reverse link should also be updated
            this.adjMatrix[endVertex][startVertex] = false;
        }
    };

    public boolean isValidVertex(int v){
        return v >= 0 && v < this.adjMatrix.length;
    }

    public void displayEdges(){
        System.out.println("adjacency matrix representation : ");
        for (boolean[] row : this.adjMatrix) {
            for (boolean b : row) {
                System.out.print(b ? "1 " : "0 ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(2, false);

        System.out.println("before updating - matrix is initialised with 0's");
        adjacencyMatrix.displayEdges();

        System.out.println("after adding edges : ");
        adjacencyMatrix.addEdge(0, 1); // created a edge between 0th and 1st vertices
        adjacencyMatrix.displayEdges(); 

        System.out.println("after removing edges : ");
        adjacencyMatrix.removeEdge(0, 4); // removed the edges between vertices 0 and 1
        adjacencyMatrix.displayEdges();
    }

}
