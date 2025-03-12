package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;


public class Verifications extends CommonOps {
    @Step("Verify text in element")
    public static void verifyTextInElement(WebElement elem, String expectedString){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expectedString);
    }
    @Step("Verify number of element")
    public static void numberOfElements(List<WebElement> items, int expected){
        wait.until(ExpectedConditions.visibilityOf(items.get(items.size()-1)));
        assertEquals(items.size(), expected);
    }
    @Step("Verify visibility element")
    public static void elementIsDisplayed(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }
    @Step("Verify a first element")
    public static void firstElement(List<WebElement> items, String expectedString){
        wait.until(ExpectedConditions.visibilityOf(items.get(items.size()-1)));
        assertEquals(items.get(0).getText(), expectedString);
    }
    @Step("Verify Visibility Of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems){
        for(WebElement elem : elems){
            softAssert.assertTrue(elem.isDisplayed(), "Sorry, " +elem.getText()+ " not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }
    @Step("Verify Visually of Element")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".PNG");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File" + findFailed);
            fail("Error Comparing Image File" + findFailed);
        }
    }
    @Step("Verify Element Displayed")
    public static void existanceOfElement(List<WebElement> elements, int expectedNumber){
        assertEquals(expectedNumber, elements.size());
    }
    @Step("Soft Assertion of Element")
    public static void displayingOfElement(WebElement element){
        softAssert.assertTrue(element.isDisplayed());
        softAssert.assertAll();
    }
    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }
    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual, expected);
    }
}
