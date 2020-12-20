package subway.domain.path;

import java.util.HashMap;
import java.util.Map;
import org.jgrapht.GraphPath;
import subway.domain.weight.WeightType;

public class PathRepository {
    private static Map<WeightType, WeightedGraph> path = new HashMap<>();

    static {
        path.put(WeightType.DISTANCE, new WeightedGraph(WeightType.DISTANCE));
        path.put(WeightType.TIME, new WeightedGraph(WeightType.TIME));
    }

    public static GraphPath getShortestPath(WeightType weightType, String startStation, String endStation) {
        WeightedGraph pathGraph = path.get(weightType);
        return pathGraph.getShortestPath(startStation, endStation);
    }
}
