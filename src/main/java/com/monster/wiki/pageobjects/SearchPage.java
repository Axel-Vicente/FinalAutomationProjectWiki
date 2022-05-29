package com.monster.wiki.pageobjects;

import com.monster.wiki.utils.ElementWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class SearchPage extends ElementWeb {
    @FindBy(xpath = "//div[@class='card card-section input-container']/child::input[@placeHolder='Buscar']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@class='card card-section article-container']/child::div")
    private WebElement searchResult;
    @FindBy(xpath = "//div[@class='card card-section article-container']")
    private WebElement articleContainer;

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
    public boolean checkMonsterFound(String name, String life, String dices, String type, String experience, String hitPoints) {
        boolean error = false;
        try {
            verifyMonster(name);
            verifyMonster(life);
            verifyMonster(dices);
            verifyMonster(type);
            verifyMonster(experience);
            verifyMonster(hitPoints);
        } catch (Exception e) {
            e.printStackTrace();
            error = true;
        }

        return error;
    }

    private void verifyMonster(String nameStat) {
        By stat = By.xpath("//div[@class='card card-section article-container']/descendant::div[text()='" + nameStat + "']");
        waitElement(stat);
        WebElement nameStatResult = driver.findElement(stat);
        LOG.info("Check if monster is found: " + nameStatResult.getText());
    }

    @Step("Check that the default text doesn't disappear after a search")
    public boolean checkDefaultSearchText(String defaultText) {
        boolean error = false;
        boolean disappearText = false;
        String textToSearch = "goblin";
        try {
            waitElement(searchResult);
            if (searchResult.getText().equals(defaultText)) {
                LOG.info("The text is displayed correctly before searching: " + searchResult.getText());
            }else{
                error = true;
                LOG.severe("Default text does not appear before search");
            }
            informField(searchInput, textToSearch);
            wait(1000);
            disappearText = !searchResult.getText().equals(defaultText) ? true : false;
            clearField(searchInput);
            wait(1000);
            if (disappearText && searchResult.getText().equals(defaultText)) {
                LOG.info("The text is displayed correctly after searching: " + searchResult.getText());
            }else{
                error = true;
                LOG.severe("Default text does not disappear after search");
            }
        } catch (Exception e) {
            e.printStackTrace();
            error = true;
        }

        return error;
    }
}
