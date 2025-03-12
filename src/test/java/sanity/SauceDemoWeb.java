package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SauceDemoWeb extends CommonOps {

    @Test(description = "Test01 - Verify Login", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verifies login and the header")
    public void test01_verifyHeader(String user, String password){
        WebFlows.login(user, password);
        Verifications.verifyTextInElement(sauceDemoMain.logo, "Swag Labs");
    }
    @Test(description = "Test02 - Verify Cart")
    @Description("This test verifies login and the cart")
    public void test02_verifyCart(){
        WebFlows.login("standard_user", "secret_sauce");
        WebFlows.selectItem();
        Verifications.numberOfElements(sauceDemoCart.cartItem, 2);
    }
    @Test(description = "Test03 - Verify Moving to 'Sauce Labs' page")
    @Description("This test verifies login and moving to 'Sauce Labs' page")
    public void test03_verifyMovingToSauceLabsPage(){
        WebFlows.login("standard_user", "secret_sauce");
        WebFlows.moveToSauceLabsPage();
        Verifications.elementIsDisplayed(sauseLabsPage.logo);
    }
    @Test(description = "Test04 - Verify Sorting from 'Z' to 'A'")
    @Description("This test verifies login and moving to 'Sauce Labs' page")
    public void test04_verifySorting(){
        WebFlows.login("standard_user", "secret_sauce");
        WebFlows.selectSortFromZtoA();
        Verifications.firstElement(sauceDemoMain.itemTitle, "Test.allTheThings() T-Shirt (Red)");
    }
    @Test(description = "Test05 - Verify Items")
    @Description("This test verifies login and items on the main page")
    public void test05_verifyItems(){
        WebFlows.login("standard_user", "secret_sauce");
        Verifications.visibilityOfElements(sauceDemoMain.items);
    }
    @Test(description = "Test06 - Verify Cart")
    @Description("This test verifies existing a cart icon")
    public void test06_verifyCartIcon(){
        WebFlows.login("standard_user", "secret_sauce");
        Verifications.visualElement("cart");
    }
    @Test(description = "Test07 - Verify Negative Login")
    @Description("This test verifies negative users")
    public void test07_verifyNegativeUsers(){
        WebFlows.login("locked_out_user", "secret_sauce");
        Verifications.verifyTextInElement(sauceDemoLogin.errorInformation, "Epic sadface: Sorry, this user has been locked out.");
    }

}
