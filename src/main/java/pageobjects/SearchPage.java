package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementWeb;

import java.util.logging.Logger;

public class SearchPage extends ElementWeb {
    @FindBy(xpath = "//div[@class='card card-section input-container']/child::input[@placeHolder='Buscar']")
    private WebElement searchInput;

    private static final Logger LOG = Logger.getLogger(SearchPage.class.getName());

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Search for a monster")
    public boolean searchMonster(String monster) {
        boolean error = false;
        try {
            informField(searchInput, monster);
            LOG.info("Search for a monster: " + monster);
        } catch (Exception e) {
            e.printStackTrace();
            error = true;
        }

        return error;
    }

    @Step("Check if monster is found")
    public boolean checkMonsterFound(String name, String life, String dices) {
        boolean error = false;
        try {
            By nameStat = By.xpath("//div[@class='card card-section article-container']/descendant::div[text()='" + name + "']");
            By lifeStat = By.xpath("//div[@class='card card-section article-container']/descendant::div[text()='" + life + "']");
            By dicesStat = By.xpath("//div[@class='card card-section article-container']/descendant::div[text()='" + dices + "']");
            WebElement nameStatResult = driver.findElement(nameStat);
            LOG.info("Check if monster is found: " + nameStatResult.getText());
            WebElement lifeStatResult = driver.findElement(lifeStat);
            LOG.info("Check if life is found: " + lifeStatResult.getText());
            WebElement dicesStatResult = driver.findElement(dicesStat);
            LOG.info("Check if dices is found: " + dicesStatResult.getText());
        } catch (Exception e) {
            e.printStackTrace();
            error = true;
        }

        return error;
    }
}
