package com.monster.wiki.base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {
    public TestNgListener() {
    }

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot",type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html){
        return html;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        saveTextLog(getTestMethodName(iTestResult) + " test has started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        saveTextLog(getTestMethodName(iTestResult) + " test has passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveTextLog(getTestMethodName(iTestResult) + " test has failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        saveTextLog(getTestMethodName(iTestResult) + " test has been skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        saveTextLog(getTestMethodName(iTestResult) + " test has failed but within success percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        saveTextLog(iTestContext.getName() + " test suite has started");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        saveTextLog(iTestContext.getName() + " test suite has finished");
    }
}
