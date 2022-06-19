package com.monster.wiki.pageobjects;

import com.monster.wiki.utils.PropertiesFile;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.monster.wiki.utils.ElementWeb;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AffinityPage extends ElementWeb {
    @FindBy(xpath = "//div[@class='card card-main']/h2")
    private WebElement descriptionTextHome;
    @FindBy(xpath = "//div[@id='footer']/descendant::span")
    private WebElement spanTextFooter;
    @FindBy(xpath = "//div[@id='footer']/descendant::a[text()='D&D 5e API']")
    private WebElement linkApiFooter;

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
        if (!error){
            LOG.info("The description is correct");
        }

        return error;
    }

    @Step("I check the footer of the page")
    public boolean checkFooter(){

        LOG.info("Checking the footer of the page");
        waitElement(spanTextFooter);
        boolean errorFooter = !spanTextFooter.getText().equals(PropertiesFile.readFileProperties("default_text_footer"));
        if (!errorFooter){
            LOG.info("The footer text is correct");
        }

        waitElement(linkApiFooter);
        clickOnWebElement(linkApiFooter);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        boolean errorApiUrl = !driver.getCurrentUrl().equals(PropertiesFile.readFileProperties("url_api_dnd"));
        if (!errorApiUrl){
            LOG.info("The footer link is correct");
        }

        driver.close();
        driver.switchTo().window(tabs.get(0));
        boolean error = !errorFooter && !errorApiUrl ? false : true;

        return error;
    }

    @Step("I check the svg icons of the page")
    public boolean checkSvgIcon(String iconName){
        boolean error = false;
        By icon = By.xpath("//*[local-name()='svg' and @data-icon='" + iconName + "']");

        try {
            LOG.info("Checking the svg icon of the page");
            WebElement iconElement = driver.findElement(icon);
            waitElement(iconElement);
        } catch (Exception e) {
            LOG.severe("The icon " + iconName + " is not found");
            error = true;
        }
        LOG.info("The icon " + iconName + " is found");

        return error;
    }
}
