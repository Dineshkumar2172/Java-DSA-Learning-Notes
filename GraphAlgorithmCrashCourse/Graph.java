package GraphAlgorithmCrashCourse;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted; // flag to say if its weighted graph
    private boolean isDirected; // flag to say if its directed graph

    public void graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight){
        if (!this.isWeighted) {
            weight = null;
        }

        vertex1.addEdge(vertex2, weight);
        if (!this.isDirected) { // incase of undirected, edges goes both ways
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if(!this.isDirected) { // incase of undirected, remove edge in other half as well
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public Vertex getVertexByValue(String value) {
        for (Vertex vertex : vertices) {
            if (vertex.getData() == value) {
                return vertex;
            }
        }

        return null;
    }

    public void print() {
        for (Vertex vertex : vertices) {
            vertex.print(isWeighted);
        }
    }

    public static void main(String[] args) {
        // Circles are vertices that holds data and edges are links that connects them

        // As part of this course, we'll be building a single class which should be able to support
        // undirected, directed, weighted, unweighted, connected and disconnected graphs.

        // This course is gonna cover three main graph traversal algorithm
        //      1. Depth First Search
        //      2. Breadth First Search
        //      3. Dijkstra's algorithm

        
    }
}
