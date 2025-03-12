package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.sql.SQLException;

@Listeners(utilities.Listeners.class)

public class SauceDemoWebDB extends CommonOps {
    @Test(description = "Test01 - Verify Login to SauceDemo with DB Credentials")
    @Description("This test verifies login and the header")
    public void test01_verifyLoginDB() throws SQLException {
        WebFlows.loginDB();
        Verifications.verifyTextInElement(sauceDemoMain.logo, "Swag Labs");
    }

}
