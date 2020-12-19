package subway.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static void setScanner(Scanner scanner){
        InputView.scanner = scanner;
    }

    public static String getInput(){
        return scanner.nextLine();
    }
}
