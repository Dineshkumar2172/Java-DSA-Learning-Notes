package GraphAlgorithmCrashCourse;

import java.util.ArrayList;

public class Vertex {

    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Vertex endVertex, Integer weight) {
        // adding edges to arrayList
        this.edges.add(new Edge(this, endVertex, weight));
    };

    public void removeEdge(Vertex endVertex) {
        // using predicate to remove all elements from an array matching condition
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public String getData() {
        return this.data;
    }

    public static void main(String[] args) {
        
    }
}
