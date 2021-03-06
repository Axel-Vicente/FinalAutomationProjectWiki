package com.monster.wiki.pageobjects;

import com.monster.wiki.utils.PropertiesFile;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.monster.wiki.utils.ElementWeb;

import java.util.logging.Logger;

public class AffinityPage extends ElementWeb {
    @FindBy(xpath = "//div[@class='card card-main']/h2")
    private WebElement descriptionTextHome;

    private static final Logger LOG = Logger.getLogger(AffinityPage.class.getName());

    public AffinityPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if user is on index page")
    public boolean checkHomePage(){
        String url = driver.getCurrentUrl();
        boolean error = url.contains("home") ? false : true;

        return error;
    }

    @Step("Check click on element of header")
    public boolean clickOnHeaderElement(String element){
        boolean error = false;
        By headerText = By.xpath("//div[@id='header']/descendant::a[text()='" + element + "']");
        WebElement headerElement = driver.findElement(headerText);

        try{
            waitElement(headerElement);
            clickOnWebElement(headerElement);
        }catch (Exception e){
            error = true;
        }
        return error;
    }

    @Step("Check routing to correct page")
    public boolean checkRoutingUrl(String urlText){
        String currentUrl = driver.getCurrentUrl();
        boolean error = currentUrl.contains(urlText) ? false : true;

        return error;
    }

    @Step("I check the main description of the page")
    public boolean checkDescription(){
        LOG.info("Checking the main description of the page");
        waitElement(descriptionTextHome);
        boolean error = !descriptionTextHome.getText().equals(PropertiesFile.readFileProperties("default_text_home"));

        return error;
    }
}
