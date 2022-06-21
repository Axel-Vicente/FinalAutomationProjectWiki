package com.monster.wiki.pageobjects;

import com.monster.wiki.utils.ElementWeb;
import com.monster.wiki.utils.PropertiesFile;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;
import java.util.logging.Logger;

public class LoginPage extends ElementWeb {
    @FindBy(xpath = "//input[@placeholder='usuario']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[contains(@placeholder, 'datos err')]")
    private WebElement inputErrorLogin;
    @FindBy(xpath = "//button[contains(text(), 'Cancelar')]")
    private WebElement buttonCancel;
    @FindBy(xpath = "//div[text()='Login']")
    private WebElement divLogin;
    @FindBy(xpath = "//div[contains( @class, 'background-primary-white') and @id='header']")
    private WebElement styleHeaderForAdmin;

    private static final Logger LOG = Logger.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Cancel the login")
    public boolean cancelLogin() {
        boolean error = false;

        waitElement(inputUserName);
        clickOnWebElement(buttonCancel);

        waitElement(divLogin);
        LOG.info("user not logged");

        return error;
    }

    @Step("Check error message")
    public boolean checkErrorMessage() {
        boolean error = false;

        try {
            waitElement(inputErrorLogin);
            LOG.info("error message found");
        } catch (Exception e) {
            error = true;
            LOG.severe("no error message");
        }

        return error;
    }

    @Step("Check if user is admin")
    public boolean checkAdminUser() {
        boolean error = false;

        try {
            waitElement(styleHeaderForAdmin);
        } catch (Exception e) {
            error = true;
        }

        return error;
    }

    @Step("Check alert message")
    public boolean checkAlertMessage(String message) {
        boolean error = false;
        By contact= By.xpath("//div[@id='header']/descendant::a[text()='Contactanos']");
        WebElement contactElement = driver.findElement(contact);
        waitElement(contactElement);
        clickOnWebElement(contactElement);

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        try {
            if (alertMessage.equals(message)) {
                LOG.info("alert message found");
                alert.accept();
            } else {
                error = true;
                alert.dismiss();
                LOG.severe("no alert message");
            }
            wait(2000);
            alert.dismiss();
            driver.close();
        } catch (Exception e) {
            LOG.severe("no alert message");
        }

        driver.switchTo().defaultContent();
        waitElement(divLogin);

        return error;
    }
}