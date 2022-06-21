package com.monster.wiki.test.stepdef;

import com.monster.wiki.context.TestContext;
import com.monster.wiki.pageobjects.AffinityPage;
import com.monster.wiki.pageobjects.LoginPage;
import com.monster.wiki.utils.ParentTestCase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

import static org.testng.Assert.assertFalse;

public class LoginStepDef extends ParentTestCase {
    private AffinityPage affinityPage;
    private LoginPage loginPage;


    public LoginStepDef(TestContext context) {
        super(context);
        affinityPage = new AffinityPage(this.driver);
        loginPage = new LoginPage(this.driver);
    }

    @When("I cancel the login")
    @Step("I cancel the login")
    public void cancelLogin() {
        assertFalse(loginPage.cancelLogin(), "The user is logged");
        Log.info("The user is not logged");
    }

    @Then("I should see the error message")
    @Step("I should see the error message")
    public void checkErrorMessage() {
        assertFalse(loginPage.checkErrorMessage(), "The error message is not correct");
        Log.info("The error message is correct");
    }

    @Then("I check the admin user")
    @Step("I check the admin user")
    public void checkAdminUser() {
        assertFalse(loginPage.checkAdminUser(), "The user " + affinityPage.getUserName() + " is not admin");
        Log.info("The user " + affinityPage.getUserName() + " is admin");
    }

}
