package stepdef;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pageobjects.AffinityPage;
import utils.ParentTestCase;

import static org.testng.Assert.assertFalse;

public class RoutingStepDef extends ParentTestCase {
    private AffinityPage affinityPage;


    public RoutingStepDef(TestContext context) {
        super(context);
        affinityPage = new AffinityPage(this.driver);
    }

    @Given("I am on the home page")
    @Step("I am on the home page")
    public void userIsOnHomepage() {
        assertFalse(affinityPage.checkHomePage(), "Home page is not displayed");
        Log.info("User is on home page");
    }

    @When("I click on {string} in the header")
    @Step("I click on {0} in the header")
    public void userNavigatesThroughTheHeader(String headerName) {
        assertFalse(affinityPage.clickOnHeaderElement(headerName), "Couldn't click on header element");
        Log.info("It was possible to click on the header item");
    }

    @Then("I check that I'm in {string}")
    @Step("I check that I'm in {0}")
    public void checkRoutingUrl(String urlText) {
        assertFalse(affinityPage.checkRoutingUrl(urlText), "Couldn't check routing url");
        Log.info("It was possible to check routing url");
    }

}
