package stepdef;

import com.monster.wiki.context.TestContext;
import com.monster.wiki.utils.ParentTestCase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import com.monster.wiki.pageobjects.SearchPage;

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

    @Then("I check that the text {string} does not disappear after a search")
    @Step("I check that the text {0} does not disappear after a search")
    public void checkDefaultSearchText(String text) {
        assertFalse(searchPage.checkDefaultSearchText(text), "Text is not found");
        Log.info("Text is found");
    }

}
