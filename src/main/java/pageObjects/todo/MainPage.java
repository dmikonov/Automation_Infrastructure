package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div[2]/input")
    public WebElement txt_create;

    @FindBy(how = How.CLASS_NAME, using = "taskWrapper_2u8dN")
    public List<WebElement> list_task;

    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
    public WebElement btn_delete;
}
