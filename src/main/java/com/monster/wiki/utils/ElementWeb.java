package com.monster.wiki.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.logging.Logger;

public class ElementWeb {
    private static final long TIME_LIMIT = 60;
    private static final long IMPLICIT_WAIT = 150;

    protected WebDriver driver;
    protected static WebDriverWait waitDriver;
    private static final Logger LOG = Logger.getLogger(ElementWeb.class.getName());
    public static final Properties prop = null;

    public ElementWeb(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.waitDriver = new WebDriverWait(driver, IMPLICIT_WAIT);
    }

    public void clickOnWebElement(WebElement element){
        long time = 0;
        boolean clickDone = false;
        while (!clickDone && time < TIME_LIMIT){
            try {
                LOG.info("Trying to click on the element...");
                waitElement(element);
                element.click();
                LOG.info("clicked on the element.");
                clickDone = true;
            }catch (org.openqa.selenium.StaleElementReferenceException
                    | org.openqa.selenium.ElementClickInterceptedException e){
                LOG.severe("Exception in clickOnWebElement: " + e);
                wait(2000);
                time = time + 2;
            }
        }
    }

    public void informField(WebElement element, String information){
        long time = 0;
        boolean informField = false;
        while (!informField && time < TIME_LIMIT){
            try {
                LOG.info("Trying to inform the element...");
                waitElement(element);
                element.sendKeys(information);
                LOG.info("informed the element. Text: " + information);
                informField = true;
            }catch (org.openqa.selenium.ElementNotInteractableException e){
                LOG.severe("Exception in informField: " + e);
                wait(2000);
                time = time + 2;
            }
        }
    }

    public void informField(WebElement element, String information, boolean hideText){
        long time = 0;
        boolean informField = false;
        while (!informField && time < TIME_LIMIT){
            try {
                LOG.info("Trying to inform the element...");
                waitElement(element);
                element.sendKeys(information);
                LOG.info("informed the element.");
                informField = true;
            }catch (org.openqa.selenium.ElementNotInteractableException e){
                LOG.severe("Exception in informField: " + e);
                wait(2000);
                time = time + 2;
            }
        }
    }

    public void waitElement(WebElement element){
        waitDriver.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElement(By locator){
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean waitElement(String xpath){
        boolean error = true;
        WebElement element = driver.findElement(By.xpath(xpath));
        waitElement(element);
        error = false;

        return error;
    }

    public static void wait(int millisecs){
        try{
            System.out.println("Wait: " + millisecs);
            Thread.sleep(millisecs);
        }catch (InterruptedException e){
            System.out.println("Wait interrupted");
        }
    }
}
