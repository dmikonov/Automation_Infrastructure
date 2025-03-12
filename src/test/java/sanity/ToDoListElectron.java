package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class ToDoListElectron extends CommonOps {

    @Test(description = "Test01 - Add and Verify New Task")
    @Description("This test adds new task and verify it in list")
    public void test01_addTaskAndVerify(){
        ElectronFlows.addNewTask("Learn Java");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTask(), 1);
    }
    @Test(description = "Test02 - Add and Verify New Tasks")
    @Description("This test adds new task and verify it in list")
    public void test02_addTaskAndVerify(){
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTask(), 2);
    }

}
