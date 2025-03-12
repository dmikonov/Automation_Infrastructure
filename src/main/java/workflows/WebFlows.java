package workflows;

import extensions.DBActions;
import extensions.UIActions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.List;

public class WebFlows extends CommonOps {
    @Step("Business Flow: Login")
    public static void login(String user, String password){
        UIActions.updateText(sauceDemoLogin.txt_username, user);
        UIActions.updateText(sauceDemoLogin.txt_password, password);
        UIActions.click(sauceDemoLogin.btn_login);
    }
    @Step("Business Flow: Login from DB")
    public static void loginDB() throws SQLException {
        String query = "SELECT name,password FROM Employees WHERE id = '2'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(sauceDemoLogin.txt_username, cred.get(0));
        UIActions.updateText(sauceDemoLogin.txt_password, cred.get(1));
        UIActions.click(sauceDemoLogin.btn_login);
    }
    @Step("Business Flow: Select Item")
    public static void selectItem(){
        UIActions.click(sauceDemoMain.backPack);
        UIActions.click(sauceDemoMain.bikeLight);
        UIActions.click(sauceDemoMain.cart);
    }
    @Step("Business Flow: Move to 'Sauce Labs' page")
    public static void moveToSauceLabsPage(){
        UIActions.click(sauceDemoMain.leftMenu);
        UIActions.click(sauceDemoLeftMenu.aboutButton);
    }
    @Step("Business Flow: Sorting from 'Z' to 'A'")
    public static void selectSortFromZtoA(){
        UIActions.click(sauceDemoMain.selectContainer);
        UIActions.updateDropDown(sauceDemoMain.sortContainer, "za");
    }
}
