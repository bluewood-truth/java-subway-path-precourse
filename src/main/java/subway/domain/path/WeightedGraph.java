package subway.domain.path;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.weight.WeightType;

public class WeightedGraph {
    private DijkstraShortestPath graph;

    public WeightedGraph(WeightType weightType) {
        this.graph = WeightedGraphFactory.getWeightedGraph(weightType);
    }

    public GraphPath getShortestPath(String startStation, String endStation){
        return graph.getPath(startStation, endStation);
    }
}
