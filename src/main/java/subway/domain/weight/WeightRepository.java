package subway.domain.weight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightRepository {
    private static final Map<Set<String>, Weight> weights = new HashMap<>();

    static {
        addWeight("교대역", "강남역", new Weight(2, 3));
        addWeight("강남역", "역삼역", new Weight(2, 3));
        addWeight("교대역", "남부터미널역", new Weight(3, 2));
        addWeight("남부터미널역", "양재역", new Weight(6, 5));
        addWeight("양재역", "매봉역", new Weight(1, 1));
        addWeight("강남역", "양재역", new Weight(2, 8));
        addWeight("양재역", "양재시민의숲역", new Weight(10, 5));
    }

    public static void addWeight(String firstStation, String secondStation, Weight weight) {
        Set<String> key = getKey(firstStation, secondStation);
        weights.put(key, weight);
    }

    public static void deleteWeight(String firstStation, String secondStation) {
        Set<String> key = getKey(firstStation, secondStation);
        weights.remove(key);
    }

    public static double getWeight(String firstStation, String secondStation, WeightType weightType) {
        Set<String> key = getKey(firstStation, secondStation);
        Weight weight = weights.get(key);
        return weight.get(weightType);
    }

    private static Set<String> getKey(String firstStation, String secondStation) {
        return new HashSet<>(Arrays.asList(firstStation, secondStation));
    }
}
