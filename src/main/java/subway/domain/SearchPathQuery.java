package subway.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jgrapht.GraphPath;
import subway.domain.exception.DuplicatedStationException;
import subway.domain.exception.NullStationException;
import subway.domain.path.PathRepository;
import subway.domain.station.StationRepository;
import subway.domain.weight.WeightRepository;
import subway.domain.weight.WeightType;

public class SearchPathQuery {
    private WeightType weightType;
    private String startStation;
    private String endStation;

    public SearchPathQuery(WeightType weightType, String startStation, String endStation) {
        if (!StationRepository.containsStation(startStation)) {
            throw new NullStationException(startStation);
        }

        if (!StationRepository.containsStation(endStation)) {
            throw new NullStationException(endStation);
        }

        if (startStation.equals(endStation)) {
            throw new DuplicatedStationException();
        }

        this.weightType = weightType;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public QueryResult result() {
        GraphPath shortestPath = PathRepository.getShortestPath(weightType, startStation, endStation);
        Map<WeightType, Double> weights = getWeights(shortestPath);
        List<String> path = shortestPath.getVertexList();

        return new QueryResult(weights, path);
    }

    private Map<WeightType, Double> getWeights(GraphPath shortestPath) {
        Map<WeightType, Double> weights = new HashMap<>();

        weights.put(weightType, shortestPath.getWeight());
        for (WeightType weightType : Arrays.asList(WeightType.values())) {
            if (!weights.containsKey(weightType)) {
                weights.put(weightType, getWeightByPath(weightType, shortestPath.getVertexList()));
            }
        }

        return weights;
    }
    
    private double getWeightByPath(WeightType weightType, List<String> path) {
        double weight = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            weight += WeightRepository.getWeight(path.get(i), path.get(i + 1), weightType);
        }

        return weight;
    }
}
