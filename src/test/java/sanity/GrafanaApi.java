package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaApi extends CommonOps {

    @Test(description = "Test 01: Get Team From Grafana")
    @Description("This Test Verify Team Property")
    public void test01_verifyTeam() {
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "Ateam");
    }

    @Test(description = "Test 02: Add Team to Grafana and Verify")
    @Description("This Test Adds Team to Grafana and Verify it Property")
    public void test02_addTeam() {
        ApiFlows.postTeam("DimaTeam", "dima@gmail.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "DimaTeam");
    }

    @Test(description = "Test 03: Update Team to Grafana and Verify")
    @Description("This Test Updates Team to Grafana and Verify it Property")
    public void test03_updateTeam() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("DimaTeam", "dima@mail.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "dima@mail.com");
    }

    @Test(description = "Test 04: Delete Team to Grafana and Verify")
    @Description("This Test Deletes Team to Grafana and Verify it Property")
    public void test04_deleteTeam() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "2");
    }
}
