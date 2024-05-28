package Class;

import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        super(graph, startVertex);
    }

    @Override
    public List<V> getPathTo(Vertex<V> endVertex) {
        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (current.equals(endVertex)) {
                break;
            }

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
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
