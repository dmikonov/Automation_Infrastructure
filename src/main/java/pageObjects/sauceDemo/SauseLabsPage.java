package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SauseLabsPage {
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div/div/div[1]/div[1]/a/div[1]/img")
    public WebElement logo;
}
