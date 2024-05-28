import Class.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("Almaty", "Astana", 1);
        graph.addEdge("Astana", "Shymkent", 2);
        graph.addEdge("Shymkent", "Kyzylorda", 3);
        graph.addEdge("Almaty", "Shymkent", 2);
        graph.addEdge("Astana", "Atyrau", 5);

        Vertex<String> startVertex = graph.getVertex("Almaty");
        Vertex<String> endVertex = graph.getVertex("Kyzylorda");

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, startVertex);
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, startVertex);

        System.out.println("Dijkstra:");
        System.out.println(String.join(" -> ", dijkstra.getPathTo(endVertex)));
        System.out.println("--------------------------------");
        System.out.println("BFS:");
        System.out.println(String.join(" -> ", bfs.getPathTo(endVertex)));
        System.out.println("--------------------------------");
    }
}
