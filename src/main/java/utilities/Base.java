package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //DataBase
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    //Page Objects Web
    protected static pageObjects.sauceDemo.LoginPage sauceDemoLogin;
    protected static pageObjects.sauceDemo.MainPage sauceDemoMain;
    protected static pageObjects.sauceDemo.CartPage sauceDemoCart;
    protected static pageObjects.sauceDemo.LeftMenuPage sauceDemoLeftMenu;
    protected static pageObjects.sauceDemo.SauseLabsPage sauseLabsPage;

    //Page Objects Mobile
    protected static pageObjects.mortgage.MainPage mortgageMain;

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Electron
    protected static pageObjects.todo.MainPage toDoMain;

    //Desktop
    protected static WindowsDriver windowsDriver;
    protected static pageObjects.calculator.MainPage calcMain;
}
