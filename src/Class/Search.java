package Class;

import java.util.List;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;
    protected V startVertex;

    public Search(WeightedGraph<V> graph, V startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
    }

    public abstract List<V> getPathTo(V endVertex);
}
