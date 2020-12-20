package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.domain.weight.WeightType;

public class QueryResult {
    private Map<WeightType, Double> weights = new HashMap<>();
    private List<String> path;

    public QueryResult(Map<WeightType, Double> weights, List<String> path) {
        this.weights = weights;
        this.path = path;
    };

    public double getWeight(WeightType weightType) {
        return weights.get(weightType);
    }
    
    public List<String> getPath() {
        return Collections.unmodifiableList(path);
    }
}
