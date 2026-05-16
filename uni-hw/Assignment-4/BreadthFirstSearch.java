import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(Vertex<V> source) {
        super(source);
        bfs(source);
    }

    private void bfs(Vertex<V> current) {
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(current);
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<V> vertex = queue.poll();

            for (Vertex<V> neighbor : vertex.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, vertex);
                    queue.add(neighbor);
                }
            }
        }
    }
}