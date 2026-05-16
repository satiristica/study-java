import java.util.ArrayList;
import java.util.List;

public class WeightedGraph<V> {
    private final List<Vertex<V>> vertices;
    private final boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex<V> vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
        }
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        addVertex(source);
        addVertex(destination);

        source.addAdjacentVertex(destination, weight);

        if (!directed) {
            destination.addAdjacentVertex(source, weight);
        }
    }

    public List<Vertex<V>> getVertices() {
        return vertices;
    }
}