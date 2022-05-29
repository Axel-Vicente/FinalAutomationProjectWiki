package com.monster.wiki.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.logging.Logger;


public class WebEventListener extends ElementWeb implements WebDriverEventListener {
    String message = "";
    private final Logger LOG = Logger.getLogger(WebEventListener.class.getName());

    public WebEventListener(WebDriver driver) {
        super(driver);
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        this.message = "Before navigating to: '" + url + "'";
        LOG.info(this.message);
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        this.message = "Navigated to:'" + url + "'";
        LOG.info(this.message);
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        driver.toString();
        this.message = "Value of the:" + element.toString() + " before any changes made";
        LOG.info(this.message);
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        driver.toString();
        this.message = "Element value changed to: " + element.toString();
        LOG.info(this.message);
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        driver.toString();
        this.message = "Trying to click on: " + element.toString();
        LOG.info(this.message);
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        driver.toString();
        this.message = "Clicked on: " + element.toString();
        LOG.info(this.message);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    public void beforeNavigateBack(WebDriver driver) {
        driver.toString();
        this.message = "Navigating back to previous page";
        LOG.info(this.message);
    }

    public void afterNavigateBack(WebDriver driver) {
        driver.toString();
        this.message = "Navigated back to previous page";
        LOG.info(this.message);
    }

    public void beforeNavigateForward(WebDriver driver) {
        driver.toString();
        this.message = "Navigating forward to next page";
        LOG.info(this.message);
    }

    public void afterNavigateForward(WebDriver driver) {
        driver.toString();
        this.message = "Navigated forward to next page";
        LOG.info(this.message);
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        driver.toString();
        this.message = "Trying to find Element By : " + by.toString();
        LOG.info(this.message);
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        driver.toString();
        this.message = "Found Element By : " + by.toString();
        LOG.info(this.message);
    }

    public void onException(Throwable error, WebDriver driver) {
        driver.toString();
        this.message = "Exception occured: " + error;
        LOG.info(this.message);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }

    public void beforeAlertAccept(WebDriver driver) {
        driver.toString();
        this.message = "Before accepting alert";
        LOG.info(this.message);
    }

    public void afterAlertAccept(WebDriver driver) {
        driver.toString();
        this.message = "Alert accepted";
        LOG.info(this.message);
    }

    public void beforeAlertDismiss(WebDriver driver) {
        driver.toString();
        this.message = "Before dismissing alert";
        LOG.info(this.message);
    }

    public void afterAlertDismiss(WebDriver driver) {
        driver.toString();
        this.message = "Alert dismissed";
        LOG.info(this.message);
    }
}
