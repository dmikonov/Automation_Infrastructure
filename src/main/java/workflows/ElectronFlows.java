package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task to the List")
    public static void addNewTask(String taskName) {
        UIActions.updateText(toDoMain.txt_create, taskName);
        UIActions.insertKeys(toDoMain.txt_create, Keys.RETURN);
    }
    @Step("Get Count Number of Task in List")
    public static int getNumberOfTask() {
       return toDoMain.list_task.size();
    }
    @Step("Empty Lists From Tasks")
    public static void emptyList() {
        for (int i = 0; i < getNumberOfTask(); i++) {
            UIActions.mouseHover(toDoMain.btn_delete);
        }
    }
}
