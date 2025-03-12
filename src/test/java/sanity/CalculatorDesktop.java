package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

public class CalculatorDesktop extends CommonOps {
    @Test(description = "Test01 - Verify Addition Command")
    @Description("This test adds new task and verify it in list")
    public void test01_verifyAdditionCommand(){
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.field_result,"Display is 9");
    }
}
