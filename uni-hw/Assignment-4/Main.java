public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        Vertex<String> newYork = new Vertex<>("NewYork");
        Vertex<String> seoul = new Vertex<>("Seoul");
        Vertex<String> tokyo = new Vertex<>("Tokyo");
        Vertex<String> tuco = new Vertex<>("Tuco");
        Vertex<String> washington = new Vertex<>("Washington");

        graph.addEdge(newYork, seoul, 10);
        graph.addEdge(newYork, tokyo, 5);
        graph.addEdge(tokyo, seoul, 3);
        graph.addEdge(seoul, tuco, 1);
        graph.addEdge(tokyo, washington, 2);
        graph.addEdge(washington, tuco, 6);

        System.out.println("BFS path from NewYork to Tuco:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(newYork);
        printPath(bfs.pathTo(tuco));

        System.out.println();

        System.out.println("Dijkstra shortest path from NewYork to Tuco:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(newYork);
        printPath(dijkstra.pathTo(tuco));
        System.out.println("Distance: " + dijkstra.getDistance(tuco));
    }

    private static <V> void printPath(Iterable<Vertex<V>> path) {
        if (path == null) {
            System.out.println("No path found");
            return;
        }

        for (Vertex<V> vertex : path) {
            System.out.print(vertex + " ");
        }

        System.out.println();
    }
}