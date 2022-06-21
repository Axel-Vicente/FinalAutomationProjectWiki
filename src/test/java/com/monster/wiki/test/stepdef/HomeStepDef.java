package com.monster.wiki.test.stepdef;

import com.monster.wiki.context.TestContext;
import com.monster.wiki.pageobjects.AffinityPage;
import com.monster.wiki.utils.ParentTestCase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static org.testng.Assert.assertFalse;

public class HomeStepDef extends ParentTestCase {
    private AffinityPage affinityPage;


    public HomeStepDef(TestContext context) {
        super(context);
        affinityPage = new AffinityPage(this.driver);
    }

    @Given("access the wiki and login with user {string}")
    @Step("access the wiki and login with user {0}")
    public void accessTheWikiAndLogin(String user) {
        assertFalse(affinityPage.accessTheWikiAndLogin(user), "Error in access the wiki and login");
        Log.info("access the wiki and login");
    }

    @Then("I check the main description of the page")
    @Step("I check the main description of the page")
    public void checkDescription() {
        assertFalse(affinityPage.checkDescription(), "The description is not correct");
        Log.info("The description is correct");
    }

    @Then("I check the icon {string}")
    @Step("I check the icon {0}")
    public void checkSvgIcon(String iconName) {
        assertFalse(affinityPage.checkSvgIcon(iconName), "The icon is not correct");
        Log.info("The icon is correct");
    }

    @Then("I check the footer of the page")
    @Step("I check the footer of the page")
    public void checkFooter() {
        assertFalse(affinityPage.checkFooter(), "The icon is not correct");
        Log.info("The icon is correct");
    }

}
