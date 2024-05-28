package Class;

import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        super(graph, startVertex);
    }

    @Override
    public List<V> getPathTo(Vertex<V> endVertex) {
        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Vertex<V> vertex : graph.getVertices().values()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(startVertex, 0.0);

        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    parentMap.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        List<V> path = new LinkedList<>();
        Vertex<V> step = endVertex;
        if (parentMap.containsKey(step) || step.equals(startVertex)) {
            while (step != null) {
                path.add(step.getData());
                step = parentMap.get(step);
            }
            Collections.reverse(path);
        }

        return path;
    }
}
