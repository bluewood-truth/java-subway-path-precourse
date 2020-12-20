package subway.view;

import subway.domain.QueryResult;
import subway.domain.weight.WeightType;

public class OutputView {
	private static final String ERROR_FORMAT = "[ERROR] %s%n";
	private static final String INFO_FORMAT = "[INFO] %s%n";
	private static final String MESSAGE_FORMAT = "## %s%n";

	private static final String REQUEST_SELECT_FUNCTION = "원하는 기능을 선택하세요.";
	private static final String REQUEST_START_STATION = "출발역을 입력하세요.";
	private static final String REQUEST_END_STATION = "도착역을 입력하세요.";

	private static final String QUERY_RESULT = "조회 결과";
	private static final String SEPARATOR = "---";
	private static final String TOTAL_DISTANCE = "총 거리: %.0fkm";
	private static final String TOTAL_TIME = "총 소요 시간: %.0fkm";
	
	public static void requestSelectFunction() {
		printMessage(REQUEST_SELECT_FUNCTION);
	}

	public static void requestStartStation() {
		printMessage(REQUEST_START_STATION);
	}

	public static void requestEndStation() {
		printMessage(REQUEST_END_STATION);
	}

	public static void printResult(QueryResult result) {
		printMessage(QUERY_RESULT);
		printInfo(SEPARATOR);
		printInfo(String.format(TOTAL_DISTANCE, result.getWeight(WeightType.DISTANCE)));
		printInfo(String.format(TOTAL_TIME, result.getWeight(WeightType.TIME)));
		printInfo(SEPARATOR);
		for (String station : result.getPath()) {
			printInfo(station);
		}
	}

	public static void print(String message) {
		System.out.println(message);
		System.out.println();
	}

	public static void printError(Exception e) {
		System.out.printf(ERROR_FORMAT, e.getMessage());
		printEmptyLine();
	}

	private static void printMessage(String message) {
		System.out.printf(MESSAGE_FORMAT, message);
	}

	private static void printInfo(String message) {
		System.out.printf(INFO_FORMAT, message);
	}

	public static void printEmptyLine(){
		System.out.println();
	}
}
