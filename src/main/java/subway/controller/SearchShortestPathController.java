package subway.controller;

import subway.domain.SearchPathQuery;
import subway.domain.weight.WeightType;
import subway.view.InputView;
import subway.view.OutputView;

public class SearchShortestPathController {
    public static void SearchShortestDistancePath() {
        try {
            tryToSearchShortestPath(WeightType.DISTANCE);
            backToMainMenu();
        } catch (Exception exception) {
            catchError(exception);
        }
    }

    public static void SearchShortestTimePath() {
        try {
            tryToSearchShortestPath(WeightType.TIME);
        } catch (Exception exception) {
            catchError(exception);
        }
    }

    private static void tryToSearchShortestPath(WeightType type) {
        SearchPathQuery query = new SearchPathQuery(type, inputStartStation(), inputEndStation());
        OutputView.printResult(query.queryResult());
    }

    private static String inputStartStation() {
        OutputView.requestStartStation();
        return InputView.getInput();
    }
    
    private static String inputEndStation() {
        OutputView.requestEndStation();
        return InputView.getInput();
    }
    
    private static void catchError(Exception exception) {
        OutputView.printError(exception);
        MenuController.callSearchPathMenu();
    }

    public static void backToMainMenu() {
        MenuController.callMainMenu();
    }
}
