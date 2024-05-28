import Class.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("Almaty", "Astana", 1);
        graph.addEdge("Astana", "Shymkent", 2);
        graph.addEdge("Shymkent", "Kyzylorda", 3);
        graph.addEdge("Almaty", "Shymkent", 2);
        graph.addEdge("Astana", "Atyrau", 5);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "Almaty");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");

        System.out.println("Dijkstra:");
        System.out.println(String.join(" -> ", dijkstra.getPathTo("Kyzylorda")));
        System.out.println("--------------------------------");
        System.out.println("BFS:");
        System.out.println(String.join(" -> ", bfs.getPathTo("Kyzylorda")));
        System.out.println("--------------------------------");
    }
}
