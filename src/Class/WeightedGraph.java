package Class;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public void addEdge(V source, V destination, double weight) {
        if (!vertices.containsKey(source)) {
            addVertex(source);
        }
        if (!vertices.containsKey(destination)) {
            addVertex(destination);
        }
        vertices.get(source).addAdjacentVertex(vertices.get(destination), weight);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}
