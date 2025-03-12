package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.CLASS_NAME, using = "app_logo")
    public WebElement logo;
    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    public WebElement cart;
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    public WebElement backPack;
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLight;
    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    public WebElement leftMenu;
    @FindBy(how = How.CLASS_NAME, using = "product_sort_container")
    public WebElement sortContainer;
    @FindBy(how = How.ID, using = "item_3_title_link")
    public List<WebElement> itemTitle;
    @FindBy(how = How.CLASS_NAME, using = "select_container")
    public WebElement selectContainer;
    @FindBy(how = How.XPATH, using = "//div[@class='inventory_list']/div ")
    public List<WebElement> items;
    @FindBy(how = How.CLASS_NAME, using = "title")
    public WebElement products;
}
