package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.NAME, using = "user-name")
    public WebElement txt_username;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.ID, using = "login-button")
    public WebElement btn_login;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
    public WebElement errorInformation;

}
