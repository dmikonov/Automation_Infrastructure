package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.sauceDemo.*;

public class ManagePages extends Base {

    public static void initSauceDemo() {
        sauceDemoLogin = PageFactory.initElements(driver, LoginPage.class);
        sauceDemoMain = PageFactory.initElements(driver, MainPage.class);
        sauceDemoCart = PageFactory.initElements(driver, CartPage.class);
        sauceDemoLeftMenu = PageFactory.initElements(driver, LeftMenuPage.class);
        sauseLabsPage = PageFactory.initElements(driver, SauseLabsPage.class);
    }

    public static void initMortgage() {
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }

    public static void initToDo() {
        toDoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator() {
        calcMain = PageFactory.initElements(windowsDriver, pageObjects.calculator.MainPage.class);
    }
}
