package Class;

import java.util.*;

public class DijkstraSearch<V> {
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public List<V> dijkstra(V start, V goal) {
        List<V> path = new ArrayList<>();
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> cameFrom = new HashMap<>();
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparing(distances::get));
        Set<Vertex<V>> visited = new HashSet<>();

        Vertex<V> startVertex = graph.getVertex(start);
        Vertex<V> goalVertex = graph.getVertex(goal);

        if (startVertex == null || goalVertex == null) {
            return path;
        }

        distances.put(startVertex, 0.0);
        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();

            if (current.equals(goalVertex)) {
                while (current != null) {
                    path.add(0, current.getData());
                    current = cameFrom.get(current);
                }
                break;
            }

            visited.add(current);

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();

                if (visited.contains(neighbor)) {
                    continue;
                }

                double newDist = distances.get(current) + weight;
                if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    cameFrom.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        return path;
    }
}
