import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distances;

    public DijkstraSearch(Vertex<V> source) {
        super(source);
        this.distances = new HashMap<>();
        dijkstra(source);
    }

    private void dijkstra(Vertex<V> source) {
        PriorityQueue<VertexDistance<V>> priorityQueue = new PriorityQueue<>();

        distances.put(source, 0.0);
        priorityQueue.add(new VertexDistance<>(source, 0.0));

        while (!priorityQueue.isEmpty()) {
            VertexDistance<V> current = priorityQueue.poll();
            Vertex<V> currentVertex = current.vertex;

            if (visited.contains(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            for (Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDistance = distances.get(currentVertex) + weight;

                if (!distances.containsKey(neighbor) || newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentVertex);
                    priorityQueue.add(new VertexDistance<>(neighbor, newDistance));
                }
            }
        }
    }

    public double getDistance(Vertex<V> destination) {
        return distances.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }

    private static class VertexDistance<V> implements Comparable<VertexDistance<V>> {
        private final Vertex<V> vertex;
        private final double distance;

        public VertexDistance(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance<V> other) {
            return Double.compare(this.distance, other.distance);
        }
    }
}