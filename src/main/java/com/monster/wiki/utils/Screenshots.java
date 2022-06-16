package com.monster.wiki.utils;

import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmentable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Logger;

@Augmentable
public class Screenshots {
    private static String screenshotPath = System.getProperty("user.dir") + "/screenshots/";
    private static final Logger LOG = Logger.getLogger(ElementWeb.class.getName());

    @Attachment(value = "Screenshot jpg attachment", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver, Scenario scenario) {
        String extId = getScenarioExtId(scenario.getName());
        String fileName = Utils.generateFileName(extId);
        byte[] screenshot = null;
        try{
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(getScreenshotPath(extId) + fileName));
            screenshot = Files.readAllBytes(Paths.get(screenshotFile.toURI()));
        }catch (IOException e){
            LOG.severe("Error attaching screenshot: " + e.getMessage());
        }catch (UnhandledAlertException e){
            screenshot = takeScreenshotRobot(extId, fileName);
        }
        return screenshot;
    }

    @NotNull
    @Attachment(value = "Screenshot jpg attachment", type = "image/png")
    public static byte[] takeScreenshotRobot(String extId, String fileName) {
        byte[] allbytes = null;
        LOG.info("Taking screenshot...");
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            File imageFile = new File(getScreenshotPath(extId) + fileName);
        }catch (AWTException e){
            LOG.severe("Error taking screenshot: " + e.getMessage());
        }
        return allbytes;
    }

    public static String getLastScreenshot(String extId) {
        File folder = new File(getScreenshotPath(extId));
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null && listOfFiles.length > 1) {
            Arrays.sort(listOfFiles, (File f1, File f2) ->  Long.valueOf(f1.lastModified()).compareTo(f2.lastModified()));
        }

        assert listOfFiles != null;
        return getScreenshotPath(extId) + listOfFiles[listOfFiles.length - 1].getName();
    }

    public static String getScenarioExtId(String name) {
        return name.substring(0, name.indexOf("_"));
    }

    public static String getScreenshotPath(String extId) {
        return screenshotPath + extId + File.separator;
    }
}
