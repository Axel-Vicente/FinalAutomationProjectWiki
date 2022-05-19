package stepdef;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pageobjects.AffinityPage;
import pageobjects.SearchPage;
import utils.ParentTestCase;

import static org.testng.Assert.assertFalse;

public class SearchEngineStepDef extends ParentTestCase {
    private SearchPage searchPage;

    public SearchEngineStepDef(TestContext context) {
        super(context);
        searchPage = new SearchPage(this.driver);
    }

    @When("I search for a {string}")
    @Step("I search for a {0}")
    public void searchMonster(String monster) {
        assertFalse(searchPage.searchMonster(monster), "Couldn't search monster");
        Log.info("It was possible to search monster");
    }

    @Then("I should see {string}, {string}, {string} in the search results")
    @Step("I should see {0}, {0}, {0} in the search results")
    public void checkMonsterFound(String name, String life, String dices) {
        assertFalse(searchPage.checkMonsterFound(name, life, dices), "Monster is not found");
        Log.info("Monster is found");
    }

}
