package com.monster.wiki.test.stepdef;

import com.monster.wiki.context.TestContext;
import com.monster.wiki.pageobjects.AffinityPage;
import com.monster.wiki.pageobjects.IncidencePage;
import com.monster.wiki.pageobjects.LoginPage;
import com.monster.wiki.utils.ParentTestCase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

import static org.testng.Assert.assertFalse;

public class IncidenceStepDef extends ParentTestCase {
    private AffinityPage affinityPage;
    private LoginPage loginPage;
    private IncidencePage incidencePage;

    public IncidenceStepDef(TestContext context) {
        super(context);
        affinityPage = new AffinityPage(this.driver);
        loginPage = new LoginPage(this.driver);
        incidencePage = new IncidencePage(this.driver);
    }

    @Then("I fill and send the form")
    @Step("I fill and send the form")
    public void fillAndSendFormContact() {
        assertFalse(incidencePage.fillAndSendFormContact(), "The form is not filled");
        Log.info("The form is filled");
    }

    @Then("I check de incidences")
    @Step("I check de incidences")
    public void checkIncidences() {
        assertFalse(incidencePage.checkIncidences(), "The incidences are not correct");
        Log.info("The incidences are correct");
    }

}
