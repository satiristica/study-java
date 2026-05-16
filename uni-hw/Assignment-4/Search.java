import java.util.*;

public abstract class Search<V> {
    protected final Vertex<V> source;
    protected final Set<Vertex<V>> visited;
    protected final Map<Vertex<V>, Vertex<V>> edgeTo;

    public Search(Vertex<V> source) {
        this.source = source;
        this.visited = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> destination) {
        return visited.contains(destination);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> destination) {
        if (!hasPathTo(destination)) {
            return null;
        }

        LinkedList<Vertex<V>> path = new LinkedList<>();

        for (Vertex<V> current = destination; current != null; current = edgeTo.get(current)) {
            path.addFirst(current);

            if (current.equals(source)) {
                break;
            }
        }

        return path;
    }
}