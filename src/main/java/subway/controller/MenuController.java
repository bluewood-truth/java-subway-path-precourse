package subway.controller;

import subway.domain.menu.Menu;
import subway.domain.menu.Menus;
import subway.domain.menu.MenuType;
import subway.view.InputView;
import subway.view.OutputView;

public class MenuController {
    public static void callMainMenu() {
        showMenu(Menus.getMenu(MenuType.MAIN));
    }

    public static void callSearchPathMenu() {
        showMenu(Menus.getMenu(MenuType.SEARCH_PATH));
    }

    private static void showMenu(Menu menu) {
        OutputView.print(menu.toString());
        selectFunction(menu);
    }
    
    private static void selectFunction(Menu menu) {
        try {
            OutputView.requestSelectFunction();
            menu.executeMenuItem(InputView.getInput());
        } catch (Exception exception) {
            OutputView.printError(exception);
            selectFunction(menu);
        }
    }
}
