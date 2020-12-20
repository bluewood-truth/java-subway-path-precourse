package subway.domain.path;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.weight.WeightType;

public class WeightedGraph {
    private DijkstraShortestPath graph;

    public WeightedGraph(WeightType type) {
        this.graph = ShortestPathFactory.getShortestPath(type);
    }

    public GraphPath getShortestPath(String startStation, String endStation){
        return graph.getPath(startStation, endStation);
    }
}
