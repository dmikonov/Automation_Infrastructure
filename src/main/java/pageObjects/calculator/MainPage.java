package pageObjects.calculator;

import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MainPage {
    @FindBy(how = How.NAME, using = "One")
    public WebElement btn_one;

    @FindBy(how = How.NAME, using = "Eight")
    public WebElement btn_eight;

    @FindBy(how = How.NAME, using = "Plus")
    public WebElement btn_plus;

    @FindBy(how = How.NAME, using = "Equals")
    public WebElement btn_equals;

    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clear;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId = 'CalculatorResults']")
    public WebElement field_result;

}
