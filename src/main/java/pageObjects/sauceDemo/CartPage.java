package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CartPage {
    @FindBy(how = How.CLASS_NAME, using = "cart_item_label")
    public List<WebElement> cartItem;
}
