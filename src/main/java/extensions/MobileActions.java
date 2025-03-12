package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.time.Duration;

public class MobileActions extends CommonOps {
    @Step("Click on element")
    public static void click(MobileElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("Update text on element")
    public static void updateText(MobileElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step("Tap on element")
    public static void tap(MobileElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        TouchAction action = new TouchAction(mobileDriver);
        action.tap((new TapOptions())
                .withElement(ElementOption.element(elem)))
                .perform();
    }
    @Step("Swipe")
    public static void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        Point pointStart, pointEnd;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = mobileDriver.manage().window().getSize();

        // init start point = center of screen
        pointStart = new Point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointEnd = new Point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointEnd = new Point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointEnd = new Point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointEnd = new Point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir.toString() + "' NOT supported");
        }

        // execute swipe using TouchAction
        pointOptionStart = PointOption.point(pointStart.x, pointStart.y);
        pointOptionEnd = PointOption.point(pointEnd.x, pointEnd.y);
        System.out.println("swipeScreen(): pointStart: {" + pointStart.x + "," + pointStart.y + "}");
        System.out.println("swipeScreen(): pointEnd: {" + pointEnd.x + "," + pointEnd.y + "}");
        System.out.println("swipeScreen(): screenSize: {" + dims.width + "," + dims.height + "}");
        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    @Step("Pinch element")
    public static void pinch(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() / 2;
        int y = elem.getLocation().getY() + elem.getSize().getWidth() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                .withElement(elem).withCoordinates(x, y - 100))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y - 10));

        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(elem).withCoordinates(x, y + 100))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y + 10));

        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    @Step("Zoom element")
    public static void Zoom(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() / 2;
        int y = elem.getLocation().getY() + elem.getSize().getWidth() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                        .withElement(elem).withCoordinates(x, y - 10))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y - 100));

        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(elem).withCoordinates(x, y + 10))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y + 100));

        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    @Step("Drag and drop")
    public static void dragAndDrop(MobileElement start, MobileElement finish) {
        TouchAction action = new TouchAction(mobileDriver);
        action.press(new ElementOption()
                        .withElement(start))
                .moveTo(new ElementOption().withElement(finish))
                .release()
                .perform();
    }


    @Step("Long press")
    public static void longPress(MobileElement elem, int duration) {
        TouchAction action = new TouchAction(mobileDriver);
        action.longPress(new LongPressOptions()
                        .withElement(ElementOption.element(elem))
                        .withDuration(Duration.ofSeconds(duration)))
                .perform();
    }


    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
