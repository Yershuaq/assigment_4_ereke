package Class;

import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, V startVertex) {
        super(graph, startVertex);
    }

    @Override
    public List<V> getPathTo(V endVertex) {
        Map<V, V> parentMap = new HashMap<>();
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            if (current.equals(endVertex)) {
                break;
            }

            for (Vertex<V> neighbor : graph.getVertex(current).getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor.getData())) {
                    visited.add(neighbor.getData());
                    parentMap.put(neighbor.getData(), current);
                    queue.add(neighbor.getData());
                }
            }
        }

        List<V> path = new LinkedList<>();
        V step = endVertex;
        if (parentMap.containsKey(step) || step.equals(startVertex)) {
            while (step != null) {
                path.add(step);
                step = parentMap.get(step);
            }
            Collections.reverse(path);
        }

        return path;
    }
}
