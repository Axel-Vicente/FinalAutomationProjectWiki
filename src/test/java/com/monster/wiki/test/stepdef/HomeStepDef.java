package com.monster.wiki.test.stepdef;

import com.monster.wiki.context.TestContext;
import com.monster.wiki.pageobjects.AffinityPage;
import com.monster.wiki.utils.ParentTestCase;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static org.testng.Assert.assertFalse;

public class HomeStepDef extends ParentTestCase {
    private AffinityPage affinityPage;


    public HomeStepDef(TestContext context) {
        super(context);
        affinityPage = new AffinityPage(this.driver);
    }

    @Then("I check the main description of the page")
    @Step("I check the main description of the page")
    public void checkDescription() {
        assertFalse(affinityPage.checkDescription(), "The description is not correct");
        Log.info("The description is correct");
    }

}
